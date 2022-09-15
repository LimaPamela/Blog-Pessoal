package org.generation.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.generation.BlogPessoal.model.Usuario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {


	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		UsuarioRepository.deletAll();
		
		UsuarioRepository.save(new Usuario(0l, "João da Silva", "joao@email.com", "12345678",
				"https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/orange-heart_1f9e1.png"));
	
		UsuarioRepository.save(new Usuario(0l, "José da Silva", "jose@email.com", "12345678",
				"https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/green-heart_1f49a.png"));
		
		UsuarioRepository.save(new Usuario(0l, "Maria da Silva", "maria@email.com", "12345678",
				"https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/blue-heart_1f499.png"));
		
		UsuarioRepository.save(new Usuario(0l, "Margarida da Silva", "margarida@email.com", "12345678",
				"https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/purple-heart_1f49c.png"));
	}

	
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuario() {

		List<Usuario> ListaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, ListaDeUsuarios.size());
		assertTrue(ListaDeUsuarios.get(1).getNome().equals("João da Silva"));
		assertTrue(ListaDeUsuarios.get(1).getNome().equals("Maria da Silva"));
		assertTrue(ListaDeUsuarios.get(3).getNome().equals("Margarida da Silva"));
	
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}