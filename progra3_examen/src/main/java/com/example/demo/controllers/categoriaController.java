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

import com.example.demo.entity.Categoria;
import com.example.demo.repository.categoriaRepository;


@RestController
@RequestMapping(value = "/categoria")
public class categoriaController {
	
	@Autowired
	categoriaRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Categoria> getListaCategoria(){
		Iterable<Categoria> listaCategoria = repository.findAll();
		
		return (Collection<Categoria>) listaCategoria;
	}

	@GetMapping(value = "/{id_categoria}")
	@ResponseStatus(code = HttpStatus.OK)
	public Categoria getCategoria(@PathVariable (name = "id_categoria") Long id_categoria) {
		
		Optional<Categoria> categoria = repository.findById(id_categoria);
		Categoria result = null;
		if(categoria.isPresent()) {
			result = categoria.get();
		}
		return result;
	}
		
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		Categoria nuevaCategoria = repository.save(categoria);
		return nuevaCategoria;
	}
	
	@DeleteMapping(value = "/{id_categoria}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void borrarCategoria(@PathVariable(name = "id_categoria")Long id_categoria) {
		repository.deleteById(id_categoria);
	}
	
	@PutMapping(value = "/{id_categoria}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Categoria uptadeCategoria(@PathVariable(name="id_categoria")Long id_categoria,
			@RequestBody Categoria categoria) {
		Optional<Categoria> oCategoria = repository.findById(id_categoria);
		if(oCategoria.isPresent()) {
			Categoria actual = oCategoria.get();
			actual.setId_categoria(id_categoria);
			actual.setNombre(categoria.getNombre());
			actual.setDescripcion(categoria.getDescripcion());
			actual.setFecha(categoria.getFecha());
			Categoria modificar = repository.save(actual);
			return modificar;
		}
		return null;
	}
}