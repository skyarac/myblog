package com.wetuo.blog.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="lh_user")
public class User  implements java.io.Serializable {
	private static final long serialVersionUID = -4322044909680835588L;
    private Long userId;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private Date registerTime;
    private Date loginTime;
    private String loginIp;
    private String activationKey;
    private Integer status;
    private String remarks;
    private Set<Blog> blogs = new HashSet<Blog>(0);

    @Id
    @GeneratedValue
    @Column(name="user_id", unique=true, nullable=false)
    public Long getUserId() {
        return this.userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Column(name="username", length=60)
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", length=32)
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name="nickname", length=50)
    public String getNickname() {
        return this.nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    @Column(name="email", length=100)
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Column(name="register_time", length=29)
    public Date getRegisterTime() {
        return this.registerTime;
    }
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }
    @Column(name="login_time", length=29)
    public Date getLoginTime() {
        return this.loginTime;
    }
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
    @Column(name="login_ip", length=100)
    public String getLoginIp() {
        return this.loginIp;
    }
    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
    @Column(name="activation_key", length=60)
    public String getActivationKey() {
        return this.activationKey;
    }
    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }
    @Column(name="status")
    public Integer getStatus() {
        return this.status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    @Column(name="remarks")
    public String getRemarks() {
        return this.remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
    public Set<Blog> getBlogs() {
        return this.blogs;
    }
    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}