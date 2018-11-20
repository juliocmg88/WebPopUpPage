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
@Table(name = "ct_wurth_2")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CtWurth2.findAll", query = "SELECT c FROM CtWurth2 c")
    , @NamedQuery(name = "CtWurth2.findByRecordId", query = "SELECT c FROM CtWurth2 c WHERE c.recordId = :recordId")
    , @NamedQuery(name = "CtWurth2.findByCampaignId", query = "SELECT c FROM CtWurth2 c WHERE c.campaignId = :campaignId")
    , @NamedQuery(name = "CtWurth2.findByCallinglistId", query = "SELECT c FROM CtWurth2 c WHERE c.callinglistId = :callinglistId")
    , @NamedQuery(name = "CtWurth2.findByContactInfo", query = "SELECT c FROM CtWurth2 c WHERE c.contactInfo = :contactInfo")
    , @NamedQuery(name = "CtWurth2.findByRecordType", query = "SELECT c FROM CtWurth2 c WHERE c.recordType = :recordType")
    , @NamedQuery(name = "CtWurth2.findByRecordStatus", query = "SELECT c FROM CtWurth2 c WHERE c.recordStatus = :recordStatus")
    , @NamedQuery(name = "CtWurth2.findByAttempts", query = "SELECT c FROM CtWurth2 c WHERE c.attempts = :attempts")
    , @NamedQuery(name = "CtWurth2.findByCallResult", query = "SELECT c FROM CtWurth2 c WHERE c.callResult = :callResult")
    , @NamedQuery(name = "CtWurth2.findByCallTime", query = "SELECT c FROM CtWurth2 c WHERE c.callTime = :callTime")
    , @NamedQuery(name = "CtWurth2.findBySchedTime", query = "SELECT c FROM CtWurth2 c WHERE c.schedTime = :schedTime")
    , @NamedQuery(name = "CtWurth2.findByAgentId", query = "SELECT c FROM CtWurth2 c WHERE c.agentId = :agentId")
    , @NamedQuery(name = "CtWurth2.findByAgentDn", query = "SELECT c FROM CtWurth2 c WHERE c.agentDn = :agentDn")
    , @NamedQuery(name = "CtWurth2.findByChainId", query = "SELECT c FROM CtWurth2 c WHERE c.chainId = :chainId")
    , @NamedQuery(name = "CtWurth2.findByChainN", query = "SELECT c FROM CtWurth2 c WHERE c.chainN = :chainN")
    , @NamedQuery(name = "CtWurth2.findByImportId", query = "SELECT c FROM CtWurth2 c WHERE c.importId = :importId")
    , @NamedQuery(name = "CtWurth2.findByRecycleCount", query = "SELECT c FROM CtWurth2 c WHERE c.recycleCount = :recycleCount")
    , @NamedQuery(name = "CtWurth2.findByRecycleLasttime", query = "SELECT c FROM CtWurth2 c WHERE c.recycleLasttime = :recycleLasttime")
    , @NamedQuery(name = "CtWurth2.findByCrrTime", query = "SELECT c FROM CtWurth2 c WHERE c.crrTime = :crrTime")
    , @NamedQuery(name = "CtWurth2.findByNcliente", query = "SELECT c FROM CtWurth2 c WHERE c.ncliente = :ncliente")
    , @NamedQuery(name = "CtWurth2.findByNombre", query = "SELECT c FROM CtWurth2 c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "CtWurth2.findByComuna", query = "SELECT c FROM CtWurth2 c WHERE c.comuna = :comuna")
    , @NamedQuery(name = "CtWurth2.findByDireccion", query = "SELECT c FROM CtWurth2 c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CtWurth2.findByTelefono", query = "SELECT c FROM CtWurth2 c WHERE c.telefono = :telefono")
    , @NamedQuery(name = "CtWurth2.findByRamo", query = "SELECT c FROM CtWurth2 c WHERE c.ramo = :ramo")
    , @NamedQuery(name = "CtWurth2.findByDivision", query = "SELECT c FROM CtWurth2 c WHERE c.division = :division")
    , @NamedQuery(name = "CtWurth2.findByOperarios", query = "SELECT c FROM CtWurth2 c WHERE c.operarios = :operarios")
    , @NamedQuery(name = "CtWurth2.findByPotencial", query = "SELECT c FROM CtWurth2 c WHERE c.potencial = :potencial")
    , @NamedQuery(name = "CtWurth2.findByCondpago", query = "SELECT c FROM CtWurth2 c WHERE c.condpago = :condpago")
    , @NamedQuery(name = "CtWurth2.findByGrupo", query = "SELECT c FROM CtWurth2 c WHERE c.grupo = :grupo")
    , @NamedQuery(name = "CtWurth2.findByFechaActualizacion", query = "SELECT c FROM CtWurth2 c WHERE c.fechaActualizacion = :fechaActualizacion")
    , @NamedQuery(name = "CtWurth2.findByOrsy", query = "SELECT c FROM CtWurth2 c WHERE c.orsy = :orsy")
    , @NamedQuery(name = "CtWurth2.findByPeriodo1", query = "SELECT c FROM CtWurth2 c WHERE c.periodo1 = :periodo1")
    , @NamedQuery(name = "CtWurth2.findByPeriodo2", query = "SELECT c FROM CtWurth2 c WHERE c.periodo2 = :periodo2")
    , @NamedQuery(name = "CtWurth2.findBySml", query = "SELECT c FROM CtWurth2 c WHERE c.sml = :sml")
    , @NamedQuery(name = "CtWurth2.findByUltFac", query = "SELECT c FROM CtWurth2 c WHERE c.ultFac = :ultFac")
    , @NamedQuery(name = "CtWurth2.findByProyeccion", query = "SELECT c FROM CtWurth2 c WHERE c.proyeccion = :proyeccion")
    , @NamedQuery(name = "CtWurth2.findByVar", query = "SELECT c FROM CtWurth2 c WHERE c.var = :var")
    , @NamedQuery(name = "CtWurth2.findByLeyenda", query = "SELECT c FROM CtWurth2 c WHERE c.leyenda = :leyenda")
    , @NamedQuery(name = "CtWurth2.findByQryVendedoresGrupo", query = "SELECT c FROM CtWurth2 c WHERE c.qryVendedoresGrupo = :qryVendedoresGrupo")
    , @NamedQuery(name = "CtWurth2.findByNroSup", query = "SELECT c FROM CtWurth2 c WHERE c.nroSup = :nroSup")
    , @NamedQuery(name = "CtWurth2.findByNomSup", query = "SELECT c FROM CtWurth2 c WHERE c.nomSup = :nomSup")
    , @NamedQuery(name = "CtWurth2.findByNroVen", query = "SELECT c FROM CtWurth2 c WHERE c.nroVen = :nroVen")
    , @NamedQuery(name = "CtWurth2.findByNomVen", query = "SELECT c FROM CtWurth2 c WHERE c.nomVen = :nomVen")
    , @NamedQuery(name = "CtWurth2.findByObservacion", query = "SELECT c FROM CtWurth2 c WHERE c.observacion = :observacion")
    , @NamedQuery(name = "CtWurth2.findByToday", query = "SELECT c FROM CtWurth2 c WHERE c.agentDn = :agentDn and c.crrTime >= :crrTime")
    , @NamedQuery(name = "CtWurth2.findBySched", query = "SELECT c FROM CtWurth2 c WHERE c.agentDn = :agentDn and FUNC('DATE',c.schedTime) = FUNC('DATE',:schedTime)")
        
      , @NamedQuery(name = "CtWurth2.findByagenda", query = "SELECT c FROM CtWurth2 c WHERE c.agentDn = :agentDn and c.schedTime is not null")

        
        
        
    , @NamedQuery(name = "CtWurth2.findByImport", query = "SELECT c FROM CtWurth2 c WHERE c.agentDn = :agentDn and c.importId = :importId")})
public class CtWurth2 implements Serializable {

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
    @Column(name = "Ncliente")
    private Integer ncliente;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Comuna")
    private String comuna;
    @Column(name = "Direccion")
    private String direccion;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "Ramo")
    private String ramo;
    @Column(name = "Division")
    private String division;
    @Column(name = "Operarios")
    private String operarios;
    @Column(name = "Potencial")
    private String potencial;
    @Column(name = "Condpago")
    private String condpago;
    @Column(name = "Grupo")
    private String grupo;
    @Column(name = "FechaActualizacion")
    private String fechaActualizacion;
    @Column(name = "ORSY")
    private String orsy;
    @Column(name = "periodo1")
    private String periodo1;
    @Column(name = "periodo2")
    private String periodo2;
    @Column(name = "SML")
    private String sml;
    @Column(name = "Ult_Fac")
    @Temporal(TemporalType.DATE)
    private Date ultFac;
    @Column(name = "proyeccion")
    private String proyeccion;
    @Column(name = "var")
    private String var;
    @Column(name = "Leyenda")
    private String leyenda;
    @Column(name = "qry_Vendedores_Grupo")
    private String qryVendedoresGrupo;
    @Column(name = "Nro_Sup")
    private Integer nroSup;
    @Column(name = "Nom_Sup")
    private String nomSup;
    @Column(name = "Nro_Ven")
    private Integer nroVen;
    @Column(name = "Nom_Ven")
    private String nomVen;
    @Column(name = "OBSERVACION")
    private String observacion;

    public CtWurth2() {
    }

    public CtWurth2(Long recordId) {
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

    public Integer getNcliente() {
        return ncliente;
    }

    public void setNcliente(Integer ncliente) {
        this.ncliente = ncliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getOperarios() {
        return operarios;
    }

    public void setOperarios(String operarios) {
        this.operarios = operarios;
    }

    public String getPotencial() {
        return potencial;
    }

    public void setPotencial(String potencial) {
        this.potencial = potencial;
    }

    public String getCondpago() {
        return condpago;
    }

    public void setCondpago(String condpago) {
        this.condpago = condpago;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getOrsy() {
        return orsy;
    }

    public void setOrsy(String orsy) {
        this.orsy = orsy;
    }

    public String getPeriodo1() {
        return periodo1;
    }

    public void setPeriodo1(String periodo1) {
        this.periodo1 = periodo1;
    }

    public String getPeriodo2() {
        return periodo2;
    }

    public void setPeriodo2(String periodo2) {
        this.periodo2 = periodo2;
    }

    public String getSml() {
        return sml;
    }

    public void setSml(String sml) {
        this.sml = sml;
    }

    public Date getUltFac() {
        return ultFac;
    }

    public void setUltFac(Date ultFac) {
        this.ultFac = ultFac;
    }

    public String getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(String proyeccion) {
        this.proyeccion = proyeccion;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getLeyenda() {
        return leyenda;
    }

    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
    }

    public String getQryVendedoresGrupo() {
        return qryVendedoresGrupo;
    }

    public void setQryVendedoresGrupo(String qryVendedoresGrupo) {
        this.qryVendedoresGrupo = qryVendedoresGrupo;
    }

    public Integer getNroSup() {
        return nroSup;
    }

    public void setNroSup(Integer nroSup) {
        this.nroSup = nroSup;
    }

    public String getNomSup() {
        return nomSup;
    }

    public void setNomSup(String nomSup) {
        this.nomSup = nomSup;
    }

    public Integer getNroVen() {
        return nroVen;
    }

    public void setNroVen(Integer nroVen) {
        this.nroVen = nroVen;
    }

    public String getNomVen() {
        return nomVen;
    }

    public void setNomVen(String nomVen) {
        this.nomVen = nomVen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
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
        if (!(object instanceof CtWurth2)) {
            return false;
        }
        CtWurth2 other = (CtWurth2) object;
        if ((this.recordId == null && other.recordId != null) || (this.recordId != null && !this.recordId.equals(other.recordId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.CtWurth2[ recordId=" + recordId + " ]";
    }
    
}
