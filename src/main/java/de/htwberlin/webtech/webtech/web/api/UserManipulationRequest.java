package de.htwberlin.webtech.webtech.web.api;

import de.htwberlin.webtech.webtech.persistence.BucketEntity;
import de.htwberlin.webtech.webtech.persistence.RoleEntity;

import javax.persistence.*;

public class UserManipulationRequest {

    public String firstName;
    public String lastName;
    public String adresse;
    public String login;
    public String password;
    public String role;
    public BucketEntity bucket;


    public UserManipulationRequest(String firstName, String lastName, String adresse, String login, String password, String role, BucketEntity bucket) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.login = login;
        this.password = password;
        this.role = role;
        this.bucket = bucket;
    }

    public UserManipulationRequest() {
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public BucketEntity getBucket() {
        return bucket;
    }

    public void setBucket(BucketEntity bucket) {
        this.bucket = bucket;
    }
}
