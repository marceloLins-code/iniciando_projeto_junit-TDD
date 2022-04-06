package com.lins;

public class Pedido {
	
	private double valorTotal;
	private double desconto;
	
	public void adicionaritem(ItemPedido ItemPedido) {
	valorTotal = ItemPedido.valUnitario*ItemPedido.qtd;	
	}

	public double valorTotal() {		
		return valorTotal;
	}

	public double valorDesconto() {
		return desconto;
	}

	

}
