
package service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "BankService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8080/PaymentServices/BankService?wsdl")
public class BankService_Service
    extends Service
{

    private final static URL BANKSERVICE_WSDL_LOCATION;
    private final static WebServiceException BANKSERVICE_EXCEPTION;
    private final static QName BANKSERVICE_QNAME = new QName("http://service/", "BankService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/PaymentServices/BankService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        BANKSERVICE_WSDL_LOCATION = url;
        BANKSERVICE_EXCEPTION = e;
    }

    public BankService_Service() {
        super(__getWsdlLocation(), BANKSERVICE_QNAME);
    }

    public BankService_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), BANKSERVICE_QNAME, features);
    }

    public BankService_Service(URL wsdlLocation) {
        super(wsdlLocation, BANKSERVICE_QNAME);
    }

    public BankService_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, BANKSERVICE_QNAME, features);
    }

    public BankService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns BankService
     */
    @WebEndpoint(name = "BankServicePort")
    public BankService getBankServicePort() {
        return super.getPort(new QName("http://service/", "BankServicePort"), BankService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns BankService
     */
    @WebEndpoint(name = "BankServicePort")
    public BankService getBankServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "BankServicePort"), BankService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (BANKSERVICE_EXCEPTION!= null) {
            throw BANKSERVICE_EXCEPTION;
        }
        return BANKSERVICE_WSDL_LOCATION;
    }

}
