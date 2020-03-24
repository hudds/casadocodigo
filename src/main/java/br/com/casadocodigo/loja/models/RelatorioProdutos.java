package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

public class RelatorioProdutos {
	
	private Calendar dataGeracao;
	private List<Produto> produtos;
	
	public RelatorioProdutos(List<Produto> produtos) {
		this.produtos=produtos;
		this.dataGeracao = Calendar.getInstance();
	}
	
	public Calendar getDataGeracao() {
		return this.dataGeracao;
	}
	
	public Integer getQuantidade() {
		return this.produtos.size();
	}
	
	public List<Produto> getProdutos() {
		return this.produtos;
	}
	

}
