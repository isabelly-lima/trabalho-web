package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Pedido_Compra;

public class PedidoDAO extends Executa{
	public PedidoDAO(Connection connection) {
		super(connection);
	}
	
	public void cadastrarPedido(Pedido_Compra pedido) {
		PreparedStatement stmt = null;
		String sql = "insert into pedido (idPedido, dataAbertura, dataFechamento, produtos, autor, descricao, tipo)"
				+ "values(?,?,?,?,?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		pedido.setDataAbertura(LocalDate.now());
		pedido.setDataFechamento(LocalDate.now());
		stmt.setInt(1, pedido.getIdPedido());
		stmt.setDate(2, Date.valueOf(pedido.getDataAbertura()));
		stmt.setDate(3, Date.valueOf(pedido.getDataFechamento()));
		stmt.setArray(4, (Array) pedido.getProdutos());
		stmt.setInt(5, pedido.getAutor().getIdFunc());
		stmt.setString(6, pedido.getDescricao());
		stmt.setInt(7, pedido.getTipo());
		stmt.execute();
	}
	public boolean editarPedido(Pedido_Compra pedido) {
		String sql = "update pedido set dataAbertura=?, dataFechamento=?, produtos=?, autor=?, descricao=?, tipo=? where idPedido=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setDate(1, Date.valueOf(pedido.getDataAbertura()));
			stmt.setDate(2, Date.valueOf(pedido.getDataFechamento()));
			stmt.setArray(3, (Array) pedido.getProdutos());
			stmt.setInt(4, pedido.getAutor().getIdFunc());
			stmt.setString(5, pedido.getDescricao());
			stmt.setInt(6, pedido.getTipo());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
