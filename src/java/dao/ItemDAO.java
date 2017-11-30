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
		String sql = "insert into itens_pedido (produtos, idcategoria, quantidade) values(?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		stmt.setArray(1, (Array) item.getProdutos());
		stmt.setInt(2, item.getCategoria().getIdCategoria());
		stmt.setInt(3, item.getQuantidade());
		stmt.execute();
	}
}
