package beans;

import java.time.LocalDate;

public class LanceBean {
	private double valor;
	private LocalDate dataLance;
	private Fornecedor_Pedido autor;
	
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
