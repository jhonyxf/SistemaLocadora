var veiculoModule = angular.module('veiculoModule',[]);

	veiculoModule.controller("veiculoControl",function($scope,$http){
	
	urlCliente = 'http://localhost:8080/SistemaLocadora/rs/cliente';

	
	urlVeiculo = 'http://localhost:8080/SistemaLocadora/rs/veiculo';
	
	$scope.pesquisarCliente = function(){
		$http.get(urlCliente).success(function(clientes){
			$scope.clientes = clientes;
		}).error(function (erro){
		alert(erro);
		});
	}
	
	$scope.pesquisar = function(){
		$http.get(urlVeiculo).success(function (veiculosRetorno) {
			$scope.veiculos = veiculosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar veiculos '+mensagemErro);
		});   
	}
	

	
	/* $scope.clientes = [
		{codigo: 1, nome: 'Jhony',veiculo:{codigo: 1, placa: 'a'}},
		{codigo: 2, nome: 'Luzia',veiculo:{codigo: 2, placa: 'b'}},
		{codigo: 3, nome: 'Iramar',veiculo:{codigo: 3, placa: 'c'}}
	];
	
	$scope.veiculos = [
		{codigo: 1, placa: 'a'},
		{codigo: 2, placa: 'b'},
		{codigo: 3, placa: 'c'}
	];
	*/
	
	
	/*
	$scope.salvar = function(){
		if($scope.veiculo.codigo == ''){
				$http.post(urlVeiculo,$scope.veiculo).success(function(veiculo){
					$scope.veiculos.push($scope.veiculo);
					$scope.novo();
				}).error(function (erro){
						alert(erro);
				});
		}else{
			
				$http.put(urlVeiculo,$scope.veiculo).success(function(veiculo){
					$scope.pesquisarVeiculo();
					$scope.novo();
				}).error(function (erro){
						alert(erro);
				});
		}
		
		
	}
	*/
	
	$scope.novo = function(){
		$scope.veiculo = {};
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}
	
	$scope.salvar = function() {    	
    	if ($scope.veiculo.codigo == undefined || $scope.veiculo.codigo == '') {
			$http.post(urlVeiculo,$scope.veiculo).success(function(veiculo) {
				$scope.veiculos.push($scope.veiculo);
				$scope.novo();
				$scope.mensagens.push('Veiculo salvo com sucesso');
				$scope.form.$setPristine();
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(urlVeiculo,$scope.veiculo).success(function(veiculo) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Veiculo atualizado com sucesso');
				$scope.form.$setPristine();
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function(){
		if($scope.veiculo.codigo == ''){
			alert('Selecione um veiculo');
		}else{
			urlExcluir = urlVeiculo+'/'+$scope.veiculo.codigo;
			alert(urlExcluir);
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarVeiculo();
				$scope.novo();
				
			}).error(function (erro){
				alert(erro);
			});

		}
	}
	

	
	$scope.selecionaVeiculo = function(veiculo){
		$scope.veiculo = veiculo;
	}
	
	$scope.pesquisarCliente();
	$scope.pesquisarVeiculo();
	
	
});