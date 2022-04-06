package com.lins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PedidoTeste {
	
	private Pedido pedido;
	
	@Before
	public void setup() {
		pedido = new Pedido();
		}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		assertEquals(valorTotal, pedido.valorTotal(), 0.0001);
		assertEquals(desconto, pedido.valorDesconto(), 0.0001);
	}
	
	@Test
	public void permitirItemEmPedido() throws Exception {
		Pedido pedido = new Pedido();
		pedido.adicionaritem(new ItemPedido("sabonete", 3.0, 10));		
	}
			
	@Test
	public void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}
	
	@Test
	public void calcularResumoParaItemSemDesconto() throws Exception {
		pedido.adicionaritem(new ItemPedido("sabonete", 5.0, 5));
		assertResumoPedido(25.0, 0.0);
	}

	
	

}
