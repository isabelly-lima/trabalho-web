package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void excluirPedido(Pedido_Compra pedido) {
		String sql = "delete from pedido where idPedido=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Pedido_Compra> listarPedidos(){
		ArrayList<Pedido_Compra> pedidos = new ArrauList<Pedido_Compra>();
		String sql = "select * from pedido";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				LocalDate dataAbertura = rs.getDate(2).toLocalDate();
				LocalDate dataFechamento = rs.getDate(3).toLocalDate();
				ArrayList<Produto> produtos = (Array) rs.getArray(4);
				String descricao = rs.getString(5);
				int tipo = rs.getInt(6);
				Pessoa autor;
				autor = new PessoaDAO(new ConnectionFactory().getConnection()).getPessoa(id);
				pedidos.add(new Pedido_Compra(id, dataAbertura, dataFechamento, produtos, descricao, tipo, autor));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return pedidos;
	}
}
