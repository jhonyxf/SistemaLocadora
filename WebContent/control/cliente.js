// JavaScript Document
var clienteModule = angular.module('clienteModule',[]);

 clienteModule.controller("clienteControl",function($scope,$http){
	
	urlCliente = 'http://localhost:8080/SistemaLocadora/rs/cliente';

	
	urlVeiculo = 'http://localhost:8080/SistemaLocadora/rs/veiculo';
	
	$scope.pesquisarVeiculo = function(){
		$http.get(urlVeiculo).success(function(veiculos){
			$scope.veiculos = veiculos;
		}).error(function (erro){
		alert(erro);
		});
	}
	
	$scope.pesquisar = function(){
		$http.get(urlCliente).success(function (clientesRetorno) {
			$scope.clientes = clientesRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar clientes '+mensagemErro);
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
		if($scope.cliente.codigo == ''){
				$http.post(urlCliente,$scope.cliente).success(function(cliente){
					$scope.clientes.push($scope.cliente);
					$scope.novo();
				}).error(function (erro){
						alert(erro);
				});
		}else{
			
				$http.put(urlCliente,$scope.cliente).success(function(cliente){
					$scope.pesquisarCliente();
					$scope.novo();
				}).error(function (erro){
						alert(erro);
				});
		}
		
		
	}
	*/
	$scope.novo = function(){
		$scope.cliente = {};
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
    	if ($scope.cliente.codigo == undefined || $scope.cliente.codigo == '') {
			$http.post(urlCliente,$scope.cliente).success(function(cliente) {
				$scope.clientes.push($scope.cliente);
				$scope.novo();
				$scope.mensagens.push('Cliente salvo com sucesso');
				$scope.form.$setPristine();
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar cliente: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(urlCliente,$scope.cliente).success(function(cliente) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente atualizado com sucesso');
				$scope.form.$setPristine();
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
    $scope.excluir = function() {
		if ($scope.cliente.codigo == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = urlCliente+'/'+$scope.cliente.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Cliente excluído com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir cliente: '+erro);
			});
		}
	}
    /*
	$scope.excluir = function(){
		if($scope.cliente.codigo == ''){
			alert('Selecione um cliente');
		}else{
			urlExcluir = urlCliente+'/'+$scope.cliente.codigo;
			alert(urlExcluir);
			$http.delete(urlExcluir).success(function(){
				$scope.pesquisarCliente();
				$scope.novo();
				
			}).error(function (erro){
				alert(erro);
			});

		}
	}
	*/
	
	
	$scope.selecionaCliente = function(cliente){
		$scope.cliente = cliente;
	}
	
	$scope.pesquisarVeiculo();
	//$scope.pesquisarCliente();
	
	$scope.pesquisar();
	$scope.novo();
	
});