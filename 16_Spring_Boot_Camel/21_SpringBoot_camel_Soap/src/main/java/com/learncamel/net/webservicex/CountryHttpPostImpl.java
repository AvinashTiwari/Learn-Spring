
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.learncamel.net.webservicex;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.1.9
 * 2018-03-19T05:48:35.190-05:00
 * Generated source version: 3.1.9
 * 
 */

@WebService(
                      serviceName = "country",
                      portName = "countryHttpPost",
                      targetNamespace = "http://www.webserviceX.NET",
                      wsdlLocation = "file:/Dilip/Study/ApacheCamel/TeachApacheCamel-Spring-Boot/session-codebase/soap-springws-learncamel-spring-boot-test/src/main/resources/wsdl/country.wsdl",
                      endpointInterface = "net.webservicex.CountryHttpPost")
                      
public class CountryHttpPostImpl implements CountryHttpPost {

    private static final Logger LOG = Logger.getLogger(CountryHttpPostImpl.class.getName());

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCurrencies()*
     */
    public String getCurrencies() {
        LOG.info("Executing operation getCurrencies");
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getISD(java.lang.String countryName)*
     */
    public String getISD(String countryName) {
        LOG.info("Executing operation getISD");
        System.out.println(countryName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCountryByCurrencyCode(java.lang.String currencyCode)*
     */
    public String getCountryByCurrencyCode(String currencyCode) {
        LOG.info("Executing operation getCountryByCurrencyCode");
        System.out.println(currencyCode);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getISOCountryCodeByCountyName(java.lang.String countryName)*
     */
    public String getISOCountryCodeByCountyName(String countryName) {
        LOG.info("Executing operation getISOCountryCodeByCountyName");
        System.out.println(countryName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCurrencyCode()*
     */
    public String getCurrencyCode() {
        LOG.info("Executing operation getCurrencyCode");
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCurrencyByCountry(java.lang.String countryName)*
     */
    public String getCurrencyByCountry(String countryName) {
        LOG.info("Executing operation getCurrencyByCountry");
        System.out.println(countryName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCountries()*
     */
    public String getCountries() {
        LOG.info("Executing operation getCountries");
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCurrencyCodeByCurrencyName(java.lang.String currencyName)*
     */
    public String getCurrencyCodeByCurrencyName(String currencyName) {
        LOG.info("Executing operation getCurrencyCodeByCurrencyName");
        System.out.println(currencyName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getGMTbyCountry(java.lang.String countryName)*
     */
    public String getGMTbyCountry(String countryName) {
        LOG.info("Executing operation getGMTbyCountry");
        System.out.println(countryName);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see net.webservicex.CountryHttpPost#getCountryByCountryCode(java.lang.String countryCode)*
     */
    public String getCountryByCountryCode(String countryCode) {
        LOG.info("Executing operation getCountryByCountryCode");
        System.out.println(countryCode);
        try {
            String _return = "";
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
