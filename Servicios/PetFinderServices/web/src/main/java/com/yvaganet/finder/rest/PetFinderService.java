package com.yvaganet.finder.rest;

import com.google.gson.Gson;
import com.yvaganet.finder.model.DireccionesMascota;
import com.yvaganet.finder.objects.RequestMascotaPerdida;
import com.yvaganet.finder.objects.ResponseGlobal;
import com.yvaganet.finder.service.DireccionesMascotaFacadeLocal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.math.BigInteger;
import java.util.Date;

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
            DireccionesMascota direccionesMascota = new DireccionesMascota();
            direccionesMascota.setComentario(request.getComentario());
            direccionesMascota.setDireccion(request.getDireccion());
            direccionesMascota.setEstado(0);
            direccionesMascota.setFecha(new Date());
            //TODO: algoritmo para convertir el dato de la mascota
            direccionesMascota.setIdMascota(this.convertirQrMascota(request.getQrMascota()));
            direccionesMascota.setImagen(request.getImagen());
            direccionesMascota.setLatitud(request.getLatitud());
            direccionesMascota.setLongitud(request.getLongitud());
            if(request.getContacto()!=null) {
                direccionesMascota.setNumeroContacto(request.getContacto());
            }
            direccionesMascotaFacadeLocal.create(direccionesMascota);
            Gson gson = new Gson();
            ResponseGlobal responseGlobal = new ResponseGlobal();
            responseGlobal.setMensaje("Los datos se han registrado correctamente.");
            responseGlobal.setEstado(true);
            return Response.ok(gson.toJson(responseGlobal)).build();

        }catch (Exception ex){
            Gson gson = new Gson();
            ResponseGlobal responseGlobal = new ResponseGlobal();
            responseGlobal.setMensaje("No se pudieron registrar los datos.");
            responseGlobal.setEstado(false);
            return Response.status(401).entity(gson.toJson(responseGlobal)).build();
        }

    }

    public BigInteger convertirQrMascota(String codigo){


        return new BigInteger(codigo);
    }
}
