package model;

import java.time.LocalDate;

public class Lance {
	private double valor;
	private LocalDate dataLance;
	private Fornecedor_Pedido autor;
	
	public Lance() {
		
	}
	public Lance(double valor, LocalDate data, Fornecedor_Pedido autor) {
		setValor(valor);
		setDataLance(data);
		setAutor(autor);
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDate getDataLance() {
		return dataLance;
	}
	public void setDataLance(LocalDate dataLance) {
		this.dataLance = dataLance;
	}
	public Fornecedor_Pedido getAutor() {
		return autor;
	}
	public void setAutor(Fornecedor_Pedido autor) {
		this.autor = autor;
	}
}
