/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.netcredit;

import java.io.Serializable;
import java.util.Date;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Temporal;

/**
 *
 * @author toka
 */
//@Entity
public class UserEntity implements Serializable {
//    @Id
//    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
//    @Column(unique = true)
    private String username;
    private String password;
    private String phoneNumber;
//    @Temporal(javax.persistence.TemporalType.DATE)
    private Date birthDate;
    private double salary;
    private int liabilities;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getLiabilities() {
        return liabilities;
    }

    public void setLiabilities(int liabilities) {
        this.liabilities = liabilities;
    }

    @Override
    public String toString() {
        return "UserEntity{" + "username=" + username + ", password=" + password + ", phoneNumber=" + phoneNumber + ", birthDate=" + birthDate + ", salary=" + salary + ", liabilities=" + liabilities + '}';
    }

}
