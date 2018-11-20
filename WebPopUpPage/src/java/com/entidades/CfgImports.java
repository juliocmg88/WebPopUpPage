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
@Table(name = "cfg_imports")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CfgImports.findAll", query = "SELECT c FROM CfgImports c")
    , @NamedQuery(name = "CfgImports.findById", query = "SELECT c FROM CfgImports c WHERE c.id = :id")
    , @NamedQuery(name = "CfgImports.findByCampaignId", query = "SELECT c FROM CfgImports c WHERE c.campaignId = :campaignId")
    , @NamedQuery(name = "CfgImports.findByFormatId", query = "SELECT c FROM CfgImports c WHERE c.formatId = :formatId")
    , @NamedQuery(name = "CfgImports.findByCallinglistId", query = "SELECT c FROM CfgImports c WHERE c.callinglistId = :callinglistId")
    , @NamedQuery(name = "CfgImports.findByFilename", query = "SELECT c FROM CfgImports c WHERE c.filename = :filename")
    , @NamedQuery(name = "CfgImports.findByFilesize", query = "SELECT c FROM CfgImports c WHERE c.filesize = :filesize")
    , @NamedQuery(name = "CfgImports.findByImportmode", query = "SELECT c FROM CfgImports c WHERE c.importmode = :importmode")
    , @NamedQuery(name = "CfgImports.findByRecordcount", query = "SELECT c FROM CfgImports c WHERE c.recordcount = :recordcount")
    , @NamedQuery(name = "CfgImports.findByFileextension", query = "SELECT c FROM CfgImports c WHERE c.fileextension = :fileextension")
    , @NamedQuery(name = "CfgImports.findByImportprogress", query = "SELECT c FROM CfgImports c WHERE c.importprogress = :importprogress")
    , @NamedQuery(name = "CfgImports.findByTimeprogress", query = "SELECT c FROM CfgImports c WHERE c.timeprogress = :timeprogress")
    , @NamedQuery(name = "CfgImports.findByImportstatus", query = "SELECT c FROM CfgImports c WHERE c.importstatus = :importstatus")
    , @NamedQuery(name = "CfgImports.findByImportstatusinfo", query = "SELECT c FROM CfgImports c WHERE c.importstatusinfo = :importstatusinfo")
    , @NamedQuery(name = "CfgImports.findByRecordsuccess", query = "SELECT c FROM CfgImports c WHERE c.recordsuccess = :recordsuccess")
    , @NamedQuery(name = "CfgImports.findByRecordfail", query = "SELECT c FROM CfgImports c WHERE c.recordfail = :recordfail")
    , @NamedQuery(name = "CfgImports.findBySchedStartdate", query = "SELECT c FROM CfgImports c WHERE c.schedStartdate = :schedStartdate")
    , @NamedQuery(name = "CfgImports.findBySchedEnddate", query = "SELECT c FROM CfgImports c WHERE c.schedEnddate = :schedEnddate")
    , @NamedQuery(name = "CfgImports.findBySchedStarttime", query = "SELECT c FROM CfgImports c WHERE c.schedStarttime = :schedStarttime")
    , @NamedQuery(name = "CfgImports.findBySchedEndtime", query = "SELECT c FROM CfgImports c WHERE c.schedEndtime = :schedEndtime")
    , @NamedQuery(name = "CfgImports.findByDialpriority", query = "SELECT c FROM CfgImports c WHERE c.dialpriority = :dialpriority")
    , @NamedQuery(name = "CfgImports.findByDialmode", query = "SELECT c FROM CfgImports c WHERE c.dialmode = :dialmode")
    , @NamedQuery(name = "CfgImports.findByRecycleCount", query = "SELECT c FROM CfgImports c WHERE c.recycleCount = :recycleCount")
    , @NamedQuery(name = "CfgImports.findByRecycleLasttime", query = "SELECT c FROM CfgImports c WHERE c.recycleLasttime = :recycleLasttime")
    , @NamedQuery(name = "CfgImports.findByActive", query = "SELECT c FROM CfgImports c WHERE c.active = :active")
    , @NamedQuery(name = "CfgImports.findByCrrUsername", query = "SELECT c FROM CfgImports c WHERE c.crrUsername = :crrUsername")
    , @NamedQuery(name = "CfgImports.findByCrrTime", query = "SELECT c FROM CfgImports c WHERE c.crrTime = :crrTime")})
public class CfgImports implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "campaign_id")
    private Integer campaignId;
    @Column(name = "format_id")
    private Integer formatId;
    @Column(name = "callinglist_id")
    private Integer callinglistId;
    @Column(name = "filename")
    private String filename;
    @Column(name = "filesize")
    private String filesize;
    @Column(name = "importmode")
    private String importmode;
    @Column(name = "recordcount")
    private Integer recordcount;
    @Column(name = "fileextension")
    private String fileextension;
    @Column(name = "importprogress")
    private Integer importprogress;
    @Column(name = "timeprogress")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeprogress;
    @Column(name = "importstatus")
    private Integer importstatus;
    @Column(name = "importstatusinfo")
    private String importstatusinfo;
    @Column(name = "recordsuccess")
    private Integer recordsuccess;
    @Column(name = "recordfail")
    private Integer recordfail;
    @Column(name = "sched_startdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schedStartdate;
    @Column(name = "sched_enddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schedEnddate;
    @Column(name = "sched_starttime")
    @Temporal(TemporalType.TIME)
    private Date schedStarttime;
    @Column(name = "sched_endtime")
    @Temporal(TemporalType.TIME)
    private Date schedEndtime;
    @Column(name = "dialpriority")
    private Integer dialpriority;
    @Column(name = "dialmode")
    private Integer dialmode;
    @Column(name = "recycle_count")
    private Integer recycleCount;
    @Column(name = "recycle_lasttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recycleLasttime;
    @Column(name = "active")
    private Integer active;
    @Column(name = "crr_username")
    private String crrUsername;
    @Basic(optional = false)
    @Column(name = "crr_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crrTime;

    public CfgImports() {
    }

    public CfgImports(Integer id) {
        this.id = id;
    }

    public CfgImports(Integer id, Date crrTime) {
        this.id = id;
        this.crrTime = crrTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getFormatId() {
        return formatId;
    }

    public void setFormatId(Integer formatId) {
        this.formatId = formatId;
    }

    public Integer getCallinglistId() {
        return callinglistId;
    }

    public void setCallinglistId(Integer callinglistId) {
        this.callinglistId = callinglistId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilesize() {
        return filesize;
    }

    public void setFilesize(String filesize) {
        this.filesize = filesize;
    }

    public String getImportmode() {
        return importmode;
    }

    public void setImportmode(String importmode) {
        this.importmode = importmode;
    }

    public Integer getRecordcount() {
        return recordcount;
    }

    public void setRecordcount(Integer recordcount) {
        this.recordcount = recordcount;
    }

    public String getFileextension() {
        return fileextension;
    }

    public void setFileextension(String fileextension) {
        this.fileextension = fileextension;
    }

    public Integer getImportprogress() {
        return importprogress;
    }

    public void setImportprogress(Integer importprogress) {
        this.importprogress = importprogress;
    }

    public Date getTimeprogress() {
        return timeprogress;
    }

    public void setTimeprogress(Date timeprogress) {
        this.timeprogress = timeprogress;
    }

    public Integer getImportstatus() {
        return importstatus;
    }

    public void setImportstatus(Integer importstatus) {
        this.importstatus = importstatus;
    }

    public String getImportstatusinfo() {
        return importstatusinfo;
    }

    public void setImportstatusinfo(String importstatusinfo) {
        this.importstatusinfo = importstatusinfo;
    }

    public Integer getRecordsuccess() {
        return recordsuccess;
    }

    public void setRecordsuccess(Integer recordsuccess) {
        this.recordsuccess = recordsuccess;
    }

    public Integer getRecordfail() {
        return recordfail;
    }

    public void setRecordfail(Integer recordfail) {
        this.recordfail = recordfail;
    }

    public Date getSchedStartdate() {
        return schedStartdate;
    }

    public void setSchedStartdate(Date schedStartdate) {
        this.schedStartdate = schedStartdate;
    }

    public Date getSchedEnddate() {
        return schedEnddate;
    }

    public void setSchedEnddate(Date schedEnddate) {
        this.schedEnddate = schedEnddate;
    }

    public Date getSchedStarttime() {
        return schedStarttime;
    }

    public void setSchedStarttime(Date schedStarttime) {
        this.schedStarttime = schedStarttime;
    }

    public Date getSchedEndtime() {
        return schedEndtime;
    }

    public void setSchedEndtime(Date schedEndtime) {
        this.schedEndtime = schedEndtime;
    }

    public Integer getDialpriority() {
        return dialpriority;
    }

    public void setDialpriority(Integer dialpriority) {
        this.dialpriority = dialpriority;
    }

    public Integer getDialmode() {
        return dialmode;
    }

    public void setDialmode(Integer dialmode) {
        this.dialmode = dialmode;
    }

    public Integer getRecycleCount() {
        return recycleCount;
    }

    public void setRecycleCount(Integer recycleCount) {
        this.recycleCount = recycleCount;
    }

    public Date getRecycleLasttime() {
        return recycleLasttime;
    }

    public void setRecycleLasttime(Date recycleLasttime) {
        this.recycleLasttime = recycleLasttime;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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
        if (!(object instanceof CfgImports)) {
            return false;
        }
        CfgImports other = (CfgImports) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.CfgImports[ id=" + id + " ]";
    }
    
}
