package br.com.system.gestaoConstrucaoCivil.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.system.gestaoConstrucaoCivil.service.ImovelService;

@RestController
@RequestMapping("/rest/imovel")
public class ImovelRestController {


	 @Autowired
	 private ImovelService imovelService;
}
