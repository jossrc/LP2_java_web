package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion8;

public class GestionProducto implements ProductoInterface {

    @Override
    public int registrar(Producto producto) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "insert into tb_productos values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getId());
            preparedStatement.setString(2, producto.getDescripcion());
            preparedStatement.setInt(3, producto.getStock());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getIdCategoria());
            preparedStatement.setInt(5, producto.getEstado());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al registrar " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return rs;
    }

    @Override
    public int actualizar(Producto producto) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getId());
            preparedStatement.setString(2, producto.getDescripcion());
            preparedStatement.setInt(3, producto.getStock());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setInt(5, producto.getIdCategoria());
            preparedStatement.setInt(5, producto.getEstado());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al actualizar " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return rs;
    }

    @Override
    public int eliminar(Producto producto) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, producto.getId());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return rs;
    }

    @Override
    public ArrayList<Producto> listado() {
        ArrayList<Producto> lista = null;
        
        return lista;
    }

    @Override
    public ArrayList<Producto> listadoPorCategoria(int categoria) {
        
        ArrayList<Producto> lista = null;
        
        
        return lista;
    }

}
