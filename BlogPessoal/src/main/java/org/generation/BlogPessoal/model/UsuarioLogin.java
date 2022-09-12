package org.generation.BlogPessoal.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UsuarioLogin {
	
		private Long id;
		private String nome;
		private String usuario;
		private String senha;
		private String foto;
		private String token;


}
