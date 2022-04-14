package com.lins.desconto;

public class SemDesconto extends CalculaFaixaDeDesconto{

	public SemDesconto(CalculaFaixaDeDesconto proximo) {
		super(proximo);
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
