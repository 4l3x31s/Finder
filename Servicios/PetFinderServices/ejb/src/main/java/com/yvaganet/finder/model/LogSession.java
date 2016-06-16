/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acarrillo
 */
@Entity
@Table(name = "log_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogSession.findAll", query = "SELECT l FROM LogSession l"),
    @NamedQuery(name = "LogSession.findByIdSession", query = "SELECT l FROM LogSession l WHERE l.idSession = :idSession"),
    @NamedQuery(name = "LogSession.findByIdPersona", query = "SELECT l FROM LogSession l WHERE l.idPersona = :idPersona"),
    @NamedQuery(name = "LogSession.findByToken", query = "SELECT l FROM LogSession l WHERE l.token = :token"),
    @NamedQuery(name = "LogSession.findByFecha", query = "SELECT l FROM LogSession l WHERE l.fecha = :fecha"),
    @NamedQuery(name = "LogSession.findByHora", query = "SELECT l FROM LogSession l WHERE l.hora = :hora"),
    @NamedQuery(name = "LogSession.findByEstado", query = "SELECT l FROM LogSession l WHERE l.estado = :estado")})
public class LogSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = true)
    @Column(name = "id_session")
    private Long idSession;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona")
    private long idPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "token")
    private String token;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Column(name = "estado")
    private Integer estado;

    public LogSession() {
    }

    public LogSession(Long idSession) {
        this.idSession = idSession;
    }

    public LogSession(Long idSession, long idPersona, String token) {
        this.idSession = idSession;
        this.idPersona = idPersona;
        this.token = token;
    }

    public Long getIdSession() {
        return idSession;
    }

    public void setIdSession(Long idSession) {
        this.idSession = idSession;
    }

    public long getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
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
        hash += (idSession != null ? idSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogSession)) {
            return false;
        }
        LogSession other = (LogSession) object;
        if ((this.idSession == null && other.idSession != null) || (this.idSession != null && !this.idSession.equals(other.idSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.yvaganet.finder.model.LogSession[ idSession=" + idSession + " ]";
    }
    
}
