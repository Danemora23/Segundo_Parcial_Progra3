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
@Table(name = "genero")
public class Genero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_genero;
	@Column(name = "nombre")
	private String genero;
	@Column(name = "descripcion")
	private String decripcionGenero;
	@Column(name = "fecha")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechacreacion;
	
	public Long getId_genero() {
		return id_genero;
	}
	public void setId_genero(Long id_genero) {
		this.id_genero = id_genero;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDecripcionGenero() {
		return decripcionGenero;
	}
	public void setDecripcionGenero(String decripcionGenero) {
		this.decripcionGenero = decripcionGenero;
	}
	public LocalDate getFechacreacion() {
		return fechacreacion;
	}
	public void setFechacreacion(LocalDate fechacreacion) {
		this.fechacreacion = fechacreacion;
	}
	
}
