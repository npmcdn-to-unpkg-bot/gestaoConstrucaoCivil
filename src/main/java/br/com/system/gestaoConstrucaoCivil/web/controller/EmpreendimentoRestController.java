package br.com.system.gestaoConstrucaoCivil.web.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.system.gestaoConstrucaoCivil.entity.Empreendimento;
import br.com.system.gestaoConstrucaoCivil.enuns.TipoEmpreendimentoEnum;
import br.com.system.gestaoConstrucaoCivil.service.EmpreendimentoService;
import br.com.system.gestaoConstrucaoCivil.service.EnderecoService;

@RestController
@RequestMapping("rest/empreendimento/empreendimento")
public class EmpreendimentoRestController {

	@Autowired
	private EmpreendimentoService empreendimentoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ResponseEntity<Iterable<Empreendimento>> empreendimentos() {
		Iterable<Empreendimento> empreendimento = empreendimentoService.buscarTodos();
		return new ResponseEntity<Iterable<Empreendimento>>(empreendimento, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/empreendimentoSemConfiguracaoLista")
	public ResponseEntity<Iterable<Empreendimento>> buscaEmpreendimentoSemConfiguracao() {
		Iterable<Empreendimento> empreendimento = empreendimentoService.buscaEmpreendimentoSemConfiguracao();
		return new ResponseEntity<Iterable<Empreendimento>>(empreendimento, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/tiposEmpreendimentos")
	public ResponseEntity<Iterable<TipoEmpreendimentoEnum>> tiposEmpreendimentos() {

		Iterable<TipoEmpreendimentoEnum> tiposEmpreendimentos = Arrays.asList(TipoEmpreendimentoEnum.values());
		return new ResponseEntity<Iterable<TipoEmpreendimentoEnum>>(tiposEmpreendimentos, HttpStatus.OK);

	}

	@RequestMapping(value = "/buscaPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Empreendimento> buscarEmpreendimentoPorId(@PathVariable Long id) {
		return new ResponseEntity<Empreendimento>(empreendimentoService.buscarPorId(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ResponseEntity salvarEmpreendimento(@RequestBody Empreendimento empreendimento,
			UriComponentsBuilder ucBuilder) {
		empreendimentoService.salvarOuEditar(empreendimento);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("rest/empreendimento/empreendimento/salva/{empreendimento}")
				.buildAndExpand(empreendimento.getId()).toUri());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/altera", method = RequestMethod.PUT)
	public ResponseEntity alterarEmpreendimento(@RequestBody Empreendimento empreendimento,
			UriComponentsBuilder ucBuilder) {
		empreendimentoService.salvarOuEditar(empreendimento);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("rest/empreendimento/empreendimento/altera/{empreendimento}")
				.buildAndExpand(empreendimento.getId()).toUri());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}
}
