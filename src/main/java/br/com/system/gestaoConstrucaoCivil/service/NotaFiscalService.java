package br.com.system.gestaoConstrucaoCivil.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.gestaoConstrucaoCivil.repository.NotaFiscalRepository;

@Service
@Transactional
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
}