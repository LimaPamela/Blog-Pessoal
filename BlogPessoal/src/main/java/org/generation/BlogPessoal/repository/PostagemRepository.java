package org.generation.BlogPessoal.repository;

import java.util.List;

import org.generation.BlogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface PostagemRepository extends JpaRepository <Postagem, Long>    {
	
	//SELECT * FROM tb_postagens WHERE titulo LIKE "%%";
	public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo")String titulo);
	
	//SELECT * FROM tb_postagens WHERE texto LIKE "%%";
	//public List <Postagem> findAllByTextoContainingIgnoreCase(@Param("texto")String texto);

}
