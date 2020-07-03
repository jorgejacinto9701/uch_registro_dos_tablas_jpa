package com.redsocial.entidad;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcategoria")
	private int idCategoria;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany(mappedBy = "categoria")
	private List<Galleta> galletas;

	public int getIdCategoria() {
		return idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
