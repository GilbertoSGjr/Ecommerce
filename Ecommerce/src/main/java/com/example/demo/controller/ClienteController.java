package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	private List<Cliente> listar(){		
		return clienteRepository.findAll();		
	}
	
	@GetMapping("/{clienteNome}")
	public ResponseEntity<Cliente> buscar(@PathVariable String clienteNome) {
		Optional<Cliente> cliente = clienteRepository.findByNome(clienteNome);
		if(cliente.isPresent()) {				
			return ResponseEntity.ok(cliente.get());
		}
		return ResponseEntity.notFound().build();  
	}
	
	@PostMapping
	public ResponseEntity<Cliente> adicionar(@RequestBody Cliente cliente){
		if(cliente != null) {
			return ResponseEntity.ok(clienteRepository.save(cliente));
		}
		return ResponseEntity.badRequest().build();
	}
	
	
}
