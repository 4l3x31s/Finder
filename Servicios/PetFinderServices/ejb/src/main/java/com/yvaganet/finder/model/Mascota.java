/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.model;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alexeis
 */
@Entity
@Table(name = "mascota")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mascota.findAll", query = "SELECT m FROM Mascota m"),
    @NamedQuery(name = "Mascota.findByIdMascota", query = "SELECT m FROM Mascota m WHERE m.idMascota = :idMascota"),
    @NamedQuery(name = "Mascota.findByIdPersona", query = "SELECT m FROM Mascota m WHERE m.idPersona = :idPersona"),
    @NamedQuery(name = "Mascota.findByNombreMascota", query = "SELECT m FROM Mascota m WHERE m.nombreMascota = :nombreMascota"),
    @NamedQuery(name = "Mascota.findByGenero", query = "SELECT m FROM Mascota m WHERE m.genero = :genero"),
    @NamedQuery(name = "Mascota.findByTipo", query = "SELECT m FROM Mascota m WHERE m.tipo = :tipo"),
    @NamedQuery(name = "Mascota.findByRaza", query = "SELECT m FROM Mascota m WHERE m.raza = :raza"),
    @NamedQuery(name = "Mascota.findByCodigoMascota", query = "SELECT m FROM Mascota m WHERE m.codigoMascota = :codigoMascota"),
    @NamedQuery(name = "Mascota.findByEstado", query = "SELECT m FROM Mascota m WHERE m.estado = :estado")})
public class Mascota implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "id_mascota")
    private Long idMascota;
    @Column(name = "id_persona")
    private BigInteger idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nombre_mascota")
    private String nombreMascota;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "tipo")
    private String tipo;
    @Size(max = 50)
    @Column(name = "raza")
    private String raza;
    @Size(max = 150)
    @Column(name = "codigo_mascota")
    private String codigoMascota;
    @Lob
    @Size(max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Lob
    @Size(max = 65535)
    @Column(name = "color")
    private String color;
    @Column(name = "estado")
    private Integer estado;

    public Mascota() {
    }

    public Mascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public Mascota(Long idMascota, String nombreMascota, String genero, String tipo) {
        this.idMascota = idMascota;
        this.nombreMascota = nombreMascota;
        this.genero = genero;
        this.tipo = tipo;
    }

    public Long getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(Long idMascota) {
        this.idMascota = idMascota;
    }

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getCodigoMascota() {
        return codigoMascota;
    }

    public void setCodigoMascota(String codigoMascota) {
        this.codigoMascota = codigoMascota;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
        hash += (idMascota != null ? idMascota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mascota)) {
            return false;
        }
        Mascota other = (Mascota) object;
        if ((this.idMascota == null && other.idMascota != null) || (this.idMascota != null && !this.idMascota.equals(other.idMascota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yvaganet.finder.model.Mascota[ idMascota=" + idMascota + " ]";
    }
    
}
