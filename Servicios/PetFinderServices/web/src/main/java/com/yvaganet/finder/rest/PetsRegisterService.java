package com.yvaganet.finder.rest;

import com.yvaganet.finder.objects.RequestCreateMascota;
import com.yvaganet.finder.service.MascotaFacadeLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Alexeis on 15 jun 2016.
 */

@Path("/pets")
@RequestScoped
public class PetsRegisterService {
    @Inject
    private MascotaFacadeLocal mascotaFacadeLocal;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarMascota(RequestCreateMascota request){
        try{

        }catch (Exception ex){

        }
        return Response.ok("").build();
    }
}
