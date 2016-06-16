package com.yvaganet.finder.controller;


import com.yvaganet.finder.model.LogSession;
import com.yvaganet.finder.service.LogSessionFacadeLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * Created by acarrillo on 16/06/2016.
 */
@RequestScoped
public class SessionController {
    @Inject
    private LogSessionFacadeLocal logSessionFacadeLocal;

    public boolean validarSession(String authToken){
        try{
            LogSession logSession = logSessionFacadeLocal.findByToken(authToken);
            if(logSession!=null){
                if(logSession.getToken()!=null){
                    return true;
                }else
                {
                    return false;
                }
            }else{
                return false;
            }
        }catch (Exception ex){
            return false;
        }


    }
}
