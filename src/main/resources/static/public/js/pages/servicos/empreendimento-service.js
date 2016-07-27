app.factory('empreendimentoService', function($rootScope, toastr, $http){
	
	
	return{
		
		empreendimentoFindAll: function(){
			return $http.get('rest/empreendimento/cadastrarEmpreendimento/listaEmpreendimento')
			.then(function(response){
				return response.data;
			},function(errResponse){
				toastr.error('Erro ao buscar empreendimento');
				console.error('Erro ao tentar buscar Empresa');
				return $q.reject(errResponse);
			});
		},
		empreendimentoCreate: function(empreendimento){
			console.log("passei aqui");
			return $http.post('rest/empreendimento/cadastrarEmpreendimento', empreendimento)
			
			.then(function(response){
				console.log("empreendimento gravado");
				toastr.info('Empreendimento cadastrado');
				
				return response.data;
			
			},function(errResponse){
				console.error('Erro ao tentar gravar empreendimento');
				toastr.info('Empreendimento não cadastrado');
				return $q.reject(errResponse);
				
			});
		},
		
		empreendimentoFindOne: function(id){
			return $http.get('rest/adminSistema/buscaEmpresa' +id)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar Buscar empresa');
				return $q.reject(errResponse);
			});
		},
		empreendimentoUpdate: function(item, id){
			return $http.put('/rest/adminSistema/updateEmpresa' +id, item)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar Alterar empresa');
				return $q.reject(errResponse);
			});
		},
		empreendimentoDelete: function(id){
			return $http.delete('/rest/adminSistema/deletarEmpresa' +id)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar apagar empresa');
				return $q.reject(errResponse);
			});
		}
	}
});