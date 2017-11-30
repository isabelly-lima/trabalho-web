/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conection;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;


/**
 *
 * @author Deus Grego
 */
public class conectionFactory {
    private final String driver = "com.mysql.jdbc.Driver";
    private final String host = "localhost:3306";
    private final String database = "manipula_dados";
    private final String usuario = "root";
    private final String senha = "";
    
    public Connection getConnection() throws SQLException{
        try{
            Class.forName(driver);
            Connection conexao = DriverManager.getConnection( "jdbc:mysql://" + host +"/"+database, usuario, senha);
            return conexao;
        } catch(SQLException e){
            throw new SQLException("Descrição do erro: " + e.getMessage());
        } catch (ClassNotFoundException cnf){
            throw new SQLException("Driver não encontrado ("+ cnf.getMessage()+ ")");
            
        } 
    }
}
