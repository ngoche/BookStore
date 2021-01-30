package bookstore.model;

import java.io.Serializable;
import org.hibernate.validator.constraints.NotEmpty;


public class AccountLogin implements Serializable{
    @NotEmpty
    private String userName;
    @NotEmpty
    private String passWord;

    public AccountLogin() {
    }

    public AccountLogin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
