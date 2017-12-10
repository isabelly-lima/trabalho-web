package model;

public class Produto {
	 private int idProduto;
	 private ArrayList<Itens_Pedido> itens;
	 private String nomeProduto;
	 
	 public Produto() {
		 
	 }
	 public Produto(int id, ArrayList<Itens_Pedido> itens, String nome) {
		 setIdProduto(id);
		 setItens(itens);
		 setNomeProduto(nome);
	 }
	 
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public ArrayList<Itens_Pedido> getItens(){
		return itens;
	}
	public void setItens(ArrayList<Itens_Pedido> itens) {
		this.itens = itens;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	 
	 
}
