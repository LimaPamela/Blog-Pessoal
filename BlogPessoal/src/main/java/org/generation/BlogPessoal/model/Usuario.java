package org.generation.BlogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "tb_usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "O atributo Nome é Obrigatório")
	private String nome;
	
	@NotNull
	@Email(message= "O Atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotBlank(message = "O atributo Senha é obrigatório")
	@Size(min = 8, message = "A Senha deve ter no mínimo 8 caracteres")
	private String senha;
	
	@Size(max = 5000, message = "O link da foto não pode ser maior do que 5000 caracteres")
	private String foto;

	@OneToMany(mappedBy = "usuario",cascade = CascadeType.ALL)
	@JsonIgnoreProperties("usuario")
	private List<Postagem> postagem;
	
}
