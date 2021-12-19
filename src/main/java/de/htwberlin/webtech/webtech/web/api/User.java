package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.RoleEntity;

public class User {
    private long userId;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private String adresse;
    private String role;
    private Long bucketId;
    //public BucketEntity bucket;

    public User(long userId, String login, String password, String firstName, String lastName, String adresse, String role, Long bucketId) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.role = role;
        this.bucketId = bucketId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
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

    public String  getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Long getBucket() {
        return bucketId;
    }

    public void setBucket(Long bucketId) {
        this.bucketId = bucketId;
    }
}
