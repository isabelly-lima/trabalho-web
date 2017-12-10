package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Fornecedor_Pedido;

public class FornecedorDAO extends Executa{
	public FornecedorDAO(Connection connection) {
		super(connection);
	}
	
	public void cadastrarFornecedor(Fornecedor_Pedido fornecedor) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "insert into fornecedor (idForn, nomeForn, emailForn, senhaForn, endereco, telefone, cnpj, dataCad)"+
		"values(?,?,?,?,?,?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		fornecedor.setDataCad(LocalDate.now());
		stmt.setInt(1, fornecedor.getIdForn());
		stmt.setString(2, fornecedor.getNomeForn());
		stmt.setString(3, fornecedor.getEmailForn());
		stmt.setString(4, fornecedor.getSenhaForn());
		stmt.setString(5, fornecedor.getEndereco());
		stmt.setString(6, fornecedor.getTelefone());
		stmt.setString(7, fornecedor.getCnpj());
		stmt.setDate(8, Date.valueOf(fornecedor.getDataCad()));
		stmt.execute();
	}
	public boolean editarFornecedor(Fornecedor_Pedido fornecedor) {
		String sql = "update fornecedor set nomeForn=?, emailForn=?, senhaForn=?, endereco=?, telefone=?, cnpj=?, dataCad=? where idForn=?";
		PreparedStatement stmt;
		try {
			stmt = getConexao().prepareStatement(sql);
			stmt.setString(1, fornecedor.getNomeForn());
			stmt.setString(2, fornecedor.getEmailForn());
			stmt.setString(3, fornecedor.getSenhaForn());
			stmt.setString(4, fornecedor.getEndereco());
			stmt.setString(5, fornecedor.getTelefone());
			stmt.setString(6, fornecedor.getCnpj());
			stmt.setDate(7, Date.valueOf(fornecedor.getDataCad()));
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
	
	public void excluirFornecedor(Fornecedor_Pedido fornecedor) {
		String sql = "delete from fornecedor where idForn=?";
		PreparedStatement stmt = getConexao().prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}
	
	public ArrayList<Fornecedor_Pedido> listarFornecedores(){
		ArrayList<Fornecedor_Pedido> fornecedores = new ArrayList<Fornecedor_Pedido>();
		String sql = "select * from fornecedor";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String nome = rs.getString(2);
				String email = rs.getString(3);
				String senha = rs.getString(4);
				String endereco = rs.getString(5);
				string telefone = rs.getString(6);
				String cnpj = rs.getString(7);
				LocalDate dataCad = rs.getDate(8).toLocalDate();
				
				fornecedores.add(new Fornecedor_Pedido(id, nome, email, senha, endereco, telefone, cnpj, dataCad));
			}
			stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
		return fornecedores;
	}
	
	public Fornecedor_Pedido getFornecedor(int idForn) {
		String sql = "select nomeForn, emailForn, endereco, telefone, cnpj, dataCad from Fornecedor where idForn=?";
		try {
			PreparedStatement stmt = getConexao().prepareStatement(sql);
			stmt.setInt(1, idForn);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String nome = rs.getString("nomeForn");
				String email = rs.getString("emailForn");
				String senha = rs.getString(4);
				String endereco = rs.getString(5);
				string telefone = rs.getString(6);
				String cnpj = rs.getString(7);
				LocalDate dataCad = rs.getDate(8).toLocalDate();
			}
			return new Fornecedor_Pedido(idForn, nome, email, senha, endereco, telefone, cnpj, dataCad);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
