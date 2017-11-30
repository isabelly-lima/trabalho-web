package models;

import java.util.ArrayList;

public final class Categoria {
	private String nomeCategoria;
	private ArrayList<Produto>produtos;
	
	public Categoria() {
		
	}
	public Categoria(String nome) {
		setNomeCategoria(nome);
	}
	
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
}
