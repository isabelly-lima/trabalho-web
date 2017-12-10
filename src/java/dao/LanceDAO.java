package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Lance;

public class LanceDAO extends Executa {
	public LanceDAO(Connection connection) {
		super(connection);
	}
	
	public void cadastrarLance(Lance lance) {
		PreparedStatement stmt = null;
		String sql = "insert into lance (valor, data, autor) values(?,?,?)";
		stmt = getConexão().prepareStatement(sql);
		lance.setDataLance(LocalDate.now());
		stmt.setDouble(1, lance.getValor());
		stmt.setDate(2, Date.valueOf(lance.getDataLance()));
		stmt.setInt(3, lance.getAutor().getIdForn());
		stmt.execute();
	}
	public boolean editarLance(Lance lance) {
		String sql = "update lance set valor=?, data=? where autor="+lance.getAutor().getIdForn();
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setDouble(1, lance.getValor());
			stmt.setDate(2, Date.valueOf(lance.getDataLance()));
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public void excluirLance(Lance lance) {
		String sql = "delete from Lance where valor=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Lance> listarLances(){
		ArrayList<Lance> lances = new ArrayList<Lance>();
		String sql = "select * from Lance";
		PreparedStatement stmt = null;
		try {
			stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Double valor = rs.getDouble(1);
				LocalDate data = rs.getDate(2).toLocalDate();
				Fornecedor_Pedido autor;
				autor = new FornecedorDAO(new ConnectionFactory().getConnection()).getAutor(autor.getIdForn());
				lances.add(new Lance(valor, data, autor));
			}
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return lances;
	}
}
