package org.generation.blog_pessoal.model;

import java.time.LocalDateTime;

import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Postagem {
	
	@id
	@GeratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O atributo título é Obrigatório !")
	@Size(min = 5, max = 100, message = "O atribuito título deve conter no mínimo 05 e no máxima 100 caractere")
	private String titulo;
	
	@NotBlank(message = "O atributo texto é Obrigatório !")
	@Size(min = 10, max = 100, message = "O atribuito texto deve conter no mínimo 10 e no máxima 100 caractere")
	private String texto;
	
	@UpdateTimetamp
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
}
