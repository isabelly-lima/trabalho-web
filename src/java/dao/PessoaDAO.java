package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
