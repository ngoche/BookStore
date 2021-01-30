package bookstore.model;

import java.io.Serializable;

public class PaymentInfo implements Serializable {

    private String accountName;
    private String password;
    private int webId;

    public PaymentInfo() {
    }

    public PaymentInfo(String accountName, String password, int webId) {
        this.accountName = accountName;
        this.password = password;
        this.webId = webId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWebId() {
        return webId;
    }

    public void setWebId(int webId) {
        this.webId = webId;
    }

}
