package br.com.system.gestaoConstrucaoCivil.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.gestaoConstrucaoCivil.entity.TipoEmpreendimento;
import br.com.system.gestaoConstrucaoCivil.repository.TipoEmpreendimentoRepository;

@Service
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class TipoEmpreendimentoService {


	@Autowired
	private TipoEmpreendimentoRepository tipoEmpreendimentoRepository;
	
     public List<TipoEmpreendimento> buscarTodos() {
		
		return tipoEmpreendimentoRepository.findAll();
	}
     @Transactional(readOnly = false)
     public void salvarOuEditar(TipoEmpreendimento tipoEmpreendimento)
     {
    	 tipoEmpreendimentoRepository.save(tipoEmpreendimento);
     }
    
}
