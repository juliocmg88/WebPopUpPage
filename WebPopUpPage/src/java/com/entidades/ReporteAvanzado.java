/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

/**
 *
 * @author Alamiro
 */
public class ReporteAvanzado {
    
    private String fechallamada;
    private String userAgent;
    private String idcliente;
    private String nombrecliente;
    private String telefono;
    private String tipificacion;
    private String pregNombre;
    private String enviocotizacion;
    private String observacion;

    public String getFechallamada() {
        return fechallamada;
    }

    public void setFechallamada(String fechallamada) {
        this.fechallamada = fechallamada;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public String getNombrecliente() {
        return nombrecliente;
    }

    public void setNombrecliente(String nombrecliente) {
        this.nombrecliente = nombrecliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipificacion() {
        return tipificacion;
    }

    public void setTipificacion(String tipificacion) {
        this.tipificacion = tipificacion;
    }

    public String getPregNombre() {
        return pregNombre;
    }

    public void setPregNombre(String pregNombre) {
        this.pregNombre = pregNombre;
    }

    public String getEnviocotizacion() {
        return enviocotizacion;
    }

    public void setEnviocotizacion(String enviocotizacion) {
        this.enviocotizacion = enviocotizacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
    
    public String[] GetArray(){
        String [] datos = {fechallamada,userAgent,idcliente,nombrecliente,telefono,tipificacion,pregNombre,enviocotizacion,observacion};
        
     return datos;   
    }
    
    
}
