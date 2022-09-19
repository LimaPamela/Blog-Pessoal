package org.generation.BlogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


import org.generation.BlogPessoal.model.Usuario;


//indicica que a classe UsuarioRepositoryTest é uma classe de test, e que esse teste será rodado em uma porta aleatória local no meu computador (desde que ela não esteja sendo usada)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//indica que o teste a ser feito vai ser um teste unitário por classe
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	// inserindo usuarios no meu banco de dados h2, para que eu possa testar as funções de procurar um usuario por nome e por email
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		// inserindo usuarios no meu banco de dados h2, para que eu possa testar as funções de procurar um usuario por nome e por email
		usuarioRepository.save(new Usuario(0L, "João da Silva", "joao@email.com", "13465278", "https://i.imgur.com/cuQdfFe_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		usuarioRepository.save(new Usuario(0L, "Manuela da Silva", "manuela@email.com", "13465278", "https://i.imgur.com/KhswlY9_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		usuarioRepository.save(new Usuario(0L, "Adriana da Silva", "adriana@email.com", "13465278", "https://i.imgur.com/KhswlY9_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		usuarioRepository.save(new Usuario(0L, "Paulo Antunes", "paulo@email.com", "13465278", "https://i.imgur.com/yKSBW2a_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
	}
	
	// indica o inicio do test
	@Test
	// indica o nome do test
	@DisplayName("Retorna 1 usuário")
	public void deveRetornarUmUsuario() {
		
		// o que eu espero receber da api, buscando um usuario pelo seu email
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com");
		// comparando se o que eu esperava receber, foi o que de fato meu teste trouxe
		assertTrue(usuario.get().getUsuario().equals("joao@email.com"));
	}
	
	@Test
	@DisplayName("Retorna 3 usuários")
	public void deveRetornarTresUsuarios() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Silva");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("João da Silva"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Manuela da Silva"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Adriana da Silva"));
	}
	
	@AfterAll
	public void end() {
		usuarioRepository.deleteAll();
	}
}