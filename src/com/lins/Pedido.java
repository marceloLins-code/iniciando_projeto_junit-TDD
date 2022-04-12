package com.lins;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionaritem(ItemPedido ItemPedido) {		
		itens.add(ItemPedido);		
	}

	public double valorTotal() {
	return itens.stream().mapToDouble(i -> i.getValUnitario() * i.getQtd()).sum();
	
	}

	public double valorDesconto() {
		double desconto = 0;
		double valorTotal = valorTotal();
		
		if (valorTotal > 300.0) {
			desconto = valorTotal * 0.04;
		}
		return desconto;
	}

	

}
