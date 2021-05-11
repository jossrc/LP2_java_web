package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySQLConexion8;

public class MySQLUsuarioDAO implements UsuarioDAO {

    @Override
    public int registrar(UsuarioDTO usuario) {
        int rs = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "insert into tb_usuarios values (null, ?,?,?,?,?, default, default)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNombre());
            preparedStatement.setString(2, usuario.getApellido());
            preparedStatement.setString(3, usuario.getUsuario());
            preparedStatement.setString(4, usuario.getPassword());
            preparedStatement.setString(5, usuario.getFechNac());

            rs = preparedStatement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al registrar " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return rs;
    }

    @Override
    public UsuarioDTO validar(String usuario, String password) {
        UsuarioDTO usuarioDTO = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = MySQLConexion8.getConexion();
            String sql = "{call usp_validaAcceso(?,?)}";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                
                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String user = resultSet.getString(4);
                String pass = resultSet.getString(5);
                String fechNac = resultSet.getString(6);
                int tipo = resultSet.getInt(7);
                int estado = resultSet.getInt(8);

                usuarioDTO = new UsuarioDTO(id, nombre, apellido, user, pass, fechNac, tipo, estado);

            }

        } catch (Exception e) {
            System.out.println("Error al buscar producto " + e.getMessage());
        } finally {
            MySQLConexion8.closeConexion(connection);
        }

        return usuarioDTO;
    }

}
