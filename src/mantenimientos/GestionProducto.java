package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "select * from tb_productos";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            lista = new ArrayList<Producto>();

            while (resultSet.next()) {
                String codigo = resultSet.getString(1);
                String descripcion = resultSet.getString(2);
                int stock = resultSet.getInt(3);
                double precio = resultSet.getDouble(4);
                int categoria = resultSet.getInt(5);
                int estado = resultSet.getInt(6);

                Producto prod = new Producto(codigo, descripcion, stock, precio, categoria, estado);
                lista.add(prod);
            }

        } catch (Exception e) {
            System.out.println("Error al Listado " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return lista;
    }

    @Override
    public ArrayList<Producto> listadoPorCategoria(int categoria) {

        ArrayList<Producto> lista = null;

        return lista;
    }

    @Override
    public Producto buscar(String codigo) {
        Producto producto = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "select * from tb_productos where idprod = ?";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, codigo);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String codProd = resultSet.getString(1);
                String descripcion = resultSet.getString(2);
                int stock = resultSet.getInt(3);
                double precio = resultSet.getDouble(4);
                int categoria = resultSet.getInt(5);
                int estado = resultSet.getInt(6);

                producto = new Producto(codProd, descripcion, stock, precio, categoria, estado);

            }

        } catch (Exception e) {
            System.out.println("Error al buscar producto " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return producto;
    }

}
