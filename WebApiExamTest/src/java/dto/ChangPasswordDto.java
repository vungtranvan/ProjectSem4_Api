package dto;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class ChangPasswordDto implements Serializable {

    private String userName;
    private String password;
    private String confirmPassword;

    public ChangPasswordDto() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}