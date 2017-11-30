package model;

public class Produto {
	 private int idProduto;
	 private int quantidade;
	 private String nomeProduto;
	 
	 public Produto() {
		 
	 }
	 public Produto(int id, int quantidade, String nome) {
		 setIdProduto(id);
		 setQuantidade(quantidade);
		 setNomeProduto(nome);
	 }
	 
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	 
	 
}
