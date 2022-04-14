package com.lins;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lins.desconto.CalculaDescontoPrimeiraFaixa;
import com.lins.desconto.CalculaDescontoSegundaFaixa;
import com.lins.desconto.CalculaDescontoTerceirafaixa;
import com.lins.desconto.CalculaFaixaDeDesconto;
import com.lins.desconto.SemDesconto;

public class PedidoTeste {
	
	private Pedido pedido;
	
	@Before
	public void setup() {
		CalculaFaixaDeDesconto calculaFaixaDeDesconto =
				new CalculaDescontoTerceirafaixa(new CalculaDescontoSegundaFaixa(
						new CalculaDescontoPrimeiraFaixa(
								new SemDesconto(null))));
		pedido = new Pedido(calculaFaixaDeDesconto);
		}
	
	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.resumo();
		assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
	}
	
	@Test
	public void devePermitirAdicionarUmItemEmPedido() throws Exception {
		pedido.adicionaritem(new ItemPedido("sabonete", 3.0, 10));		
	}
			
	@Test
	public void calcularValorTotalEDescontoParaPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}
	
	
	
	@Test
	public void deveCalcularResumoParaDoisItensSemDesconto() throws Exception {
		pedido.adicionaritem(new ItemPedido("sabonete", 3.0, 3));
		pedido.adicionaritem(new ItemPedido("Pasta Dental", 7.0, 3));
		assertResumoPedido(30.0, 0.0);
	}
	
	
	@Test
	public void deveAplicarDescontoNaPrimeiraFaixa() throws Exception {
		pedido.adicionaritem( new ItemPedido("creme", 20.0, 20));
		assertResumoPedido(400.0, 16.0);
	}
	
	@Test
	public void deveAplicarDescontoNaSegundaFaixa() throws Exception {
		pedido.adicionaritem( new ItemPedido("shampoo", 15.0, 30));
		pedido.adicionaritem( new ItemPedido("Oleo", 15.0, 30));

		assertResumoPedido(900.0, 54.0);
	}
	
	
	@Test
	public void deveAplicarDescontoNaTerceiraFaixa() throws Exception {
		pedido.adicionaritem( new ItemPedido("creme", 15.0, 30));
		pedido.adicionaritem( new ItemPedido("Oleo", 15.0, 30));
		pedido.adicionaritem( new ItemPedido("shampoo", 10.0, 30));


		assertResumoPedido(1200.0, 96.0);
	}

	
	

}
