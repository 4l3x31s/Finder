/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.DireccionesMascota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alexeis
 */
@Local
public interface DireccionesMascotaFacadeLocal {

    void create(DireccionesMascota direccionesMascota);

    void edit(DireccionesMascota direccionesMascota);

    void remove(DireccionesMascota direccionesMascota);

    DireccionesMascota find(Object id);

    List<DireccionesMascota> findAll();

    List<DireccionesMascota> findRange(int[] range);

    int count();
    
}
