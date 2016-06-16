/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.LogSession;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author acarrillo
 */
@Stateless
public class LogSessionFacade extends AbstractFacade<LogSession> implements LogSessionFacadeLocal {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LogSessionFacade() {
        super(LogSession.class);
    }

    @Override
    public LogSession findByToken(String token) {
        Query query = em.createQuery("SELECT m FROM LogSession m WHERE m.token = :token order by 1 desc");
        query.setParameter("token",token);
        return (LogSession) query.getSingleResult();
    }
    
}
