package com.crud.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.h2.dto.Fabricante;
import com.crud.h2.service.FabricanteServiceImpl;

@RestController
@RequestMapping("/api")
public class FabricanteController {
	
	@Autowired
	FabricanteServiceImpl fabricanteServiceImpl;
	
	@GetMapping("/fabricantes")
	public List<Fabricante> listarFabricantes(){
		return fabricanteServiceImpl.listarFabricantes();
	}
	@PostMapping("/fabricantes")
	public Fabricante salvarFabricante(@RequestBody Fabricante fabricante) {
		return fabricanteServiceImpl.guardarFabricante(fabricante);
	}
	@GetMapping("/Fabricantes/{id}")
	public Fabricante fabricanteXID(@PathVariable(name = "id")Long id) {
		Fabricante fabricante_xid = new Fabricante();
		fabricante_xid = fabricanteServiceImpl.fabricanteXID(id);
		System.out.println("Fabricante por id: "+fabricante_xid);
		return fabricante_xid;
	}
	@PutMapping("/Fabricantes/{id}")
	public Fabricante fabricante(@PathVariable(name ="id")Long id, @RequestBody Fabricante fabricante ) {
		Fabricante fabricante_select 	= new Fabricante();
		Fabricante fabricante_actua 	= new Fabricante();
		
		fabricante_select = fabricanteServiceImpl.fabricanteXID(id);
		
		fabricante_select.setNombre(fabricante.getNombre());
		
		fabricante_actua = fabricanteServiceImpl.actualizarFabricante(fabricante_select);
		
		System.out.println("Fabricante Actualizado: "+fabricante_actua);
		
		return fabricante_actua;
	}
	
	@DeleteMapping("/Fabricantes/{id}")
	public void eliminarFabricante(@PathVariable(name = "id")Long id) {
		fabricanteServiceImpl.eliminarFabricante(id);
		
	}

}
