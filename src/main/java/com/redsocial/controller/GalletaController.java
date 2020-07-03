package com.redsocial.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redsocial.entidad.Categoria;
import com.redsocial.entidad.Galleta;
import com.redsocial.servicio.CategoriaService;
import com.redsocial.servicio.GalletaService;

@Controller
public class GalletaController {

	@Autowired
	private GalletaService galletaService;
	
	@Autowired
	private CategoriaService categoriaService;
	

	@RequestMapping("/verRegistroGalleta")
	public String verRegGalleta() {
		return "registraGalleta";
	}

	//Permite retornar datos en formato json, sirve para llenar el combo de categoría
	@ResponseBody
	@RequestMapping("/cargaCategoria")
	public List<Categoria> cargaComboCategoria() {
		return categoriaService.listarTodos();
	}
	
	//session permite guardar en memoria objetos
	@RequestMapping("/registroDeGalleta")
	public String verRegGalleta(Galleta obj, HttpSession session) {
		Galleta objRep =  galletaService.insertaGalleta(obj);
		if(objRep == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitos");
		}
		return "registraGalleta";
	}
}










