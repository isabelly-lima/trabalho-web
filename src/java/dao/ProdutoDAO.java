package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO extends Executa {
	public ProdutoDAO(Connection connection) {
		super(connection);
	}
	public void cadastrarProduto(Produto produto) {
		PreparedStatement stmt = null;
		String sql = "insert into produto (idProduto, quantidade, nome) values(?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setInt(1, produto.getIdProduto());
		stmt.setInt(2, produto.getQuantidade());
		stmt.setString(3, produto.getNomeProduto());
		stmt.execute();
	}
	public boolean editarProduto(Produto produto) {
		String sql = "update produto set quantidade=?, nome=? where idProduto=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, produto.getQuantidade());
			stmt.setString(2, produto.getNomeProduto());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
