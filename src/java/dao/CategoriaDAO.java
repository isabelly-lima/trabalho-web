package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public boolean editarCategoria(Categoria categoria) {
		String sql = "update categoria set nomeCategoria=?, produtos=? where idCategoria=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, categoria.getNomeCategoria());
			stmt.setArray(2, (Array) categoria.getProdutos());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirCategoria(Categoria categoria) {
		String sql = "delete from categoria where idCategoria=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Categoria> listarCategorias(){
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		String sql = "Select * from categoria";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nomeCategoria = rs.getString(2);
				ArrayList<Produto> produtos = (Array) rs.getArray(3);
				
				categorias.add(new Categoria(id, nomeCategoria, produtos));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return categorias;
	}
	
	public Categoria getCategoria(int idCategoria) {
		String sql = "select nomeCategoria, produto from Categoria where idCategoria=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, idCategoria);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String nomeCat = rs.getString("nomeCategoria");
				ArrayList<Produto> produtos = (Array) rs.getArray("produtos");
				categoria = new CategoriaDAO(getConexao().getCategoria(rs.getInt("idCategoria")));
			}
			return new Categoria(idCategoria, nomeCat, produtos);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
