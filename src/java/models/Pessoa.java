package models;

public final class Pessoa {
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String rg;
	private String idFunc;
	private String setor;
	private int acesso;
	
	
	public Pessoa() {
		
	}
	public Pessoa(String nome, String email, String senha, String cpf, String rg,
			String setor, int acesso) {
		setNome(nome);
		setEmail(email);
		setSenha(senha);
		setCpf(cpf);
		setRg(rg);
		setSetor(setor);
		setAcesso(acesso);
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getIdFunc() {
		return idFunc;
	}
	public void setIdFunc(String idFunc) {
		this.idFunc = idFunc;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public int getAcesso() {
		return acesso;
	}
	public void setAcesso(int acesso) {
		this.acesso = acesso;
	}
}
