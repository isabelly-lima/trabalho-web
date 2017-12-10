package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Pessoa;

public class PessoaDAO extends Executa {
	public PessoaDAO(Connection connection) {
		super(connection);
	}
	
	public void cadastrarPessoa(Pessoa pessoa) {
		PreparedStatement stmt = null;
		String sql = "insert into pessoa (nome, email, senha, cpf, rg, idFunc, setor, acesso)"
				+ " values (?,?,?,?,?,?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setString(1, pessoa.getNome());
		stmt.setString(2, pessoa.getEmail());
		stmt.setString(3, pessoa.getSenha());
		stmt.setString(4, pessoa.getCpf());
		stmt.setString(5, pessoa.getRg());
		stmt.setInt(6, pessoa.getIdFunc());
		stmt.setString(7, pessoa.getSetor());
		stmt.setInt(8, pessoa.getAcesso());
		stmt.execute();
	}
	public boolean editarPessoa(Pessoa pessoa) {
		String sql = "uptade pessoa set nome=?, email=?, senha=?, cpf=?, rg=?, setor=?, acesso=? where idFunc=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setString(2, pessoa.getEmail());
			stmt.setString(3, pessoa.getSenha());
			stmt.setString(4, pessoa.getCpf());
			stmt.setString(5, pessoa.getRg());
			stmt.setString(6, pessoa.getSetor());
			stmt.setInt(7, pessoa.getAcesso());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirPessoa(Pessoa pessoa) {
		String sql = "delete from pessoa where idPessoa=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Pessoa> listarPessoas(){
		ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
		String sql = "select * from pessoa";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				String nome = rs.getString(1);
				String email = rs.getString(2);
				String senha = rs.getString(3);
				String cpf = rs.getString(4);
				String rg = rs.getString(5);
				int id = rs.getInt(6);
				String setor = rs.getString(7);
				int acesso = rs.getInt(8);
				pessoas.add(new Pessoa(nome, email, senha, cpf, rg, id, setor, acesso));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return pessoas;
	}
	
	public Pessoa getPessoa(int idFunc) {
		String sql = "select nome, email, senha, cpf, rg, setor, acesso from pessoa where idFunc=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, idFunc);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				String senha = rs.getString("senha");
				String cpf = rs.getString("cpf");
				String rg = rs.getString("rg");
				String setor = rs.getString("setor");
				int acesso = rs.getInt("acesso");
			}
			return new Pessoa(nome, email, senha, cpf, rg, idFunc, setor, acesso);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
