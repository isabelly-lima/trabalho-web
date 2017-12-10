package model;

import java.util.ArrayList;

public class Itens_Pedido {
	private Categoria categoria;
	private int quantidade;
	
	public Itens_Pedido() {
		
	}
	public Itens_Pedido(int quantidade, Categoria categoria) {
		setQuantidade(quantidade);
		setCategoria(categoria);
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
