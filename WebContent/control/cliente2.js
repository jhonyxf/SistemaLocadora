// JavaScript Document
var clienteModule = angular.module('clienteModule',[]);

clienteModule.controller("clienteControl",function($scope){
	
	
	$scope.clientes = [
		{codigo: 1, nome: 'Jhony',veiculo:{codigo: 1, placa: 'a'}},
		{codigo: 2, nome: 'Luzia',veiculo:{codigo: 2, placa: 'b'}},
		{codigo: 3, nome: 'Iramar',veiculo:{codigo: 3, placa: 'c'}}
	];
	
	$scope.veiculos = [
		{codigo: 1, placa: 'a'},
		{codigo: 2, placa: 'b'},
		{codigo: 3, placa: 'c'}
	];
	
	
	$scope.selecionaCliente = function(cliente){
		$scope.cliente = cliente;
	}
	
	$scope.salvar = function(){
		$scope.clientes.push($scope.cliente);
		$scope.novo();
	}
	$scope.novo = function(){
		$scope.cliente = "";
	}
	
	$scope.excluir = function(){
		$scope.clientes.splice($scope.clientes.indexOf($scope.cliente),1);
		$scope.novo();
	}
	
});