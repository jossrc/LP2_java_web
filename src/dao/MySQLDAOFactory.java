package dao;

import interfaces.ProductoDAO;
import interfaces.UsuarioDAO;
import mantenimientos.MySQLProductoDAO;
import mantenimientos.MySQLUsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {

    @Override
    public ProductoDAO getProductoDAO() {
        return new MySQLProductoDAO();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new MySQLUsuarioDAO();
    }

}
