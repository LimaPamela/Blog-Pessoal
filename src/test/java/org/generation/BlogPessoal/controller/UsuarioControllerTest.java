package org.generation.BlogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.generation.BlogPessoal.service.UsuarioService;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {
	
	//serve para ter acesso aos verbos http(get post put delete) em modo teste
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	// serve para conseguirmos usar as funções de serviço do usuario
	@Autowired
	private UsuarioService usuarioService;
	
	//serve para acesso ao banco de dados h2
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//antes de começar o teste, limpa o banco de dados h2 e cadastra um novo usuário
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
				"Root", "root@root.com", "rootroot", " "));
	}
	
	//indica que o código abaixo será um teste
	@Test
	// indica um nome de exibição para o teste no console do JUnit
	@DisplayName("Cadastrar Um Usuário")
	public void deveCriarUmUsuario() {
		
		// define o que eu estou mandando para minha api enviar para o banco de dados
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L,
				"Paulo Antunes", "paulo_antunes@email.com.br", "13465278", "https://i.imgur.com/yKSBW2a_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		// define o que eu vou obter como resposta do que foi 'persistido' no banco de dados 'h2'
		ResponseEntity<Usuario> corpoResposta = testRestTemplate
				.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
		
		// faço a verificação se o status http da resposta foi igual a 201 Created
		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
		// faço a verificação se o que eu mandei de nome do usuario foi o que efetivamente chegou no banco de dados
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		// faço a verificação se o que eu mandei de email do usuario foi o que efetivamente chegou no banco de dados
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());
		
	}
	
	@Test
	@DisplayName("Não deve permitir duplicação do Usuário")
	public void naoDeveDuplicarUsuario() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
				"Maria da Silva", "maria_silva@email.com.br", "13465278", "https://i.imgur.com/BjemalW_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L,
				"Maria da Silva", "maria_silva@email.com.br", "13465278", "https://i.imgur.com/BjemalW_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		ResponseEntity<Usuario> corpoResposta = testRestTemplate
				.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
		
		assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
	}
	
	@Test
	@DisplayName("Atualizar um Usuário")
	public void deveAtualizarUmUsuario() {

		Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(new Usuario(0L, 
			"Juliana Andrews", "juliana_andrews@email.com.br", "juliana123", "https://i.imgur.com/yDRVeK7.jpg"));

		Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(), 
			"Juliana Andrews Ramos", "juliana_ramos@email.com.br", "juliana123" , "https://i.imgur.com/yDRVeK7.jpg");
		
		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(usuarioUpdate);

		ResponseEntity<Usuario> corpoResposta = testRestTemplate
			.withBasicAuth("root@root.com", "rootroot")
			.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoRequisicao, Usuario.class);

		assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());
	}
	
	@Test
	@DisplayName("Listar todos os Usuários")
	public void deveMostrarTodosUsuarios() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
				"Sabrina Sanches", "sabrina_sanches@email.com.br", "sabrina123", "https://i.imgur.com/mbGW1vM_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
				"Ricardo Marques", "ricardo_marques@email.com.br", "ricardo123", "https://i.imgur.com/8IZZyGT_d.webp?maxwidth=520&shape=thumb&fidelity=high"));
		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				  	.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
}