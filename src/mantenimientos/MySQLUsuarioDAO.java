package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
        // TODO Auto-generated method stub
        return null;
    }

}
