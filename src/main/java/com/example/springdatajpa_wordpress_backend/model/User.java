package com.example.springdatajpa_wordpress_backend.model;

import java.sql.Timestamp;
import java.util.Set;
import org.hibernate.validator.constraints.URL;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "wp_users", indexes = {
    @Index(name = "user_login_key", columnList = "user_login"),
    @Index(name = "user_nicename", columnList = "user_nicename"),
    @Index(name = "user_email", columnList = "user_email")
})
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_login", length = 60)
    @NotNull
    @Size(max = 60)
    private String login;

    @Column(name = "user_pass", length = 255)
    @NotNull
    @Size(max = 255)
    private String password;

    @Column(name = "user_nicename", length = 50)
    @NotNull
    @Size(max = 50)
    private String nicename;

    @Column(name = "user_email", length = 100)
    @Email
    @NotNull
    @Size(max = 100)
    private String email;

    @Column(name = "user_url", length = 100)
    @URL
    @NotNull
    @Size(max = 100)
    private String url;

    @Column(name = "user_registered")
    @NotNull
    private Timestamp registered;

    @Column(name = "user_activation_key", length = 255)
    @NotNull
    @Size(max = 255)
    private String activationKey;

    @Column(name = "user_status")
    @NotNull
    private Integer status;

    // @Column(name = "display_name") can be substitute with @Basic
    // when property name matches the hibernate naming convension and
    // the 'optional' field controls the 'not null' criteria
    @Basic(optional = false)
    @NotNull
    @Size(max = 255)
    private String displayName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<UserMeta> userMetaSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNicename() {
        return nicename;
    }

    public void setNicename(String nicename) {
        this.nicename = nicename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Timestamp getRegistered() {
        return registered;
    }

    public void setRegistered(Timestamp registered) {
        this.registered = registered;
    }

    public String getActivationKey() {
        return activationKey;
    }

    public void setActivationKey(String activationKey) {
        this.activationKey = activationKey;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Set<UserMeta> getUserMetaSet() {
        return userMetaSet;
    }

    public void setUserMetaSet(Set<UserMeta> userMetaSet) {
        this.userMetaSet = userMetaSet;
    }

}
