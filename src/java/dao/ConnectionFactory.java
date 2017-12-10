package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory { 
	public Connection getConnection() { 
		String driver = "org.postgresql.Driver";
        String user = "admin";
        String senha = "admin";
        String url = "jdbc:mysql://localhost/Database";
        Connection con = null;
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(url, user, senha);
            return con;
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        } catch (SQLException e) {
            System.err.print(e.getMessage());
        }
        return con;
		} 
	}

