package dao;

import java.sql.Connection;

public class Executa {
	private Connection connection;
	public Executa(Connection connection) {
		setConnection(connection);
	}
	
	 public Connection getConexao(){
		 return this.connection;
	 }
	    
	 public void setConnection(Connection connection){
		 if(connection != null)
			 this.connection = connection;
	 }
}
