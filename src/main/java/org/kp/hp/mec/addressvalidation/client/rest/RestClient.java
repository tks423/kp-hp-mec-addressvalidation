package org.kp.hp.mec.addressvalidation.client.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.kp.hp.mec.addressvalidation.server.exception.WebServiceException;
import org.kp.hp.mec.addressvalidation.vo.AddressInputVO;
import org.kp.hp.mec.addressvalidation.vo.AddressOutputVO;
import org.kp.hp.mec.addressvalidation.vo.AddressValidationRequest;

import java.util.ArrayList;
import java.util.List;

public class RestClient {

    private static final String REST_URI = "https://psp-dev.ssdc.kp.org/pspcass/validate";
    private Client client = ClientBuilder.newClient();


    public List<AddressOutputVO> callPspWS() {
        AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
        AddressInputVO addressInputVO = new AddressInputVO();
        addressInputVO.setAddressLine1("75 N Fair Oaks Ave");
        addressInputVO.setAddressLine2("");
        addressInputVO.setCity("Pasadena");
        addressInputVO.setState("CA");
        addressInputVO.setZipCode("91103");

        List<AddressInputVO> addressInputVOs = new ArrayList();
        addressInputVOs.add(addressInputVO);

        addressValidationRequest.setAddresses(addressInputVOs);
        addressValidationRequest.setSystemName("Name of the System Sending Address for Address Validation");
        addressValidationRequest.setRequestId("Upstream system can provide this id for debug purpose");
        addressValidationRequest.setRecordCount(String.valueOf(addressInputVOs.size()));
        addressValidationRequest.setSystemId("W041902");

        Response response = client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(addressValidationRequest, MediaType.APPLICATION_JSON));

        //If status is not OK, e.g. HTTP Status 404
        if(!response.getStatusInfo().getReasonPhrase().equals(Response.Status.OK.toString())){
            throw new WebServiceException("HTTP Status " + response.getStatus() + ": " + response.getStatusInfo().getReasonPhrase()
            + " - Check with DataPower if proxy server is down or with PSP to check to see if CASS web service is down");
        }

        List<AddressOutputVO> addressOutputVOS = response.readEntity(List.class);

        return addressOutputVOS;
    }

    public static void main (String args[]){
        RestClient restClient = new RestClient();
        restClient.callPspWS();
    }
}
