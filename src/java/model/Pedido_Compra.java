package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.PedidoInvalidoException;

public class Pedido_Compra {
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
			String descricao, int tipo, Pessoa autor) throws PedidoInvalidoException {
		setIdPedido(id);
		setDataAbertura(dataAbertura);
		setDataFechamento(dataFechamento);
		setDescricao(descricao);
		setTipo(tipo);
		setAutor(autor);
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) throws PedidoInvalidoException {
		if(idPedido < 0) {
			throw new PedidoInvalidoException("O id informado é invalido!");
		}
		this.idPedido = idPedido;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) throws PedidoInvalidoException {
		if (dataAbertura == null || dataAbertura.isAfter(LocalDate.now())) {
			throw new PedidoInvalidoException("A data de abertura informada é inválida!");
		}
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(LocalDate dataFechamento) throws PedidoInvalidoException {
		if(dataFechamento == null || dataFechamento.isAfter(LocalDate.now())) {
			throw new PedidoInvalidoException("A data de fechamento informada é inválida!");
		}
		this.dataFechamento = dataFechamento;
	}
	public ArrayList<Produto> getProdutos() {
		return Produtos;
	}
	public void setProdutos(Produto produtos) {
			Produtos.add(produtos);
	}
	public Pessoa getAutor() {
		return autor;
	}
	public void setAutor(Pessoa autor) throws PedidoInvalidoException {
		if (autor == null) {
			throw new PedidoInvalidoException("O autor informado é inválido!");
		}
		this.autor = autor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descrição) {
		this.descricao = descrição;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) throws PedidoInvalidoException {
		if (tipo !=1 || tipo != 0) {
			throw new PedidoInvalidoException("O tipo informado é invalido");
		}
		this.tipo = tipo;
	}
	
}
