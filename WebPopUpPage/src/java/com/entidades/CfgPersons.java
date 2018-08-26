/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "cfg_persons")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgPersons.findAll", query = "SELECT c FROM CfgPersons c")
    , @NamedQuery(name = "CfgPersons.findById", query = "SELECT c FROM CfgPersons c WHERE c.id = :id")
    , @NamedQuery(name = "CfgPersons.findByTenantId", query = "SELECT c FROM CfgPersons c WHERE c.tenantId = :tenantId")
    , @NamedQuery(name = "CfgPersons.findByLoginid", query = "SELECT c FROM CfgPersons c WHERE c.loginid = :loginid")
    , @NamedQuery(name = "CfgPersons.findByUsername", query = "SELECT c FROM CfgPersons c WHERE c.username = :username")
    , @NamedQuery(name = "CfgPersons.findByUserpwd", query = "SELECT c FROM CfgPersons c WHERE c.userpwd = :userpwd")
    , @NamedQuery(name = "CfgPersons.findByFullname", query = "SELECT c FROM CfgPersons c WHERE c.fullname = :fullname")
    , @NamedQuery(name = "CfgPersons.findByActive", query = "SELECT c FROM CfgPersons c WHERE c.active = :active")
    , @NamedQuery(name = "CfgPersons.findByMailbox", query = "SELECT c FROM CfgPersons c WHERE c.mailbox = :mailbox")
    , @NamedQuery(name = "CfgPersons.findByDefaultexten", query = "SELECT c FROM CfgPersons c WHERE c.defaultexten = :defaultexten")
    , @NamedQuery(name = "CfgPersons.findByCrrUsername", query = "SELECT c FROM CfgPersons c WHERE c.crrUsername = :crrUsername")
    , @NamedQuery(name = "CfgPersons.findByCrrTime", query = "SELECT c FROM CfgPersons c WHERE c.crrTime = :crrTime")
    , @NamedQuery(name = "CfgPersons.findByUsernameAndPassword", query = "SELECT t FROM CfgPersons t WHERE t.username = :username and t.userpwd= :password")})
public class CfgPersons implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "tenant_id")
    private int tenantId;
    @Column(name = "loginid")
    private Integer loginid;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "userpwd")
    private String userpwd;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "active")
    private Boolean active;
    @Column(name = "mailbox")
    private String mailbox;
    @Column(name = "defaultexten")
    private String defaultexten;
    @Column(name = "crr_username")
    private String crrUsername;
    @Basic(optional = false)
    @Column(name = "crr_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crrTime;

    public CfgPersons() {
    }

    public CfgPersons(Integer id) {
        this.id = id;
    }

    public CfgPersons(Integer id, int tenantId, String username, String userpwd, Date crrTime) {
        this.id = id;
        this.tenantId = tenantId;
        this.username = username;
        this.userpwd = userpwd;
        this.crrTime = crrTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public Integer getLoginid() {
        return loginid;
    }

    public void setLoginid(Integer loginid) {
        this.loginid = loginid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getDefaultexten() {
        return defaultexten;
    }

    public void setDefaultexten(String defaultexten) {
        this.defaultexten = defaultexten;
    }

    public String getCrrUsername() {
        return crrUsername;
    }

    public void setCrrUsername(String crrUsername) {
        this.crrUsername = crrUsername;
    }

    public Date getCrrTime() {
        return crrTime;
    }

    public void setCrrTime(Date crrTime) {
        this.crrTime = crrTime;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CfgPersons)) {
            return false;
        }
        CfgPersons other = (CfgPersons) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.CfgPersons[ id=" + id + " ]";
    }
    
}
