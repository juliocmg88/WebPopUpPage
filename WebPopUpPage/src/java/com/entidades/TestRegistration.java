/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "test_registration")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TestRegistration.findAll", query = "SELECT t FROM TestRegistration t")
    , @NamedQuery(name = "TestRegistration.findByUserId", query = "SELECT t FROM TestRegistration t WHERE t.userId = :userId")
    , @NamedQuery(name = "TestRegistration.findByFirstname", query = "SELECT t FROM TestRegistration t WHERE t.firstname = :firstname")
    , @NamedQuery(name = "TestRegistration.findByMiddlename", query = "SELECT t FROM TestRegistration t WHERE t.middlename = :middlename")
    , @NamedQuery(name = "TestRegistration.findByLastname", query = "SELECT t FROM TestRegistration t WHERE t.lastname = :lastname")
    , @NamedQuery(name = "TestRegistration.findByEmail", query = "SELECT t FROM TestRegistration t WHERE t.email = :email")
    , @NamedQuery(name = "TestRegistration.findByPhone", query = "SELECT t FROM TestRegistration t WHERE t.phone = :phone")
    , @NamedQuery(name = "TestRegistration.findByUsername", query = "SELECT t FROM TestRegistration t WHERE t.username = :username")
    , @NamedQuery(name = "TestRegistration.findByPassword", query = "SELECT t FROM TestRegistration t WHERE t.password = :password")
    , @NamedQuery(name = "TestRegistration.findBySlowHashSalt", query = "SELECT t FROM TestRegistration t WHERE t.slowHashSalt = :slowHashSalt")
    , @NamedQuery(name = "TestRegistration.findByNivel", query = "SELECT t FROM TestRegistration t WHERE t.nivel = :nivel") 
    , @NamedQuery(name = "TestRegistration.findByUsernameAndPassword", query = "SELECT t FROM TestRegistration t WHERE t.username = :username and t.password= :password")})
public class TestRegistration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "slowHashSalt")
    private String slowHashSalt;
    @Column(name = "nivel")
    private Integer nivel;

    public TestRegistration() {
    }

    public TestRegistration(Integer userId) {
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getSlowHashSalt() {
        return slowHashSalt;
    }

    public void setSlowHashSalt(String slowHashSalt) {
        this.slowHashSalt = slowHashSalt;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TestRegistration)) {
            return false;
        }
        TestRegistration other = (TestRegistration) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.TestRegistration[ userId=" + userId + " ]";
    }
    
}
