package model;

import java.util.ArrayList;

public class Itens_Pedido {
	private ArrayList<Produto>produtos;
	private Categoria categoria;
	private int quantidade;
	
	public Itens_Pedido() {
		
	}
	public Itens_Pedido(Categoria categoria, int quantidade) {
		setCategoria(categoria);
		setQuantidade(quantidade);
	}
	
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
