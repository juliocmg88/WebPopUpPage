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
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "logs_survey_interactions_web_page")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogsSurveyInteractionsWebPage.findAll", query = "SELECT l FROM LogsSurveyInteractionsWebPage l")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findById", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.id = :id")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByEventname", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.eventname = :eventname")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCrrTime", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.crrTime = :crrTime")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByPhone", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.phone = :phone")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByUniqueid", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.uniqueid = :uniqueid")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByConnid", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.connid = :connid")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCampaignId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.campaignId = :campaignId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCallinglistId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.callinglistId = :callinglistId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByImportId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.importId = :importId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByRecordId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.recordId = :recordId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByChainId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.chainId = :chainId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findBySurveyId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.surveyId = :surveyId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findBySurveyDnis", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.surveyDnis = :surveyDnis")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findBySurveyName", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.surveyName = :surveyName")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByQuestionId", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.questionId = :questionId")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByQuestionName", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.questionName = :questionName")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByQuestionText", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.questionText = :questionText")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByQuestionNum", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.questionNum = :questionNum")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByAttempt", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.attempt = :attempt")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByResponseCode", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.responseCode = :responseCode")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByResponseText", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.responseText = :responseText")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByInputType", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.inputType = :inputType")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByRecogConfidence", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.recogConfidence = :recogConfidence")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByRecogUtterance", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.recogUtterance = :recogUtterance")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCdata01", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.cdata01 = :cdata01")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCdata02", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.cdata02 = :cdata02")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCdata03", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.cdata03 = :cdata03")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCdata04", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.cdata04 = :cdata04")
    , @NamedQuery(name = "LogsSurveyInteractionsWebPage.findByCdata05", query = "SELECT l FROM LogsSurveyInteractionsWebPage l WHERE l.cdata05 = :cdata05")})
@NamedStoredProcedureQuery(
	name = "sp_getHistoricoGestionCliente", 
	procedureName = "sp_getHistoricoGestionCliente", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = String.class, name = "p_cliente")
	}
)
public class LogsSurveyInteractionsWebPage implements Serializable,Cloneable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "eventname")
    private String eventname;
    @Basic(optional = false)
    @Column(name = "crr_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date crrTime;
    @Column(name = "phone")
    private String phone;
    @Column(name = "uniqueid")
    private String uniqueid;
    @Column(name = "connid")
    private String connid;
    @Column(name = "campaign_id")
    private Integer campaignId;
    @Column(name = "callinglist_id")
    private Integer callinglistId;
    @Column(name = "import_id")
    private Integer importId;
    @Column(name = "record_id")
    private Integer recordId;
    @Column(name = "chain_id")
    private String chainId;
    @Column(name = "survey_id")
    private Integer surveyId;
    @Column(name = "survey_dnis")
    private String surveyDnis;
    @Column(name = "survey_name")
    private String surveyName;
    @Column(name = "question_id")
    private Integer questionId;
    @Column(name = "question_name")
    private String questionName;
    @Column(name = "question_text")
    private String questionText;
    @Column(name = "question_num")
    private Integer questionNum;
    @Column(name = "attempt")
    private Integer attempt;
    @Column(name = "response_code")
    private String responseCode;
    @Column(name = "response_text")
    private String responseText;
    @Column(name = "input_type")
    private String inputType;
    @Column(name = "recog_confidence")
    private Integer recogConfidence;
    @Column(name = "recog_utterance")
    private String recogUtterance;
    @Column(name = "cdata01")
    private String cdata01;
    @Column(name = "cdata02")
    private String cdata02;
    @Column(name = "cdata03")
    private String cdata03;
    @Column(name = "cdata04")
    private String cdata04;
    @Column(name = "cdata05")
    private String cdata05;

    public LogsSurveyInteractionsWebPage() {
    }

    public LogsSurveyInteractionsWebPage(Long id) {
        this.id = id;
    }

    public LogsSurveyInteractionsWebPage(Long id, Date crrTime) {
        this.id = id;
        this.crrTime = crrTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventname() {
        return eventname;
    }

    public void setEventname(String eventname) {
        this.eventname = eventname;
    }

    public Date getCrrTime() {
        return crrTime;
    }

    public void setCrrTime(Date crrTime) {
        this.crrTime = crrTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUniqueid() {
        return uniqueid;
    }

    public void setUniqueid(String uniqueid) {
        this.uniqueid = uniqueid;
    }

    public String getConnid() {
        return connid;
    }

    public void setConnid(String connid) {
        this.connid = connid;
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

    public Integer getImportId() {
        return importId;
    }

    public void setImportId(Integer importId) {
        this.importId = importId;
    }

    public Integer getRecordId() {
        return recordId;
    }

    public void setRecordId(Integer recordId) {
        this.recordId = recordId;
    }

    public String getChainId() {
        return chainId;
    }

    public void setChainId(String chainId) {
        this.chainId = chainId;
    }

    public Integer getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(Integer surveyId) {
        this.surveyId = surveyId;
    }

    public String getSurveyDnis() {
        return surveyDnis;
    }

    public void setSurveyDnis(String surveyDnis) {
        this.surveyDnis = surveyDnis;
    }

    public String getSurveyName() {
        return surveyName;
    }

    public void setSurveyName(String surveyName) {
        this.surveyName = surveyName;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Integer getQuestionNum() {
        return questionNum;
    }

    public void setQuestionNum(Integer questionNum) {
        this.questionNum = questionNum;
    }

    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getRecogConfidence() {
        return recogConfidence;
    }

    public void setRecogConfidence(Integer recogConfidence) {
        this.recogConfidence = recogConfidence;
    }

    public String getRecogUtterance() {
        return recogUtterance;
    }

    public void setRecogUtterance(String recogUtterance) {
        this.recogUtterance = recogUtterance;
    }

    public String getCdata01() {
        return cdata01;
    }

    public void setCdata01(String cdata01) {
        this.cdata01 = cdata01;
    }

    public String getCdata02() {
        return cdata02;
    }

    public void setCdata02(String cdata02) {
        this.cdata02 = cdata02;
    }

    public String getCdata03() {
        return cdata03;
    }

    public void setCdata03(String cdata03) {
        this.cdata03 = cdata03;
    }

    public String getCdata04() {
        return cdata04;
    }

    public void setCdata04(String cdata04) {
        this.cdata04 = cdata04;
    }

    public String getCdata05() {
        return cdata05;
    }

    public void setCdata05(String cdata05) {
        this.cdata05 = cdata05;
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
        if (!(object instanceof LogsSurveyInteractionsWebPage)) {
            return false;
        }
        LogsSurveyInteractionsWebPage other = (LogsSurveyInteractionsWebPage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.LogsSurveyInteractionsWebPage[ id=" + id + " ]";
    }
    
        public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
            System.out.println(" no se puede duplicar");
        }
        return obj;
    }
    
}
