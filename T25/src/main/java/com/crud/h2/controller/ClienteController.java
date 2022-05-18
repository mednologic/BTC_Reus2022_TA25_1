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
import com.crud.h2.dto.Cliente;
import com.crud.h2.service.ClienteServiceImpl;

@RestController
@RequestMapping("/api")
public class ClienteController {
	
	@Autowired
	ClienteServiceImpl clienteServideImpl;
	
	@GetMapping("/clientes")
	public List<Cliente> listarClientes(){
		return clienteServideImpl.listarClientes();
	}
	
	@PostMapping("/clientes")
	public Cliente salvarCliente(@RequestBody Cliente cliente) {
		
		return clienteServideImpl.guardarCliente(cliente);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente clienteXID(@PathVariable(name="id") Long id) {
		
		Cliente cliente_xid= new Cliente();
		
		cliente_xid=clienteServideImpl.clienteXID(id);
		
		System.out.println("Cliente XID: "+cliente_xid);
		
		return cliente_xid;
	}
	
	@PutMapping("/clientes/{id}")
	public Cliente actualizarCliente(@PathVariable(name="id")Long id,@RequestBody Cliente cliente) {
		
		Cliente cliente_seleccionado= new Cliente();
		Cliente cliente_actualizado= new Cliente();
		
		cliente_seleccionado= clienteServideImpl.clienteXID(id);
		
		cliente_seleccionado.setNombre(cliente.getNombre());
		cliente_seleccionado.setApellido(cliente.getApellido());
		cliente_seleccionado.setDireccion(cliente.getDireccion());
		cliente_seleccionado.setDni(cliente.getDni());
		cliente_seleccionado.setFecha(cliente.getFecha());
		
		cliente_actualizado = clienteServideImpl.actualizarCliente(cliente_seleccionado);
		
		System.out.println("El cliente actualizado es: "+ cliente_actualizado);
		
		return cliente_actualizado;
	}
	
	@DeleteMapping("/clientes/{id}")
	public void eleiminarCliente(@PathVariable(name="id")Long id) {
		clienteServideImpl.eliminarCliente(id);
	}
	
	
}
