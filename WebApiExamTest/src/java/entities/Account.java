package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author vungk
 */
@Entity
@Table(name = "Account")
public class Account implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;
    
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "UserName")
    private String userName;
    
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "Password")
    private String password;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name")
    private String name;
    
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Email")
    private String email;
    
    @Size(max = 2147483647)
    @Column(name = "Image")
    private String image;
    
    @Column(name = "Birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    
    @Size(max = 2147483647)
    @Column(name = "Address")
    private String address;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "Sex")
    private boolean sex;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "IsAdmin")
    private boolean isAdmin;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "CreatedDate")
    private Date createdDate;
    
    @Column(name = "UpdatedDate")
    private Date updatedDate;

    public Account() {
    }

    public Account(Integer id) {
        this.id = id;
    }

    public Account(Integer id, String userName, String password, String name, String email, boolean sex, boolean isAdmin, Date createdDate) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.sex = sex;
        this.isAdmin = isAdmin;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }  
}
