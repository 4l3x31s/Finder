/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.Persona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Alexeis
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @PersistenceContext(unitName = "primary")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonaFacade() {
        super(Persona.class);
    }

    @Override
    public Persona findPersonaByUser(String user) {
        Query query = em.createQuery("SELECT m FROM Persona m WHERE m.usuario = :user order by 1 desc");
        query.setParameter("user",user);
        return (Persona)query.getSingleResult();
    }

    @Override
    public Persona findUserByUserPass(String user, String pass) {
        Query query = em.createQuery("SELECT m FROM Persona m WHERE m.usuario = :user AND m.password = :pass order by 1 desc");
        query.setParameter("user",user);
        query.setParameter("pass",pass);
        return (Persona)query.getSingleResult();
    }
}
