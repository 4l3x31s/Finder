package com.yvaganet.finder.rest;

import com.yvaganet.finder.objects.RequestMascotaPerdida;
import com.yvaganet.finder.service.DireccionesMascotaFacadeLocal;

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
@Path("/pet_finder")
@RequestScoped
public class PetFinderService {
    @Inject
    private DireccionesMascotaFacadeLocal direccionesMascotaFacadeLocal;

    @POST
    @Path("/register_pet_lost")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarMascotaPerdida(RequestMascotaPerdida request)
    {
        try {

        }catch (Exception ex){

        }
        return Response.ok("").build();
    }
}
