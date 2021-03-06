/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acarrillo
 */
@Entity
@Table(name = "direcciones_mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DireccionesMascota.findAll", query = "SELECT d FROM DireccionesMascota d"),
    @NamedQuery(name = "DireccionesMascota.findByIdDireccion", query = "SELECT d FROM DireccionesMascota d WHERE d.idDireccion = :idDireccion"),
    @NamedQuery(name = "DireccionesMascota.findByIdMascota", query = "SELECT d FROM DireccionesMascota d WHERE d.idMascota = :idMascota"),
    @NamedQuery(name = "DireccionesMascota.findByLatitud", query = "SELECT d FROM DireccionesMascota d WHERE d.latitud = :latitud"),
    @NamedQuery(name = "DireccionesMascota.findByLongitud", query = "SELECT d FROM DireccionesMascota d WHERE d.longitud = :longitud"),
    @NamedQuery(name = "DireccionesMascota.findByFecha", query = "SELECT d FROM DireccionesMascota d WHERE d.fecha = :fecha"),
    @NamedQuery(name = "DireccionesMascota.findByNumeroContacto", query = "SELECT d FROM DireccionesMascota d WHERE d.numeroContacto = :numeroContacto"),
    @NamedQuery(name = "DireccionesMascota.findByUsuario", query = "SELECT d FROM DireccionesMascota d WHERE d.usuario = :usuario"),
    @NamedQuery(name = "DireccionesMascota.findByEstado", query = "SELECT d FROM DireccionesMascota d WHERE d.estado = :estado")})
public class DireccionesMascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "id_direccion")
    private Long idDireccion;
    @Column(name = "id_mascota")
    private BigInteger idMascota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "longitud")
    private String longitud;
    @Lob
    @Size(max = 65535)
    @Column(name = "direccion")
    private String direccion;
    @Lob
    @Size(max = 65535)
    @Column(name = "comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Lob
    @Size(max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 50)
    @Column(name = "numero_contacto")
    private String numeroContacto;
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "estado")
    private Integer estado;

    public DireccionesMascota() {
    }

    public DireccionesMascota(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public DireccionesMascota(Long idDireccion, String latitud, String longitud, Date fecha) {
        this.idDireccion = idDireccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
    }

    public Long getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public BigInteger getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(BigInteger idMascota) {
        this.idMascota = idMascota;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        this.numeroContacto = numeroContacto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DireccionesMascota)) {
            return false;
        }
        DireccionesMascota other = (DireccionesMascota) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yvaganet.finder.model.DireccionesMascota[ idDireccion=" + idDireccion + " ]";
    }
    
}
