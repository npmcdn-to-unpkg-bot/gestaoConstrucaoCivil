package br.com.system.gestaoConstrucaoCivil.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.system.gestaoConstrucaoCivil.entity.EstoqueEmpreendimento;

public interface EstoqueEmpreendimentoRepository extends JpaRepository<EstoqueEmpreendimento,Long>{

	
	
	 @Query("SELECT e FROM EstoqueEmpreendimento e JOIN e.produto p  WHERE e.empreendimento.id  = ?1 AND p.id = ?2")
	 EstoqueEmpreendimento estoque(Long id_empreendimento,Long id);
	    
	 @Query("SELECT CASE WHEN COUNT(e.id) > 0 THEN true ELSE false END FROM EstoqueEmpreendimento e JOIN e.produto p  WHERE p.id = :id")
	 boolean existeProduto(@Param("id") Long id);

}
