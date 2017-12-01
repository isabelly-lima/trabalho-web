package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Itens_Pedido;

public class ItemDAO extends Executa{
	public ItemDAO(Connection connection) {
		super(connection);
	}
	public void cadastrarItem(Itens_Pedido item) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "insert into itens_pedido (produtos, categoria, quantidade) values(?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setArray(1, (Array) item.getProdutos());
		stmt.setInt(2, item.getCategoria().getIdCategoria());
		stmt.setInt(3, item.getQuantidade());
		stmt.execute();
	}
	public boolean editarItem(Itens_Pedido item) {
		String sql = "update itens_pedido set produtos=?, quantidade=? where idCategoria=?";
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
}
