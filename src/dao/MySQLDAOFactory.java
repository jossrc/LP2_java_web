package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import interfaces.VentaDAO;
import mantenimientos.MySQLProductoDAO;
import mantenimientos.MySQLUsuarioDAO;
import mantenimientos.MySQLVentaDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public ProductoDAO getProductoDAO() {
        return new MySQLProductoDAO();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new MySQLUsuarioDAO();
    }

    @Override
    public VentaDAO getVentaDAO() {        
        return new MySQLVentaDAO(); // GestionVenta
    }

}
