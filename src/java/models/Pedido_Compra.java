package models;

import java.time.LocalDate;
import java.util.ArrayList;

public final class Pedido_Compra {
	private int idPedido;
	private LocalDate dataAbertura;
	private LocalDate dataFechamento;
	private ArrayList<Produto> Produtos;
	private Pessoa autor;
	private String descricao;
	private int tipo;
	
	public Pedido_Compra() {
		
	}
	public Pedido_Compra(int id, LocalDate dataAbertura, LocalDate dataFechamento, 
			Pessoa autor, String descricao, int tipo) {
		setIdPedido(id);
		setDataAbertura(dataAbertura);
		setDataFechamento(dataFechamento);
		setAutor(autor);
		setDescricao(descricao);
		setTipo(tipo);
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public ArrayList<Produto> getProdutos() {
		return Produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		Produtos = produtos;
	}
	public Pessoa getAutor() {
		return autor;
	}
	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
}
