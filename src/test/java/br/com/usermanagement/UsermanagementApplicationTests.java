package br.com.usermanagement;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.com.usermanagement.entities.Users;
import br.com.usermanagement.repositories.UsersRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UsermanagementApplicationTests {

	 @LocalServerPort
	    private int port;

	    @Autowired
	    private TestRestTemplate restTemplate;

	    @Autowired
	    private UsersRepository usersRepository;

	    private String baseUrl;

	    @BeforeEach
	    void setUp() {
	        baseUrl = "http://localhost:" + port + "/users";
	        usersRepository.deleteAll(); // Limpa os dados antes de cada teste
	    }

	    private Date parseDate(String date) throws ParseException {
	        return new SimpleDateFormat("yyyy-MM-dd").parse(date);
	    }

	    @Test
	    void deveCriarUsuario() throws ParseException {
	        Users user = new Users(null, "João Silva", "joao.silva@email.com", "11987654321", parseDate("1990-05-15"), "ADMIN");

	        ResponseEntity<Users> response = restTemplate.postForEntity(baseUrl, user, Users.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	        assertThat(response.getBody()).isNotNull();
	        assertThat(response.getBody().getId()).isNotNull();
	    }

	    @Test
	    void deveBuscarUsuarioPorId() throws ParseException {
	        Users user = new Users(null, "Maria Oliveira", "maria.oliveira@email.com", "21976543210", parseDate("1985-10-20"), "USER");
	        user = usersRepository.save(user);

	        ResponseEntity<Users> response = restTemplate.getForEntity(baseUrl + "/" + user.getId(), Users.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        assertThat(response.getBody()).isNotNull();
	        assertThat(response.getBody().getFullName()).isEqualTo("Maria Oliveira");
	    }

	    @Test
	    void deveRetornarTodosUsuarios() throws ParseException {
	        usersRepository.save(new Users(null, "Carlos Santos", "carlos.santos@email.com", "31998765432", parseDate("1992-03-08"), "MODERATOR"));

	        ResponseEntity<Users[]> response = restTemplate.getForEntity(baseUrl, Users[].class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        assertThat(response.getBody()).isNotEmpty();
	    }

	    @Test
	    void deveAtualizarUsuario() throws ParseException {
	        Users user = usersRepository.save(new Users(null, "Pedro Lima", "pedro.lima@email.com", "11955554444", parseDate("1988-12-05"), "USER"));

	        user.setPhone("11999998888");
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<Users> requestUpdate = new HttpEntity<>(user, headers);

	        ResponseEntity<Users> response = restTemplate.exchange(baseUrl + "/" + user.getId(), HttpMethod.PUT, requestUpdate, Users.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	        assertThat(response.getBody()).isNotNull();
	        assertThat(response.getBody().getPhone()).isEqualTo("11999998888");
	    }

	    @Test
	    void deveDeletarUsuario() throws ParseException {
	        Users user = usersRepository.save(new Users(null, "Ana Souza", "ana.souza@email.com", "21988887777", parseDate("1995-07-22"), "USER"));

	        ResponseEntity<Void> response = restTemplate.exchange(baseUrl + "/" + user.getId(), HttpMethod.DELETE, null, Void.class);

	        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
	        assertThat(usersRepository.findById(user.getId())).isEmpty();
	    }

}
