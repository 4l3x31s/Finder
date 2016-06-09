/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.DireccionesMascota;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Alexeis
 */
@Stateless
public class DireccionesMascotaFacade extends AbstractFacade<DireccionesMascota> implements DireccionesMascotaFacadeLocal {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DireccionesMascotaFacade() {
        super(DireccionesMascota.class);
    }
    
}
