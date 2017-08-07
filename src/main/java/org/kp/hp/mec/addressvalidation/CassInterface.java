package org.kp.hp.mec.addressvalidation;

import org.kp.hp.mec.addressvalidation.vo.AddressInputVO;
import org.kp.hp.mec.addressvalidation.vo.AddressInputVO;
import org.kp.hp.mec.addressvalidation.vo.AddressOutputVO;

import java.util.List;

/**
 * Created by w371371 on 6/27/2017.
 */
public interface CassInterface {

    /**
     * * Validate addresses via CASS
     *   See email from Mon 7/24/2017 10:19 AM RE: CASS: Number of addresses to send and number of concurrent requests
     *   according to PSP, don't send more than 100 addresses in one request. Therefore the property in DB
     *   CASS_NUMBER_OF_ADDRESSES_TO_SEND_PER_CONNECTION should be set to 100 -- this determines how many
     *   List<List<AddressInputVO>> lists there are.
     *
     * @return
     */
    List<AddressOutputVO> performBatchAddressValidation(List<List<AddressInputVO>> lists, int sizeOfAddressInputVOs,
                                                        int cassNumberOfCassConnections);
}

