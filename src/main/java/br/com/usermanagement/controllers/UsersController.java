package br.com.usermanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usermanagement.dto.UsersDTO;
import br.com.usermanagement.entities.Users;
import br.com.usermanagement.services.UsersService;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	@PostMapping
	ResponseEntity<List<UsersDTO>> create(@Validated @RequestBody Users user) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usersService.create(user));
	}
	
	@PutMapping
	List<UsersDTO> update(@PathVariable Long id, @RequestBody Users user){
		return usersService.update(id, user);
	}
	
	@DeleteMapping
	List<UsersDTO> delete(@PathVariable Long id) {
		return usersService.delete(id);
	}
	
	@GetMapping(value = "/{id}")
	public Optional<UsersDTO> findId(@PathVariable Long id) {
		return usersService.findById(id);
	}
	
	@GetMapping
	public List<UsersDTO> findAll() {
		List<UsersDTO> list = usersService.findAll();
		return list;
	}
}
