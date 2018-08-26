/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.util.Date;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;

/**
 *
 * @author Sebastian
 */

@NamedStoredProcedureQuery(
	name = "sp_getHistoricoGestionCliente", 
	procedureName = "sp_getHistoricoGestionCliente", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Double.class, name = "p_cliente")
	}
)
public class HistoricoGestion {
    private Date fechaLlamada;
    private String userAgent;
    private String nClient;
    private String nameClient;
    private String telefono;
    private String tipificacion;
    private String pregNombre;
    private String pregCotiza;
    private String observaciones;

    /**
     * @return the fechaLlamada
     */
    public Date getFechaLlamada() {
        return fechaLlamada;
    }

    /**
     * @param fechaLlamada the fechaLlamada to set
     */
    public void setFechaLlamada(Date fechaLlamada) {
        this.fechaLlamada = fechaLlamada;
    }

    /**
     * @return the userAgent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * @param userAgent the userAgent to set
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * @return the nClient
     */
    public String getnClient() {
        return nClient;
    }

    /**
     * @param nClient the nClient to set
     */
    public void setnClient(String nClient) {
        this.nClient = nClient;
    }

    /**
     * @return the nameClient
     */
    public String getNameClient() {
        return nameClient;
    }

    /**
     * @param nameClient the nameClient to set
     */
    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the tipificacion
     */
    public String getTipificacion() {
        return tipificacion;
    }

    /**
     * @param tipificacion the tipificacion to set
     */
    public void setTipificacion(String tipificacion) {
        this.tipificacion = tipificacion;
    }

    /**
     * @return the pregNombre
     */
    public String getPregNombre() {
        return pregNombre;
    }

    /**
     * @param pregNombre the pregNombre to set
     */
    public void setPregNombre(String pregNombre) {
        this.pregNombre = pregNombre;
    }

    /**
     * @return the pregCotiza
     */
    public String getPregCotiza() {
        return pregCotiza;
    }

    /**
     * @param pregCotiza the pregCotiza to set
     */
    public void setPregCotiza(String pregCotiza) {
        this.pregCotiza = pregCotiza;
    }

    /**
     * @return the observaciones
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     * @param onservaciones the observaciones to set
     */
    public void setObservaciones(String onservaciones) {
        this.observaciones = onservaciones;
    }
    
    
    
}
