package com.yvaganet.finder.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yvaganet.finder.model.Persona;
import com.yvaganet.finder.objects.RequestUser;
import com.yvaganet.finder.service.PersonaFacadeLocal;

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
		try{
			Persona persona = new Persona();
			persona.setApellidoPersona(request.getApellido());
	        persona.setCiudad(request.getCiudad());
	        persona.setDireccionPersona(request.getDireccion());
	        persona.setEmail(request.getEmail());
	        persona.setEstado(false);
	        persona.setLatitud(request.getLatitud());
	        persona.setLongitud(request.getLongitud());
	        persona.setNombrePersona(request.getNombre());
	        persona.setPassword(request.getPass());
	        persona.setUsuario(request.getUser());
			context.create(persona);
		}catch(Exception ex){
			System.out.println("Error: " + ex.getMessage());
		}finally{
			return Response.ok("").build();
		}
	}
}
