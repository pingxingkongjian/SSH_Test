package demo.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by 三千繁华 on 2017/10/16.11:14
 */
@Entity
@Table(name="ssh_user")
public class User extends IdEntity{
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private Date ct;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCt() {
        return ct;
    }

    public void setCt(Date ct) {
        this.ct = ct;
    }
}
