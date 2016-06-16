package com.yvaganet.finder.rest;

import com.google.gson.Gson;
import com.sun.org.omg.CORBA.RepositoryIdSeqHelper;
import com.yvaganet.finder.controller.SessionController;
import com.yvaganet.finder.model.Mascota;
import com.yvaganet.finder.model.Persona;
import com.yvaganet.finder.objects.RequestCreateMascota;
import com.yvaganet.finder.objects.ResponseGlobal;
import com.yvaganet.finder.objects.ResponseRegisterPet;
import com.yvaganet.finder.service.MascotaFacadeLocal;
import com.yvaganet.finder.service.PersonaFacadeLocal;
import com.yvaganet.finder.util.ConstantesUtil;
import com.yvaganet.finder.util.SecurityUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.math.BigInteger;

/**
 * Created by Alexeis on 15 jun 2016.
 */

@Path("/pets")
@RequestScoped
public class PetsRegisterService {
    @Inject
    private MascotaFacadeLocal mascotaFacadeLocal;
    @Inject
    private PersonaFacadeLocal personaFacadeLocal;
    @Inject
    private SessionController sessionController;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrarMascota(RequestCreateMascota request){
        ResponseRegisterPet responseRegisterPet;
        Gson gson;
        try{
            if(sessionController.validarSession(request.getAuthToken())) {
                if (request.getImagen() != null) {
                    Persona personaObj = personaFacadeLocal.findPersonaByUser(request.getUsuario());
                    SecurityUtil securityUtil = new SecurityUtil();
                    securityUtil.addKey(ConstantesUtil.key);
                    String hashMascota = securityUtil.encriptar(request.getNom() + request.getGenero() + personaObj.getUsuario());
                    Mascota mascota = new Mascota();
                    mascota.setImagen(request.getImagen());
                    mascota.setEstado(0);
                    mascota.setCodigoMascota(hashMascota);
                    mascota.setColor(request.getColor());
                    mascota.setGenero(request.getGenero());
                    mascota.setIdPersona(new BigInteger(personaObj.getIdPersona().toString()));
                    mascota.setNombreMascota(request.getNom());
                    mascota.setRaza(request.getRaza());
                    mascota.setTipo(request.getTipo());
                    mascotaFacadeLocal.create(mascota);
                    responseRegisterPet = new ResponseRegisterPet();
                    responseRegisterPet.setEstado(true);
                    responseRegisterPet.setMensaje("El dato se ha registrado correctamente");
                    responseRegisterPet.setDatoQrMascota(hashMascota);
                } else {
                    //TODO: retornar Error
                    responseRegisterPet = new ResponseRegisterPet();
                    responseRegisterPet.setEstado(false);
                    responseRegisterPet.setMensaje("El usuario no inició sessión.");
                    gson = new Gson();
                    return Response.status(401).entity(gson.toJson(responseRegisterPet)).build();
                }
                gson = new Gson();
                return Response.ok(gson.toJson(responseRegisterPet)).build();
            }else{
                gson = new Gson();
                responseRegisterPet = new ResponseRegisterPet();
                responseRegisterPet.setEstado(false);
                responseRegisterPet.setMensaje("Debe iniciar sessión para esta función.");
                return Response.status(401).entity(gson.toJson(responseRegisterPet)).build();
            }
        }catch (Exception ex){
            responseRegisterPet = new ResponseRegisterPet();
            responseRegisterPet.setMensaje("No se pudo registrar el error");
            responseRegisterPet.setEstado(false);
            gson = new Gson();
            return Response.status(401).entity(gson.toJson(responseRegisterPet)).build();
        }

    }
}
