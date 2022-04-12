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
	public void devePermitirAdicionarUmItemEmPedido() throws Exception {
		Pedido pedido = new Pedido();
		pedido.adicionaritem(new ItemPedido("sabonete", 3.0, 10));		
	}
			
	@Test
	public void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}
	
	
	
	@Test
	public void calcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.adicionaritem(new ItemPedido("sabonete", 3.0, 3));
		pedido.adicionaritem(new ItemPedido("Pasta Dental", 7.0, 3));
		assertResumoPedido(30.0, 0.0);
	}
	
	
	@Test
	public void deveAplicarDescontoNaPrimeiraFaixa() throws Exception {
		pedido.adicionaritem( new ItemPedido("creme", 20.0, 20));
		assertResumoPedido(400.0, 16.0);
	}
	
	
	
	
	
	

	
	

}
