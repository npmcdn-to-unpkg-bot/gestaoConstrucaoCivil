app.controller('configEmpreendimentoController', function($scope, configEmpreendimentoService,   $routeParams){
	
	var self = this;
 
	$scope.listaOutros =[];
	
	
	self.ativarExcluirLote = function(listaOutros){
		$scope.listaOutros.filter(function(outro){
		if(outro.selecionado){
			$scope.ativadoExcluirLote = true;
		}
		});
	}
		
		self.apagarOutros = function(listaOutros){
			$scope.listaOutros = listaOutros.filter(function(outro){
			if(!outro.selecionado) return outro;
			$scope.ativadoExcluirLote = null;
		});
	}
	
	
	self.verificar = function(){
		if(self.configEmpreendimento.empreendimento.tipoEmpreendimento == "CONDOMINIO_DE_EDIFICIO_RESIDENCIAL"){
			$scope.verificaTipoCasa = false;
			$scope.verificaTipoEdificio = true;
		}else
		if(self.configEmpreendimento.empreendimento.tipoEmpreendimento == "CONDOMINIO_DE_CASA"){
			$scope.verificaTipoEdificio = false;
			$scope.verificaTipoCasa = true;
		}
	}
	
	//cria uma lista de outros
	self.adicionarOutros = function(){
		$scope.listaOutros.push({
			descricao : descricaoOutros.value
		});
					descricaoOutros.value = "";
					$scope.descricaoOutro = null;
		}
	
	

	self.salvaConfigEmpreendimento = function(configEmpreendimentoEdificio, configEmpreendimentoCasa, listaOutros){
	
		if(self.configEmpreendimentoEdificio){
			self.configEmpreendimentoEdificio.empreendimento = $scope.configCtrl.configEmpreendimento.empreendimento;
			configEmpreendimentoService.configEmpreendimentoEdificioSalva(self.configEmpreendimentoEdificio)
			. then(function(response){
				self.limpaCampos();
				sweetAlert({ timer : 3000,  type : "success", width: 200, higth: 100, padding: 20});
				 },
				function(errResponse){
					 sweetAlert({ timer : 3000,  type : "error", width: 200, higth: 100, padding: 20});
			 	});
				
				
		}else if(self.configEmpreendimentoCasa){
			self.configEmpreendimentoCasa.empreendimento = $scope.configCtrl.configEmpreendimento.empreendimento;
			configEmpreendimentoService.configEmpreendimentoCasaSalva( self.configEmpreendimentoCasa)
			. then(function(response){
				self.limpaCampos();
				sweetAlert({ timer : 3000,  type : "success", width: 200, higth: 100, padding: 20});
			 },
			function(errResponse){
				 sweetAlert({ timer : 3000,  type : "error", width: 200, higth: 100, padding: 20});
		 		 
		 	});
		}
	}
	
		
	self.empreendimentoSemConfiguracaoLista = function(){
		configEmpreendimentoService.empreendimentoSemConfiguracaoLista().
			then(function(t){
				$scope.empreendimentoSemConfiguracao = t;
				}, function(errResponse){
				
			});
		};
		
		self.limpaCampos = function(){
			self.configEmpreendimentoEdificio = null;
			self.configEmpreendimentoCasa = null;
			$scope.listaOutros = null;
			$scope.empreendimentoSemConfiguracao = null;
		}
		
});
