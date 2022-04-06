package com.lins;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private double desconto;
	
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionaritem(ItemPedido ItemPedido) {		
		itens.add(ItemPedido);		
	}

	public double valorTotal() {
	return itens.stream().mapToDouble(i -> i.getValUnitario() * i.getQtd()).sum();
	
	}

	public double valorDesconto() {
		return desconto;
	}

	

}
