/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.TestRegistration;
import com.jpa.controlador.TestRegistrationJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanTestRegistration {
    private EntityManagerFactory emf;
    private TestRegistrationJpaController testRegistrationControl;
    public JavaBeanTestRegistration(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        testRegistrationControl = new TestRegistrationJpaController(emf);
    }
    
    public void guardar(TestRegistration tr){
        testRegistrationControl.create(tr);
    }
    
    public List<TestRegistration> buscarTodos(){
        return testRegistrationControl.findTestRegistrationEntities();
    }
    
    public TestRegistration validar(String usuario, String contra){
        /*int nivel=0;
        try{
            String c;
            return nivel;
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        } */      
        return testRegistrationControl.validar(usuario, contra);
    }
    
    
}
