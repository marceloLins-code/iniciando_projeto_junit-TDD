package com.lins;

public class Pedido {
	
	private double valorTotal;
	private double desconto;
	
	public void adicionaritem(String descricao, double valUnitario, int qtd) {
	valorTotal = valUnitario*qtd;	
	}

	public double valorTotal() {		
		return valorTotal;
	}

	public double valorDesconto() {
		return desconto;
	}

	

}
