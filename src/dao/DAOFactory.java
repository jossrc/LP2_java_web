package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;

public abstract class DAOFactory {

    public static final int MYSQL = 1;
    public static final int SQL = 2;
    public static final int ORACLE = 3;
    
    public abstract ProductoDAO getProductoDAO();
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract VentaDAO getVentaDAO();
    
    public static DAOFactory getDAOFactory(int qBD) {
        switch (qBD) {
        case MYSQL:
            return new MySQLDAOFactory();            
        default:
            return null;
        }
    }
    
}
