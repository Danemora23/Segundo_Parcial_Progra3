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

import com.example.demo.entity.Genero;
import com.example.demo.repository.GeneroRepository;

@RestController
@RequestMapping(value = "/genero")
public class generoControllers {
	
	@Autowired
	GeneroRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Genero> getListaGenero(){
		Iterable<Genero> listaGenero = repository.findAll();
		return (Collection<Genero>) listaGenero;
	}
	
	@GetMapping(value = "/{id_genero}")
	@ResponseStatus(code = HttpStatus.OK)
	public Genero getGenero(@PathVariable (name = "id_genero") Long id_genero) {
		
		Optional<Genero> genero = repository.findById(id_genero);
		Genero result = null;
		if(genero.isPresent()) {
			result = genero.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Genero crearCategoria(@RequestBody Genero genero) {
		Genero nuevoGenero = repository.save(genero);
		return nuevoGenero;
	}
	
	@DeleteMapping(value = "/{id_genero}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void borrarGenero(@PathVariable(name = "id_genero")Long id_genero) {
		repository.deleteById(id_genero);
	}
	
	@PutMapping(value = "/{id_genero}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Genero uptadeGenero(@PathVariable(name="id_genero")Long id_genero,
			@RequestBody Genero genero) {
		Optional<Genero> oGenero = repository.findById(id_genero);
		if(oGenero.isPresent()) {
			Genero actual = oGenero.get();
			actual.setId_genero(id_genero);
			actual.setGenero(genero.getGenero());
			actual.setDecripcionGenero(genero.getDecripcionGenero());
			actual.setFechacreacion(genero.getFechacreacion());
			Genero modi = repository.save(actual);
			return modi;
		}
		return null;
	}

}
