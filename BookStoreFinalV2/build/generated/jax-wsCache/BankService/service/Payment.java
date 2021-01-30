
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for payment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="payment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accPaid" type="{http://service/}costomerAccount" minOccurs="0"/&gt;
 *         &lt;element name="moneyToPaid" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *         &lt;element name="webId" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "payment", propOrder = {
    "accPaid",
    "moneyToPaid",
    "webId"
})
public class Payment {

    protected CostomerAccount accPaid;
    protected float moneyToPaid;
    protected int webId;

    /**
     * Gets the value of the accPaid property.
     * 
     * @return
     *     possible object is
     *     {@link CostomerAccount }
     *     
     */
    public CostomerAccount getAccPaid() {
        return accPaid;
    }

    /**
     * Sets the value of the accPaid property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostomerAccount }
     *     
     */
    public void setAccPaid(CostomerAccount value) {
        this.accPaid = value;
    }

    /**
     * Gets the value of the moneyToPaid property.
     * 
     */
    public float getMoneyToPaid() {
        return moneyToPaid;
    }

    /**
     * Sets the value of the moneyToPaid property.
     * 
     */
    public void setMoneyToPaid(float value) {
        this.moneyToPaid = value;
    }

    /**
     * Gets the value of the webId property.
     * 
     */
    public int getWebId() {
        return webId;
    }

    /**
     * Sets the value of the webId property.
     * 
     */
    public void setWebId(int value) {
        this.webId = value;
    }

}
