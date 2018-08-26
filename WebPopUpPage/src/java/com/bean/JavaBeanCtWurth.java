/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.CtWurth;
import com.jpa.controlador.CtWurthJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanCtWurth {
    private EntityManagerFactory emf;
    private CtWurthJpaController ctwControl;
    
    public JavaBeanCtWurth(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        ctwControl = new CtWurthJpaController(emf);
    }
    
    public List<CtWurth> findCtWurthEntitiesByUsername(String username){
        return ctwControl.findCtWurthEntitiesByUsername(username);
    }
}
