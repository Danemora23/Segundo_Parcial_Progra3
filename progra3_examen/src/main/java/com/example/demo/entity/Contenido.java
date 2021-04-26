package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "contenido")
public class Contenido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_contenido;
	@Column(name = "resumen")
	private String resumen;
	@Column(name = "categoria")
	private int categoria;
	@Column(name = "genero")
	private int Genero;
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fecha;
	public Long getId_contenido() {
		return id_contenido;
	}
	public void setId_contenido(Long id_contenido) {
		this.id_contenido = id_contenido;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getGenero() {
		return Genero;
	}
	public void setGenero(int genero) {
		Genero = genero;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

}
