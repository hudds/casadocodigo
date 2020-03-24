package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

public class Pedido {


	private Integer id;
	private BigDecimal valor;
	private Calendar data;
	private List<Produto> produtos;
	
	public Pedido() {
		
	}

	public Pedido(Integer id, BigDecimal valor, Calendar data, List<Produto> produtos) {
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.produtos = produtos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public String getStringTitulos(){
		StringBuilder builder =  new StringBuilder();
		for (int i = 0; i < this.produtos.size(); i++) {
			builder.append(produtos.get(i).getTitulo());
			if(i < this.produtos.size()-1) {
				builder.append(", ");
			}
		}
		
		return builder.toString();
	}

}
