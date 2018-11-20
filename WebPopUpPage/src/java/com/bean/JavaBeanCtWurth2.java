/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.CtWurth2;
import com.jpa.controlador.CtWurth2JpaController;
import com.jpa.controlador.CtWurthJpaController;
import com.jpa.controlador.exceptions.NonexistentEntityException;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanCtWurth2 {
        private EntityManagerFactory emf;
    private CtWurth2JpaController ctwControl;
    
    public JavaBeanCtWurth2(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        ctwControl = new CtWurth2JpaController(emf);
    }
    
    public List<CtWurth2> findCtWurthEntitiesByTodayTime(String username){
        return ctwControl.findCtWurthEntitiesByTodayTime(username);
    }
    
    public List<CtWurth2> findCtWurthEntitiesByImport(String username){
        return ctwControl.findCtWurthEntitiesByImport(username);
    }
    public List<CtWurth2> findCtWurthEntitiesBySchedTime(String username){
        return ctwControl.findCtWurthEntitiesBySchedTime(username);
    }
    
    
    
      public List<CtWurth2> findCtWurthEntitiesByAgenda(String username){
        return ctwControl.findCtWurthEntitiesBySchedTime(username);
    }
    
    
    
    
    
    
    public void create(CtWurth2 ctWurth2) {
     ctwControl.create(ctWurth2);
    }
    
    
    
    
    
    public void edit(CtWurth2 ctWurth2) throws NonexistentEntityException, Exception {
        ctwControl.edit(ctWurth2);
    }
    
    public CtWurth2 findCtWurth2(Long id) {
        return ctwControl.findCtWurth2(id);
        
        
    }
}
