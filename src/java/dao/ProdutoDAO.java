package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Produto;

public class ProdutoDAO extends Executa {
	public ProdutoDAO(Connection connection) {
		super(connection);
	}
	public void cadastrarProduto(Produto produto) {
		PreparedStatement stmt = null;
		String sql = "insert into produto (idProduto, itens, nome) values(?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setInt(1, produto.getIdProduto());
		stmt.setArray(2, (Array) produto.getItens());
		stmt.setString(3, produto.getNomeProduto());
		stmt.execute();
	}
	public boolean editarProduto(Produto produto) {
		String sql = "update produto set itens=?, nome=? where idProduto=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setArray(1, (Array) produto.getItens());
			stmt.setString(2, produto.getNomeProduto());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirProduto(Produto produto) {
		String sql = "delete from produto where idProduto=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Produto> listarProdutos(){
		ArrayList<Produto> produtos = new ArrayList<Produto>();
		String sql = "Select * from produto";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				ArrayList<Itens_Pedido> itens = (Array) rs.getArray(2);
				String nomeProduto = rs.getString(3);
				produtos.add(new Produto(id, itens, nomeProduto));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return produtos;
	}
	
	public Produto getProduto(int idProduto) {
		String sql = "Select itens, nomeProduto from produto where idProduto=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, idProduto);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				ArrayList<Itens_Pedido> itens = rs.getArray("itens");
				String nomeProduto = rs.getString("nomeProduto");
				return new Produto(idProduto, itens, nomeProduto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
