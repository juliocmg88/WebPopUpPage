/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.CfgImports;
import com.jpa.controlador.CfgImportsJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanCfgImports {
    private EntityManagerFactory emf;
    private CfgImportsJpaController  cfgImportsControl;
    
    public JavaBeanCfgImports(){        
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        cfgImportsControl = new CfgImportsJpaController(emf);
    }
    
    public List<CfgImports> findCfgImportsEntities(){
        return cfgImportsControl.findCfgImportsEntities();
    }
}
