package br.com.usermanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.usermanagement.entities.Users;

public interface UsersRepository extends JpaRepository<Users, Long> { 
	
	@Query(nativeQuery = true, value = """
	SELECT tb_users.id, tb_users.fullName, tb_users.email, tb_users.phone, tb_users.birthDate, tb_users.userType
			FROM tb_users
		""")	
	
	List<Users> searchByList(Long listId);
}
