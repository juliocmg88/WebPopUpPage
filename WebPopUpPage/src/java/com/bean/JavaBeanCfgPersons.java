/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.CfgPersons;
import com.entidades.TestRegistration;
import com.jpa.controlador.CfgPersonsJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanCfgPersons {
    private EntityManagerFactory emf;
    private CfgPersonsJpaController  cfgPersonsControl;
    
    public JavaBeanCfgPersons(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        cfgPersonsControl = new CfgPersonsJpaController(emf);
        
    }
    
    public void guardar(CfgPersons cp){
        cfgPersonsControl.create(cp);
    }
    
    
    
    public CfgPersons getCfgPersonsByUsername(String usuario){
        /*int nivel=0;
        try{
            String c;
            return nivel;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        } */      
        return cfgPersonsControl.getCfgPersonsByUsername(usuario);
    }
    
    public List<CfgPersons> findCfgPersonsByLoginId(int loginId){
        return cfgPersonsControl.findCfgPersonsByLoginId(loginId);
    }
}
    
