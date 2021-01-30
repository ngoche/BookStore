
package service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CheckAccount_QNAME = new QName("http://service/", "checkAccount");
    private final static QName _CheckAccountResponse_QNAME = new QName("http://service/", "checkAccountResponse");
    private final static QName _CheckBalance_QNAME = new QName("http://service/", "checkBalance");
    private final static QName _CheckBalanceResponse_QNAME = new QName("http://service/", "checkBalanceResponse");
    private final static QName _Payment_QNAME = new QName("http://service/", "payment");
    private final static QName _PaymentResponse_QNAME = new QName("http://service/", "paymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CheckAccount }
     * 
     */
    public CheckAccount createCheckAccount() {
        return new CheckAccount();
    }

    /**
     * Create an instance of {@link CheckAccountResponse }
     * 
     */
    public CheckAccountResponse createCheckAccountResponse() {
        return new CheckAccountResponse();
    }

    /**
     * Create an instance of {@link CheckBalance }
     * 
     */
    public CheckBalance createCheckBalance() {
        return new CheckBalance();
    }

    /**
     * Create an instance of {@link CheckBalanceResponse }
     * 
     */
    public CheckBalanceResponse createCheckBalanceResponse() {
        return new CheckBalanceResponse();
    }

    /**
     * Create an instance of {@link Payment }
     * 
     */
    public Payment createPayment() {
        return new Payment();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     * 
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

    /**
     * Create an instance of {@link CostomerAccount }
     * 
     */
    public CostomerAccount createCostomerAccount() {
        return new CostomerAccount();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkAccount")
    public JAXBElement<CheckAccount> createCheckAccount(CheckAccount value) {
        return new JAXBElement<CheckAccount>(_CheckAccount_QNAME, CheckAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkAccountResponse")
    public JAXBElement<CheckAccountResponse> createCheckAccountResponse(CheckAccountResponse value) {
        return new JAXBElement<CheckAccountResponse>(_CheckAccountResponse_QNAME, CheckAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkBalance")
    public JAXBElement<CheckBalance> createCheckBalance(CheckBalance value) {
        return new JAXBElement<CheckBalance>(_CheckBalance_QNAME, CheckBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "checkBalanceResponse")
    public JAXBElement<CheckBalanceResponse> createCheckBalanceResponse(CheckBalanceResponse value) {
        return new JAXBElement<CheckBalanceResponse>(_CheckBalanceResponse_QNAME, CheckBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Payment }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "payment")
    public JAXBElement<Payment> createPayment(Payment value) {
        return new JAXBElement<Payment>(_Payment_QNAME, Payment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PaymentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "paymentResponse")
    public JAXBElement<PaymentResponse> createPaymentResponse(PaymentResponse value) {
        return new JAXBElement<PaymentResponse>(_PaymentResponse_QNAME, PaymentResponse.class, null, value);
    }

}
