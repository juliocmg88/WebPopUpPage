/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bean;

import com.entidades.InfoProductos;
import com.jpa.controlador.InfoProductosJpaController;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian
 */
public class JavaBeanInfoProductos {
    private EntityManagerFactory emf;
    private InfoProductosJpaController  infoProductosControl;
    
    public JavaBeanInfoProductos(){
        emf=Persistence.createEntityManagerFactory("WebPopUpPagePU");
        infoProductosControl = new InfoProductosJpaController(emf);
    }
    
    public List<InfoProductos> findInfoProductosEntities(){
        return infoProductosControl.findInfoProductosEntities();
    }
    
    public List<InfoProductos> findInfoProductosByNcliente(int ncliente){
        return infoProductosControl.findInfoProductosByNcliente(ncliente);
    }
}
