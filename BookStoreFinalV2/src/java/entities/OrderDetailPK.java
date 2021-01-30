package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class OrderDetailPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "BookIsbn")
    private int bookIsbn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderId")
    private int orderId;

    public OrderDetailPK() {
    }

    public OrderDetailPK(int bookIsbn, int orderId) {
        this.bookIsbn = bookIsbn;
        this.orderId = orderId;
    }

    public int getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(int bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    @Override
    public String toString() {
        return "entities.OrderDetailPK[ bookIsbn=" + bookIsbn + ", orderId=" + orderId + " ]";
    }
    
}
