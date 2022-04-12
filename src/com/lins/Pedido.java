package com.lins;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	
	private List<ItemPedido> itens = new ArrayList<>();
	
	public void adicionaritem(ItemPedido ItemPedido) {		
		itens.add(ItemPedido);		
	}
	
	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValUnitario() * i.getQtd()).sum();
		double desconto = 0;
		
		if (valorTotal > 300.0) {
			desconto = valorTotal * 0.04;
		}
		return new ResumoPedido(valorTotal, desconto);
		
	}


}
