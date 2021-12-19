package de.htwberlin.webtech.webtech.persistence;

import javax.persistence.*;

@Entity(name = "users")
public class UserEntity {
    private static final String SEQ_NAME = "user_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "login", nullable = false) //TO DO
    private String login;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "adresse", nullable = false)
    private String adresse;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEntity role;

   // @OneToOne(cascade = CascadeType.REMOVE)
    @OneToOne(mappedBy = "user")
    private BucketEntity bucket;

    public UserEntity(String login, String password, String firstName, String lastName, String adresse, RoleEntity role) {

        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.adresse = adresse;
        this.role = role;
    }

//    public UserEntity(String login, String password, String firstName, String lastName, String adresse, RoleEntity role, BucketEntity bucket) {
//
//        this.login = login;
//        this.password = password;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.adresse = adresse;
//        this.role = role;
//        this.bucket = bucket;
//    }

    protected UserEntity() {

    }



    public long getUserId() {
        return userId;
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

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public BucketEntity getBucket() {
        return bucket;
    }

    public void setBucket(BucketEntity bucket) {
        this.bucket = bucket;
    }



    // protected UserEntity() {};

/*    public String getFirstName() {
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
    }*/
}
