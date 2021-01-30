
package service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkBalance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkBalance"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acc" type="{http://service/}costomerAccount" minOccurs="0"/&gt;
 *         &lt;element name="moneyToPaid" type="{http://www.w3.org/2001/XMLSchema}float"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkBalance", propOrder = {
    "acc",
    "moneyToPaid"
})
public class CheckBalance {

    protected CostomerAccount acc;
    protected float moneyToPaid;

    /**
     * Gets the value of the acc property.
     * 
     * @return
     *     possible object is
     *     {@link CostomerAccount }
     *     
     */
    public CostomerAccount getAcc() {
        return acc;
    }

    /**
     * Sets the value of the acc property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostomerAccount }
     *     
     */
    public void setAcc(CostomerAccount value) {
        this.acc = value;
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

}
