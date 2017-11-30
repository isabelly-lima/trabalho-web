package model;

import java.time.LocalDate;

public class Fornecedor_Pedido {
	private int idForn;
	private String nomeForn;
	private String emailForn;
	private String senhaForn;
	private String endereco;
	private String telefone;
	private String cnpj;
	private LocalDate dataCad;
	
	public Fornecedor_Pedido() {
		
	}
	public Fornecedor_Pedido(String nomeForn, String emailForn, String senhaForn, 
			String endereco, String telefone, String cnpj, LocalDate data) {
		setNomeForn(nomeForn);
		setEmailForn(emailForn);
		setSenhaForn(senhaForn);
		setEndereco(endereco);
		setTelefone(telefone);
		setCnpj(cnpj);
		setDataCad(data);
	}
	
	public String getNomeForn() {
		return nomeForn;
	}
	public void setNomeForn(String nomeForn) {
		this.nomeForn = nomeForn;
	}
	public String getEmailForn() {
		return emailForn;
	}
	public void setEmailForn(String emailForn) {
		this.emailForn = emailForn;
	}
	public String getSenhaForn() {
		return senhaForn;
	}
	public void setSenhaForn(String senhaForn) {
		this.senhaForn = senhaForn;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public LocalDate getDataCad() {
		return dataCad;
	}
	public void setDataCad(LocalDate dataCad) {
		this.dataCad = dataCad;
	}
	public int getIdForn() {
		return idForn;
	}
	public void setIdForn(int id) {
		this.idForn = id;
	}
}
