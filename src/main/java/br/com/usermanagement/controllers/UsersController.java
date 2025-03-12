package br.com.usermanagement.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.usermanagement.dto.UsersDTO;
import br.com.usermanagement.services.UsersService;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {

	@Autowired
	private UsersService usersService;
	
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
