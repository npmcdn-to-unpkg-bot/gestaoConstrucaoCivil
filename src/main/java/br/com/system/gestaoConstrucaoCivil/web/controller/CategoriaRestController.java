package br.com.system.gestaoConstrucaoCivil.web.controller;

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

import br.com.system.gestaoConstrucaoCivil.entity.Categoria;
import br.com.system.gestaoConstrucaoCivil.service.CategoriaService;

@RestController
@RequestMapping("/rest/almoxarifado/categoria")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;

	@RequestMapping(method = RequestMethod.GET, value = "/lista")
	public ResponseEntity<Iterable<Categoria>> buscarCategoria() {
	Iterable<Categoria> categoria = categoriaService.buscarTodos();
		return new ResponseEntity<Iterable<Categoria>>(categoria, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/buscaPorId/{id}", method = RequestMethod.GET)
	public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {

		return new ResponseEntity<Categoria>(categoriaService.buscarCategoriaPorId(id), HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/salva", method = RequestMethod.POST)
	public ResponseEntity salvarCargo(@RequestBody Categoria categoria, UriComponentsBuilder ucBuilder) {
		categoriaService.salvarOuEditar(categoria);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("rest/almoxarifado/categoria/salva/{id}").buildAndExpand(categoria.getId()).toUri());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/altera", method = RequestMethod.PUT)
	public ResponseEntity alterarCategoria(@RequestBody Categoria categoria, UriComponentsBuilder ucBuilder) {
		categoriaService.salvarOuEditar(categoria);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("rest/almoxarifado/categoria/altera/{categoria}")
				.buildAndExpand(categoria.getId()).toUri());
		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

}
