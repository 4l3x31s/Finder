/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yvaganet.finder.service;

import com.yvaganet.finder.model.LogSession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author acarrillo
 */
@Local
public interface LogSessionFacadeLocal {

    void create(LogSession logSession);

    void edit(LogSession logSession);

    void remove(LogSession logSession);

    LogSession find(Object id);

    List<LogSession> findAll();

    List<LogSession> findRange(int[] range);

    int count();
    
    LogSession findByToken(String token);

}
