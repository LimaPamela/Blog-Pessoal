package org.generation.BlogPessoal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.generation.BlogPessoal.model.Postagem;


	//SELECT * FROM tb_postagens WHERE titulo LIKE "%%";
	
	//SELECT * FROM tb_postagens WHERE texto LIKE "%%";
	//public List <Postagem> findAllByTextoContainingIgnoreCase(@Param("texto")String texto);

	@Repository
	public interface PostagemRepository extends JpaRepository<Postagem, Long>{

			public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);
}
