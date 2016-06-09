/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.Mascota;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Alexeis
 */
@Local
public interface MascotaFacadeLocal {

    void create(Mascota mascota);

    void edit(Mascota mascota);

    void remove(Mascota mascota);

    Mascota find(Object id);

    List<Mascota> findAll();

    List<Mascota> findRange(int[] range);

    int count();
    
}
