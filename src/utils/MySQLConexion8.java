package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion8 {

	@SuppressWarnings("deprecation")
	public static Connection getConexion() {
		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/ciberfarmaweb?useSSL=false&useTimezone=true&serverTimezone=UTC";
			String user = "root";
			String password = "mysql";

			connection = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado CNFE : " + ex);
		} catch (SQLException ex) {
			System.out.println("Error >> Driver no Instalado SQLE : " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Error >> general : " + ex.getMessage());
		}

		return connection;

	}
	
	public static void closeConexion(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("Problemas al cerrar la conexion"); 
		}
	}
	
}
