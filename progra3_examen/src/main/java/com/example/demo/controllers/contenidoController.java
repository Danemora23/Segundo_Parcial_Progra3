package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Contenido;
import com.example.demo.repository.contenido.contenidoRepository;

@RestController
@RequestMapping(value = "/contenido")
public class contenidoController {

	
	@Autowired
	contenidoRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Contenido> getListaContenido(){
		Iterable<Contenido> listaContenido = repository.findAll();
		return (Collection<Contenido>) listaContenido;
	}
	
	@GetMapping(value = "/{id_contenido}")
	@ResponseStatus(code = HttpStatus.OK)
	public Contenido getContenido(@PathVariable (name = "id_contenido") Long id_contenido) {
		
		Optional<Contenido> contenido = repository.findById(id_contenido);
		Contenido result = null;
		if(contenido.isPresent()) {
			result = contenido.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Contenido crearContenido(@RequestBody Contenido contenido) {
		Contenido nuevoContenido = repository.save(contenido);
		return nuevoContenido;
	}
	
	@DeleteMapping(value = "/{id_contenido}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void borrarContenido(@PathVariable(name = "id_contenido")Long id_contenido) {
		repository.deleteById(id_contenido);
	}
	
	@PutMapping(value = "/{id_contenido}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Contenido uptadeGenero(@PathVariable(name="id_contenido")Long id_contenido,
			@RequestBody Contenido contenido) {
		Optional<Contenido> oContenido = repository.findById(id_contenido);
		if(oContenido.isPresent()) {
			Contenido actual = oContenido.get();
			actual.setId_contenido(id_contenido);
			actual.setResumen(contenido.getResumen());
			actual.setCategoria(contenido.getCategoria());
			actual.setGenero(contenido.getGenero());
			actual.setFecha(contenido.getFecha());
			Contenido modi = repository.save(actual);
			return modi;
		}
		return null;
	}	
}
