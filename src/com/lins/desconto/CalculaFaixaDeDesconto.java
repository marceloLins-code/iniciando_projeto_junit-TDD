package com.lins.desconto;

public abstract class CalculaFaixaDeDesconto {
	
	private CalculaFaixaDeDesconto proximo;

	public CalculaFaixaDeDesconto(CalculaFaixaDeDesconto proximo) {
		this.proximo = proximo;
	}
	
	public double desconto(double valorTotal) {
		double desconto = calcular(valorTotal);		
		if (desconto == -1) {
			return proximo.desconto(valorTotal);
		}
		return desconto;
	}

	protected abstract double calcular(double valorTotal);
	

}
