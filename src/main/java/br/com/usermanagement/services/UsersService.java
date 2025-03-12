package br.com.usermanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.usermanagement.entities.Users;
import br.com.usermanagement.dto.UsersDTO;
import br.com.usermanagement.repositories.UsersRepository;


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
	
	
	
}
