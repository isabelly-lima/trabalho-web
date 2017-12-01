package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
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
}
