package org.kp.hp.mec.addressvalidation.vo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

/**
 * https://stackoverflow.com/a/10980546
 */
public class AddressOutputVOPredicate implements Predicate{
    private Object expected;
    private String propertyName;

    public AddressOutputVOPredicate(String propertyName, Object expected) {
        super();
        this.propertyName = propertyName;
        this.expected = expected;
    }

    public boolean evaluate(Object object) {
        try {
            //https://commons.apache.org/proper/commons-beanutils/apidocs/org/apache/commons/beanutils/PropertyUtils.html
            //Utility methods for using Java Reflection APIs to facilitate generic property getter and setter operations on Java objects.
            return expected.equals(PropertyUtils.getProperty(object, propertyName));
        } catch (Exception e) {
            return false;
        }
    }

}
