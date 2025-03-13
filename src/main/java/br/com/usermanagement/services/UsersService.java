package br.com.usermanagement.services;

import java.io.ObjectInputFilter.Status;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.usermanagement.entities.Users;
import br.com.usermanagement.dto.UsersDTO;
import br.com.usermanagement.repositories.UsersRepository;
import br.com.usermanagement.exceptions.UnprocessableEntity;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	@Transactional(readOnly = true)
	public Optional<UsersDTO> findById(Long id){
		Optional<Users> result = usersRepository.findById(id);
		return result.stream().map(UsersDTO::new).findAny();
	}
	
	@Transactional(readOnly = true)
	public List<UsersDTO> findAll() {
		List<Users> list = usersRepository.findAll();
		return list.stream().map(UsersDTO::new).toList();
	}
	
	
	@Transactional(readOnly = true)
	public List<UsersDTO> create(Users user) {
		usersRepository.save(user);
		return findAll();
	}
	
	@Transactional(readOnly = true)
	public List<UsersDTO> update(Long id, Users user) {
		usersRepository.findById(id).ifPresentOrElse((existingUser) -> {
			user.setId(id);
			usersRepository.save(user);
		}, () -> {
			throw new UnprocessableEntity(HttpStatus.NOT_FOUND);
		});
		return findAll();
	}
	
	@Transactional(readOnly = true)
	public List<UsersDTO> delete(Long id) {
		usersRepository.findById(id).ifPresentOrElse((existingUser) -> usersRepository.delete(existingUser), () -> {
			throw new UnprocessableEntity(HttpStatus.NOT_FOUND);
		});
		
		return findAll();
	}
	
}
