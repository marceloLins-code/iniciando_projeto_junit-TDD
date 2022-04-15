package com.lins;

import com.lins.desconto.CalculaDescontoPrimeiraFaixa;
import com.lins.desconto.CalculaDescontoSegundaFaixa;
import com.lins.desconto.CalculaDescontoTerceirafaixa;
import com.lins.desconto.CalculaFaixaDeDesconto;
import com.lins.desconto.SemDesconto;

public class PedidoBuilder {
	//**
	
	private Pedido instancia;

	public PedidoBuilder() {
		CalculaFaixaDeDesconto calculaFaixaDeDesconto =
				new CalculaDescontoTerceirafaixa(new CalculaDescontoSegundaFaixa(
						new CalculaDescontoPrimeiraFaixa(
								new SemDesconto(null))));
		instancia = new Pedido(calculaFaixaDeDesconto);
	}
	
	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionaritem(new ItemPedido("", valorUnitario, quantidade));
		return this;
		
	}
	
	public Pedido contruir() {
		return instancia;
	}
	

}
