package org.generation.BlogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import org.generation.BlogPessoal.model.Tema;

public interface TemaRepository extends JpaRepository<Tema, Long>{
	
	//SELECT * FROM tb_temass WHERE descricao LIKE "%descricao%";
	public List<Tema> findAllByDescricaoContainingIgnoreCase(@Param("descricao") String descricao);


}
