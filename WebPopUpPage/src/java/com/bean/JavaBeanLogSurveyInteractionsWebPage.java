/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.HistoricoGestion;
import com.entidades.LogsSurveyInteractionsWebPage;
import com.jpa.controlador.LogsSurveyInteractionsWebPageJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanLogSurveyInteractionsWebPage {
        private EntityManagerFactory emf;
        private LogsSurveyInteractionsWebPageJpaController logsControl;
    
    public JavaBeanLogSurveyInteractionsWebPage(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        logsControl = new LogsSurveyInteractionsWebPageJpaController(emf);
    }
    
    public void create(LogsSurveyInteractionsWebPage logsSurveyInteractionsWebPage){
        logsControl.create(logsSurveyInteractionsWebPage);
    } 
    
    public List getHistoricoGestion(String ncliente){
        return logsControl.getHistoricoGestion(ncliente);
    }
}
