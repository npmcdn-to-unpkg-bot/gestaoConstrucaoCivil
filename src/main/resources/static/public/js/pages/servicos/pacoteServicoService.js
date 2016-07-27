app.factory('pacoteServicoService', function($rootScope, toastr, $http,$q){
	
	
	return{
		pacoteServicoCreate: function(pacoteServico){
			return $http.post('/rest/pacoteServico/cadastrarPacoteServico', pacoteServico)
			
			.then(function(response){
			
				toastr.info('pacotes de serviço cadastrado');
				
				return response.data;
			
			},function(errResponse){
				console.error('Erro ao tentar gravar o pacote de servico');
				toastr.error('pacotes de serviço não cadastrado');
				return $q.reject(errResponse);
				
			});
		},
		pacoteServicoFindAll: function(){
			return $http.get('rest/pacoteServico/pacoteServico/listarPacoteServico')
			.then(function(response){
				return response.data;
			},function(errResponse){
				toastr.error('erro ao buscar pacotes de serviços');
				console.error('Erro ao tentar buscar os pacotes de servico');
				return $q.reject(errResponse);
			});
		},
		
	}
});