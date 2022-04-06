package com.lins;


public class ItemPedido {
	public String descricao;
	public double valUnitario;
	public int qtd;

	public ItemPedido(String descricao, double valUnitario, int qtd) {
		this.descricao = descricao;
		this.valUnitario = valUnitario;
		this.qtd = qtd;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValUnitario() {
		return valUnitario;
	}

	public void setValUnitario(double valUnitario) {
		this.valUnitario = valUnitario;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	
}