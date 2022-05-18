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

import com.crud.h2.dto.Articulo;
import com.crud.h2.service.ArticuloServiceImpl;

@RestController
@RequestMapping("/api")
public class ArticuloController {
	
	@Autowired
	ArticuloServiceImpl articuloServiceImple;
	
	@GetMapping("/articulos")
	public List<Articulo> listarArticulos(){
		return articuloServiceImple.listarArticulos();
	}
	
	@PostMapping("/articulos")
	public Articulo salvarArticulo(@RequestBody Articulo articulo) {
		return articuloServiceImple.guardarArticulo(articulo);
	}
	
	@GetMapping("/articulo/{id}")
	public Articulo articuloXID(@PathVariable(name="id") Long id) {
		
		Articulo articulo_xid= new Articulo();
		
		articulo_xid=articuloServiceImple.articuloXID(id);
		
		System.out.println("Articulo: "+articulo_xid);
		
		return articulo_xid;
	}
	@PutMapping("/articulo/{id}")
	public Articulo actualizarArticulo(@PathVariable(name = "id")Long id, @RequestBody Articulo articulo) {
		Articulo articulo_selec = new Articulo();
		Articulo articulo_actu = new Articulo();
		
		articulo_selec = articuloServiceImple.articuloXID(id);
		
		articulo_selec.setNombre(articulo.getNombre());
		articulo_selec.setPrecio(articulo.getPrecio());
		articulo_selec.setFabricante(articulo.getFabricante());
		
		System.out.println("El articulo actualizado es: "+ articulo_actu);
		
		return articulo_selec;
				
	}
	@DeleteMapping("/articulos/{id}")
	public void eliminarArticulo(@PathVariable(name = "id")Long id) {
		articuloServiceImple.eliminarArticulo(id);
	}
}


