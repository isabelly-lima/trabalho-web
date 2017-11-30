package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Fornecedor_Pedido;

public class FornecedorDAO extends Executa{
	public FornecedorDAO(Connection connection) {
		super(connection);
	}
	
	public void cadastrarFornecedor(Fornecedor_Pedido fornecedor) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "insert into fornecedor (nomeForn, emailForn, senhaForn, endereco, telefone, cnpj, dataCad)"+
		"values(?,?,?,?,?,?,?)";
		stmt = getConexao().prepareStatement(sql);
		fornecedor.setDataCad(LocalDate.now());
		stmt.setString(1, fornecedor.getNomeForn());
		stmt.setString(2, fornecedor.getEmailForn());
		stmt.setString(3, fornecedor.getSenhaForn());
		stmt.setString(4, fornecedor.getEndereco());
		stmt.setString(5, fornecedor.getTelefone());
		stmt.setString(6, fornecedor.getCnpj());
		stmt.setDate(7, Date.valueOf(fornecedor.getDataCad()));
		stmt.execute();
	}
}
