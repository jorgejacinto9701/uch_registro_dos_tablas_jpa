package com.redsocial.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "galleta")
public class Galleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idgalleta")
	private int idGalleta;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "stock")
	private int stock;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaVencimiento")
	private Date fechaVencimiento;
	
	//LAZY--Perezoso-->Va traer categoria cuando se lo piden(Mejor performance)
	//EAGER-->Ansioso-->Va traer categoria inmediatamente
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idcategoria")
	private Categoria categoria;
	
	public int getIdGalleta() {
		return idGalleta;
	}
	public String getNombre() {
		return nombre;
	}
	public int getStock() {
		return stock;
	}
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setIdGalleta(int idGalleta) {
		this.idGalleta = idGalleta;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
