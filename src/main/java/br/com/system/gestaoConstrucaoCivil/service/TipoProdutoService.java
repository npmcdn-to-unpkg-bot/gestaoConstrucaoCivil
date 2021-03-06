package br.com.system.gestaoConstrucaoCivil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.system.gestaoConstrucaoCivil.entity.TipoProduto;
import br.com.system.gestaoConstrucaoCivil.repository.TipoProdutoRepository;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class TipoProdutoService {

	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@Transactional(readOnly = false)
	public void salvaAltera(TipoProduto tipoProduto){
		
		tipoProdutoRepository.save(tipoProduto);
	}
	
	public List<TipoProduto> buscarTodos(){
		
		return tipoProdutoRepository.findAll();
	}
	
	public TipoProduto buscaPorId(Long id){
		
		return tipoProdutoRepository.findOne(id);
	}
	
}
