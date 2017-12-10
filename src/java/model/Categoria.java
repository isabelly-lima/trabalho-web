package model;

import java.util.ArrayList;

public class Categoria {
	private int idCategoria;
	private String nomeCategoria;
	private ArrayList<Produto>produtos;
	
	public Categoria() {
		
	}
	public Categoria(String nome) {
		setNomeCategoria(nome);
	}
	
	public Categoria(int idCategoria, String nomeCategoria, ArrayList<Produto> produtos) {
		setIdCategoria(idCategoria);
		setNomeCategoria(nomeCategoria);
		setProdutos(produtos);
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
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	
}
