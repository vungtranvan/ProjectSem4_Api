package view_models;

import java.io.Serializable;

/**
 *
 * @author vungk
 */
public class ChangPasswordVm implements Serializable {

    private int userId;
    private String password;
    private String confirmPassword;

    public ChangPasswordVm() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
