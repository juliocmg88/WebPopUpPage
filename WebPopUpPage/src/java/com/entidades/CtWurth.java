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
@Table(name = "ct_wurth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtWurth.findAll", query = "SELECT c FROM CtWurth c")
    , @NamedQuery(name = "CtWurth.findByRecordId", query = "SELECT c FROM CtWurth c WHERE c.recordId = :recordId")
    , @NamedQuery(name = "CtWurth.findByCampaignId", query = "SELECT c FROM CtWurth c WHERE c.campaignId = :campaignId")
    , @NamedQuery(name = "CtWurth.findByCallinglistId", query = "SELECT c FROM CtWurth c WHERE c.callinglistId = :callinglistId")
    , @NamedQuery(name = "CtWurth.findByContactInfo", query = "SELECT c FROM CtWurth c WHERE c.contactInfo = :contactInfo")
    , @NamedQuery(name = "CtWurth.findByRecordType", query = "SELECT c FROM CtWurth c WHERE c.recordType = :recordType")
    , @NamedQuery(name = "CtWurth.findByRecordStatus", query = "SELECT c FROM CtWurth c WHERE c.recordStatus = :recordStatus")
    , @NamedQuery(name = "CtWurth.findByAttempts", query = "SELECT c FROM CtWurth c WHERE c.attempts = :attempts")
    , @NamedQuery(name = "CtWurth.findByCallResult", query = "SELECT c FROM CtWurth c WHERE c.callResult = :callResult")
    , @NamedQuery(name = "CtWurth.findByCallTime", query = "SELECT c FROM CtWurth c WHERE c.callTime = :callTime")
    , @NamedQuery(name = "CtWurth.findBySchedTime", query = "SELECT c FROM CtWurth c WHERE c.schedTime = :schedTime")
    , @NamedQuery(name = "CtWurth.findByAgentId", query = "SELECT c FROM CtWurth c WHERE c.agentId = :agentId")
    , @NamedQuery(name = "CtWurth.findByAgentDn", query = "SELECT c FROM CtWurth c WHERE c.agentDn = :agentDn")
    , @NamedQuery(name = "CtWurth.findByChainId", query = "SELECT c FROM CtWurth c WHERE c.chainId = :chainId")
    , @NamedQuery(name = "CtWurth.findByChainN", query = "SELECT c FROM CtWurth c WHERE c.chainN = :chainN")
    , @NamedQuery(name = "CtWurth.findByImportId", query = "SELECT c FROM CtWurth c WHERE c.importId = :importId")
    , @NamedQuery(name = "CtWurth.findByRecycleCount", query = "SELECT c FROM CtWurth c WHERE c.recycleCount = :recycleCount")
    , @NamedQuery(name = "CtWurth.findByRecycleLasttime", query = "SELECT c FROM CtWurth c WHERE c.recycleLasttime = :recycleLasttime")
    , @NamedQuery(name = "CtWurth.findByCrrTime", query = "SELECT c FROM CtWurth c WHERE c.crrTime = :crrTime")
    , @NamedQuery(name = "CtWurth.findByNombre", query = "SELECT c FROM CtWurth c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CtWurth.findByApellidoPat", query = "SELECT c FROM CtWurth c WHERE c.apellidoPat = :apellidoPat")
    , @NamedQuery(name = "CtWurth.findByApellidoMat", query = "SELECT c FROM CtWurth c WHERE c.apellidoMat = :apellidoMat")
    , @NamedQuery(name = "CtWurth.findByIdCliente", query = "SELECT c FROM CtWurth c WHERE c.idCliente = :idCliente")
    , @NamedQuery(name = "CtWurth.findByTelefono1", query = "SELECT c FROM CtWurth c WHERE c.telefono1 = :telefono1")
    , @NamedQuery(name = "CtWurth.findByTelefono2", query = "SELECT c FROM CtWurth c WHERE c.telefono2 = :telefono2")
    , @NamedQuery(name = "CtWurth.findByTelefono3", query = "SELECT c FROM CtWurth c WHERE c.telefono3 = :telefono3")
    , @NamedQuery(name = "CtWurth.findByTelefono4", query = "SELECT c FROM CtWurth c WHERE c.telefono4 = :telefono4")
    , @NamedQuery(name = "CtWurth.findByEmpresa", query = "SELECT c FROM CtWurth c WHERE c.empresa = :empresa")
    , @NamedQuery(name = "CtWurth.findByRutEmpresa", query = "SELECT c FROM CtWurth c WHERE c.rutEmpresa = :rutEmpresa")
    , @NamedQuery(name = "CtWurth.findByUsernameEjecutivo", query = "SELECT c FROM CtWurth c WHERE c.usernameEjecutivo = :usernameEjecutivo")})
public class CtWurth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "record_id")
    private Long recordId;
    @Column(name = "campaign_id")
    private Integer campaignId;
    @Column(name = "callinglist_id")
    private Integer callinglistId;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "record_type")
    private Integer recordType;
    @Column(name = "record_status")
    private Integer recordStatus;
    @Column(name = "attempts")
    private Integer attempts;
    @Column(name = "call_result")
    private Integer callResult;
    @Column(name = "call_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date callTime;
    @Column(name = "sched_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schedTime;
    @Column(name = "agent_id")
    private Integer agentId;
    @Column(name = "agent_dn")
    private String agentDn;
    @Column(name = "chain_id")
    private String chainId;
    @Column(name = "chain_n")
    private Integer chainN;
    @Column(name = "import_id")
    private Integer importId;
    @Column(name = "recycle_count")
    private Integer recycleCount;
    @Column(name = "recycle_lasttime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date recycleLasttime;
    @Column(name = "crr_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crrTime;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido_pat")
    private String apellidoPat;
    @Column(name = "apellido_mat")
    private String apellidoMat;
    @Column(name = "id_cliente")
    private String idCliente;
    @Column(name = "telefono1")
    private String telefono1;
    @Column(name = "telefono2")
    private String telefono2;
    @Column(name = "telefono3")
    private String telefono3;
    @Column(name = "telefono4")
    private String telefono4;
    @Column(name = "empresa")
    private String empresa;
    @Column(name = "rut_empresa")
    private String rutEmpresa;
    @Column(name = "username_ejecutivo")
    private String usernameEjecutivo;

    public CtWurth() {
    }

    public CtWurth(Long recordId) {
        this.recordId = recordId;
    }

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Integer getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(Integer campaignId) {
        this.campaignId = campaignId;
    }

    public Integer getCallinglistId() {
        return callinglistId;
    }

    public void setCallinglistId(Integer callinglistId) {
        this.callinglistId = callinglistId;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Integer getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Integer getCallResult() {
        return callResult;
    }

    public void setCallResult(Integer callResult) {
        this.callResult = callResult;
    }

    public Date getCallTime() {
        return callTime;
    }

    public void setCallTime(Date callTime) {
        this.callTime = callTime;
    }

    public Date getSchedTime() {
        return schedTime;
    }

    public void setSchedTime(Date schedTime) {
        this.schedTime = schedTime;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public String getAgentDn() {
        return agentDn;
    }

    public void setAgentDn(String agentDn) {
        this.agentDn = agentDn;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Integer getChainN() {
        return chainN;
    }

    public void setChainN(Integer chainN) {
        this.chainN = chainN;
    }

    public Integer getImportId() {
        return importId;
    }

    public void setImportId(Integer importId) {
        this.importId = importId;
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

    public Date getCrrTime() {
        return crrTime;
    }

    public void setCrrTime(Date crrTime) {
        this.crrTime = crrTime;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getTelefono3() {
        return telefono3;
    }

    public void setTelefono3(String telefono3) {
        this.telefono3 = telefono3;
    }

    public String getTelefono4() {
        return telefono4;
    }

    public void setTelefono4(String telefono4) {
        this.telefono4 = telefono4;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getUsernameEjecutivo() {
        return usernameEjecutivo;
    }

    public void setUsernameEjecutivo(String usernameEjecutivo) {
        this.usernameEjecutivo = usernameEjecutivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordId != null ? recordId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CtWurth)) {
            return false;
        }
        CtWurth other = (CtWurth) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.CtWurth[ recordId=" + recordId + " ]";
    }
    
}
