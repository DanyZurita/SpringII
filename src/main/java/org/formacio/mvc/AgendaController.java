package org.formacio.mvc;

import org.formacio.repositori.AgendaService;
import org.formacio.repositori.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AgendaController {

	@Autowired
	private AgendaService agenda;
	
	@RequestMapping(path="/nombre")
	@ResponseBody
	public int numeroContactos() {
		return agenda.nombreContactes();
	}
	

	@RequestMapping(path="/telefon")
	@ResponseBody
	public String numeroContactos(String id) {
		return agenda.recupera(id).getTelefon();
	}
	
	
	@RequestMapping(path="/contacte/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Persona personaContacto(@PathVariable String id) {
		return new Persona(id, agenda.recupera(id).getNom(), agenda.recupera(id).getTelefon());
	}
	
	
}
