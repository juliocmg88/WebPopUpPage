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
public class Reporte {
    
    
    private String userAgent;
  
    private String tipificacion;
    private String pregNombre;
    private String enviocotizacion;
    private String cantidad; 

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
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

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
