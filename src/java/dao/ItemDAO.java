package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Itens_Pedido;

public class ItemDAO extends Executa{
	public ItemDAO(Connection connection) {
		super(connection);
	}
	public void cadastrarItem(Itens_Pedido item) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "insert into itens_pedido (categoria, quantidade) values(?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setInt(1, item.getCategoria().getIdCategoria());
		stmt.setInt(2, item.getQuantidade());
		stmt.execute();
	}
	public boolean editarItem(Itens_Pedido item) {
		String sql = "update itens_pedido set categoria=?, quantidade=? where categoria.idCategoria=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setArray(1, (Array) item.getProdutos());
			stmt.setInt(2, item.getQuantidade());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void excluirItem(Itens_Pedido item) {
		String sql = "delete from itens_pedido where quantidade=0";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Itens_Pedido> listarItens(){
		ArrayList<Itens_Pedido> itens = new ArrayList<Itens_Pedido>();
		String sql = "Select * from itens_pedido";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int quantidade = rs.getInt(1);
				Categoria categoria;
				categoria = new CategoriaDAO(new ConnectionFactory().getConnection()).getCategoria(categoria.getIdCategoria());
				itens.add(new Itens_Pedido(quantidade, categoria));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return itens;
	}
}
