package com.easybuy.model;

import javax.persistence.*;
import java.util.Set;

@Table(name = "user")
@Entity
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "user_pass")
    private String userPass;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "address")
    private String address;
    @Column(name = "mobile")
    private Integer mobile;
    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user")
    private Set<Cart> carts;

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }



    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId + '\'' +
                "userName=" + userName + '\'' +
                "userPass=" + userPass + '\'' +
                "firstName=" + firstName + '\'' +
                "lastName=" + lastName + '\'' +
                "address=" + address + '\'' +
                "mobile=" + mobile + '\'' +
                "email=" + email + '\'' +
                '}';
    }
}
