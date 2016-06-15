package com.yvaganet.finder.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.yvaganet.finder.model.Persona;
import com.yvaganet.finder.objects.RequestUser;
import com.yvaganet.finder.objects.ResponseGlobal;
import com.yvaganet.finder.service.PersonaFacadeLocal;
import com.yvaganet.finder.util.MailUtil;

@Path("/user")
@RequestScoped
public class UserService {
	
	@Inject
	private PersonaFacadeLocal context;
	
	@POST
	@Path("/registro")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response registroCliente(RequestUser request){
		Gson gson;
		ResponseGlobal responseGlobal;
		try{
			Persona persona = new Persona();
			persona.setApellidoPersona(request.getApellido());
	        persona.setCiudad(request.getCiudad());
	        persona.setDireccionPersona(request.getDireccion());
	        persona.setEmail(request.getEmail());
	        persona.setEstado(0);
	        persona.setLatitud(request.getLatitud());
	        persona.setLongitud(request.getLongitud());
	        persona.setNombrePersona(request.getNombre());
	        persona.setPassword(request.getPass());
	        persona.setUsuario(request.getUser());
			context.create(persona);
			responseGlobal = new ResponseGlobal();
			responseGlobal.setMensaje("El usuario fue registrado correctamente.");
			responseGlobal.setEstado(true);
			gson = new Gson();
			return Response.ok(gson.toJson(responseGlobal)).build();
		}catch(Exception ex){
			gson = new Gson();
			responseGlobal = new ResponseGlobal();
			responseGlobal.setEstado(false);
			responseGlobal.setMensaje("No se pudo registrar los datos del Usuario, Disculpe las molestias");
			return Response.status(401).entity(gson.toJson(responseGlobal)).build();
		}
	}
	@GET
	@Path("/send_mail/{para}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response enviarMail(@PathParam("para") String para){
		ResponseGlobal response = new ResponseGlobal();
		try{
			MailUtil mailUtil = new MailUtil();
			mailUtil.enviarMail(para);
			response.setEstado(true);
			response.setMensaje("El dato ha sido enviado correctamente");
		}catch (Exception ex){
			response.setEstado(true);
			response.setMensaje("Error al enviar mail: " + ex.getMessage());
		}
		Gson gson = new Gson();
		return Response.ok(gson.toJson(response)).build();
	}
}
