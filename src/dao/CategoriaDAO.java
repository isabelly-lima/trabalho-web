package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Categoria;

public class CategoriaDAO extends Executa {
	public CategoriaDAO(Connection connection) {
		super(connection);
	}
	
	public void inserirCategoria(Categoria categoria) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "insert into categoria (idCategoria, nomeCategoria, produtos) values (?, ?, ?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setInt(1, categoria.getIdCategoria());
		stmt.setString(2, categoria.getNomeCategoria());
		stmt.setArray(3, (Array) categoria.getProdutos());
		stmt.execute();
	}
}
