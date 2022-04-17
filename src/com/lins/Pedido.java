package com.lins;

import java.util.ArrayList;
import java.util.List;

import com.lins.desconto.CalculaFaixaDeDesconto;

public class Pedido {

	private List<ItemPedido> itens = new ArrayList<>();
	
	private CalculaFaixaDeDesconto calculaFaixaDeDesconto;
	
	

	public Pedido(CalculaFaixaDeDesconto calculaFaixaDeDesconto) {
		this.calculaFaixaDeDesconto = calculaFaixaDeDesconto;
	}

	public void adicionaritem(ItemPedido itemPedido) {
		validarQuantidadeItens(itemPedido);
		itens.add(itemPedido);
	}

	private void validarQuantidadeItens(ItemPedido itemPedido) {
		if (itemPedido.getQtd() < 0) {
			throw new QuantidadeDeItensInvalidaException();
		}
	}

	public ResumoPedido resumo() {
		double valorTotal = itens.stream().mapToDouble(i -> i.getValUnitario() * i.getQtd()).sum();
		double desconto = calculaFaixaDeDesconto.desconto(valorTotal);	
		
		return new ResumoPedido(valorTotal, desconto);
	}

}
