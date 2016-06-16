package com.yvaganet.finder.objects;

/**
 * Created by acarrillo on 16/06/2016.
 */
public class ResponseLogin extends ResponseGlobal {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
