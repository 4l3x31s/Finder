/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.controller;

import com.yvaganet.finder.model.Persona;
import com.yvaganet.finder.service.PersonaFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Alexeis
 */
@Named(value = "testController")
@RequestScoped
public class testController {

    @Inject
    private PersonaFacadeLocal personasFacade;
    /**
     * Creates a new instance of testController
     */
    public testController() {
    }
    
    public void insertarDatos(){
        Persona persona = new Persona();
        persona.setApellidoPersona("Carrillo");
        persona.setCiudad("La Paz");
        persona.setDireccionPersona("Obrajes Calle 22");
        persona.setEmail("panthon.six@gmail.com");
        persona.setEstado(0);
        persona.setLatitud("1.515151");
        persona.setLongitud("1.121515");
        persona.setNombrePersona("Alexeis");
        persona.setPassword("123456");
        persona.setUsuario("guanyu");
        personasFacade.create(persona);
    }
}
