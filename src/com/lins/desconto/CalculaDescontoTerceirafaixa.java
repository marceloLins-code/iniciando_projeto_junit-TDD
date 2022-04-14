package com.lins.desconto;

public class CalculaDescontoTerceirafaixa extends CalculaFaixaDeDesconto {

	public CalculaDescontoTerceirafaixa(CalculaFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		
	 if (valorTotal > 1000.0) {
			return valorTotal * 0.08;
		}
		return -1;
	}

}
