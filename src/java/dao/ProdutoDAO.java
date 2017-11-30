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
}
