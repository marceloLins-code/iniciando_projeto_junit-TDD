package com.lins.desconto;

public class CalculaDescontoPrimeiraFaixa extends CalculaFaixaDeDesconto {
	
	

	public CalculaDescontoPrimeiraFaixa(CalculaFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		
		if (valorTotal > 300.0 && valorTotal <= 800.0) {
			return valorTotal * 0.04;
		}
		
		return -1;
	}

}
