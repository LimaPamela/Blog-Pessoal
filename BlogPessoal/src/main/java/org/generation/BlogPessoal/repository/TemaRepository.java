package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.generation.BlogPessoal.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


	@Repository
	public interface TemaRepository extends JpaRepository <Tema, Long>    {

		public List <Tema> findAllByTituloContainingIgnoreCase(String titulo);
		public List <Tema> findAllByTextoContainingIgnoreCase(String texto);

}
