package org.generation.BlogPessoal.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.BlogPessoal.model.Usuario;
import org.generation.BlogPessoal.repository.UsuarioRepository;
import org.generation.BlogPessoal.service.UsuarioService;
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

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@BeforeAll
	void start() {

		UsuarioRepository.deleteAll();

		UsuarioService.cadastrarUsuario(new Usuario(0l, "Root", "roo@root.com", "rootroot", " "));
	}

	@Test
	@DisplayName("Cadastrar um Usuário")
	public void deveCriarUmUsuario() {

		HttpEntity<Usuario> corpoRequisicao = new HttpEntity<Usuario>(new Usuario(0L, "Paulo Antunes",
				"paulo_antunes@email.com,br", "13465278",
				"https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/apple/325/black-heart_1f5a4.png"));

		HttpEntity<Usuario> corpoResposta = testRestTemplate.exchange("/usuarios/cadastrar", HttpMethod.POST,
				corpoRequisicao, Usuario.class);

		assertEquals(HttpStatus.CREATED, corpoResposta.getStatusCode());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
		assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getUsuario());

	}

	@Test
		@DisplayName("Não deve permitir duplicação do Usuário")
		public void naoDeveDuplicarUsuario() {
			
			usuarioService.cadastrarUsuario(new Usuario(0L,
				"Maria da Silva, "maria_silva@email.com.br", "13465278", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/white-heart_1f90d.png"));
	
					
					
	HttpEntity<Usuario> corpoRequisiscao = new HttpEntity<Usuario>(new Usuario(0L,
			"Maria da Silva, "maria_silva@email.com.br", "13465278", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/white-heart_1f90d.png"));
			
	ResponseEntity<Usuario>	corpoResposta = testRestTemplate
	.exchange("/usuarios/cadastrar", HttpMethod.POST, corpoRequisicao, Usuario.class);
		
		
		assertEquals(HttpStatus.BAD_REQUEST, corpoResposta.getStatusCode());
		
		}
	
	@Test
	@DisplayName("Atualizar um Usuário")
	public void deveAtualizarUmUsuario() {
	
	Optional<Usuario> usuarioCadastrado = usuarioService.cadastrarUsuario(new Usuario (0L, 
			"Juliana Andrews", "juliana_ramos@email.com.br", "juliana123", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/grinning-face_1f600.png"));
			
	Usuario usuarioUpdate = new Usuario(usuarioCadastrado.get().getId(),
			"Juliana Andrews Ramos", "juliana_ramos@email.com.br", "juliana123", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/grinning-face_1f600.png"));
	
	HttpEntity<Usuario> corpoResposta = new HttpEntity<Usuario>(usuarioUpdate);
	
	ResponseEntity<Usuario> corpoResposta = testRestTemplate
			.withBasicAuth("root@root.com", "rootroot")
			.exchange("/usuarios/atualizar", HttpMethod.PUT, corpoResposta.getBody().getNome());
	
	assertEquals(HttpStatus.OK, corpoResposta.getStatusCode());
	assertEquals(corpoRequisicao.getBody().getNome(), corpoResposta.getBody().getNome());
	assertEquals(corpoRequisicao.getBody().getUsuario(), corpoResposta.getBody().getUsuario());
	
	@Test
	@DisplayName("Listar todos os Usuário")
	public void deveMostrarTodosUsuario() {
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
		"Sabrina Sanches", "sabrina_sanches@amail.com.br", "sabrina123", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/grinning-squinting-face_1f606.png"));
		
		usuarioService.cadastrarUsuario(new Usuario(0L,
		"Ricardo Marques", "ricardo_marques@email.com.br", "ricardo123", "https://emojipedia-us.s3.dualstack.us-west-1.amazonaws.com/thumbs/120/google/313/face-with-tears-of-joy_1f602.png" ));
		
		ResponseEntity<String> resposta = testRestTemplate
				.withBasicAuth("root@root.com", "rootroot")
				.exchange("/usuarios/all", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
			
	}
	
	
}
