/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Sebastian
 */
@Entity
@Table(name = "info_productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InfoProductos.findAll", query = "SELECT i FROM InfoProductos i")
    , @NamedQuery(name = "InfoProductos.findByNcliente", query = "SELECT i FROM InfoProductos i WHERE i.ncliente = :ncliente")
    , @NamedQuery(name = "InfoProductos.findByCodigoProducto", query = "SELECT i FROM InfoProductos i WHERE i.codigoProducto = :codigoProducto")
    , @NamedQuery(name = "InfoProductos.findByNombreProducto", query = "SELECT i FROM InfoProductos i WHERE i.nombreProducto = :nombreProducto")
    , @NamedQuery(name = "InfoProductos.findByPrecioUnitarioProducto", query = "SELECT i FROM InfoProductos i WHERE i.precioUnitarioProducto = :precioUnitarioProducto")
    , @NamedQuery(name = "InfoProductos.findByFechaCompraproducto", query = "SELECT i FROM InfoProductos i WHERE i.fechaCompraproducto = :fechaCompraproducto")
    , @NamedQuery(name = "InfoProductos.findByUnidadesdeproductocomprado", query = "SELECT i FROM InfoProductos i WHERE i.unidadesdeproductocomprado = :unidadesdeproductocomprado")
    , @NamedQuery(name = "InfoProductos.findById", query = "SELECT i FROM InfoProductos i WHERE i.id = :id")})
public class InfoProductos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Ncliente")
    private Integer ncliente;
    @Column(name = "Codigo_Producto")
    private String codigoProducto;
    @Column(name = "Nombre_Producto")
    private String nombreProducto;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Precio_Unitario_Producto")
    private Double precioUnitarioProducto;
    @Column(name = "Fecha_Compra_producto")
    @Temporal(TemporalType.DATE)
    private Date fechaCompraproducto;
    @Column(name = "Unidades_de_producto_comprado")
    private Double unidadesdeproductocomprado;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public InfoProductos() {
    }

    public InfoProductos(Integer id) {
        this.id = id;
    }

    public Integer getNcliente() {
        return ncliente;
    }

    public void setNcliente(Integer ncliente) {
        this.ncliente = ncliente;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioUnitarioProducto() {
        return precioUnitarioProducto;
    }

    public void setPrecioUnitarioProducto(Double precioUnitarioProducto) {
        this.precioUnitarioProducto = precioUnitarioProducto;
    }

    public Date getFechaCompraproducto() {
        return fechaCompraproducto;
    }

    public void setFechaCompraproducto(Date fechaCompraproducto) {
        this.fechaCompraproducto = fechaCompraproducto;
    }

    public Double getUnidadesdeproductocomprado() {
        return unidadesdeproductocomprado;
    }

    public void setUnidadesdeproductocomprado(Double unidadesdeproductocomprado) {
        this.unidadesdeproductocomprado = unidadesdeproductocomprado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoProductos)) {
            return false;
        }
        InfoProductos other = (InfoProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entidades.InfoProductos[ id=" + id + " ]";
    }
    
}
