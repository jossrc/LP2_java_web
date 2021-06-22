package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.CabeceraBoletaDTO;
import beans.DetalleBoletaDTO;
import interfaces.VentaDAO;
import utils.MySQLConexion8;

public class MySQLVentaDAO implements VentaDAO {

    @Override
    public String generaNumBoleta() {

        String codigo = "B0001";

        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {

            con = MySQLConexion8.getConexion();
            String sql = "select substr(max(num_bol),2) from tb_cab_boleta";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            if (rs.next()) {
                codigo = String.format("B%04d", rs.getInt(1) + 1);
            }

        } catch (Exception e) {
            System.out.println("Error al generar número de boleta");

        } finally {

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar");
            }
        }

        return codigo;

    }

    @Override
    public int realizarVenta(CabeceraBoletaDTO cab, ArrayList<DetalleBoletaDTO> det) {

        int rs = 0;

        Connection con = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;

        try {

            con = MySQLConexion8.getConexion();
            con.setAutoCommit(false);

            String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
            pst1 = con.prepareStatement(sql1);
            pst1.setString(1, cab.getNum_bol());
            pst1.setInt(2, cab.getCod_cliente());

            rs = pst1.executeUpdate();

            String sql2 = "insert into tb_det_boleta values (?,?,?,?)";
            String sql3 = "update tb_productos set stock = stock - ? where idprod = ?";

            for (DetalleBoletaDTO d : det) {
                pst2 = con.prepareStatement(sql2);
                pst2.setString(1, cab.getNum_bol());
                pst2.setString(2, d.getIdprod());
                pst2.setInt(3, d.getCantidad());
                pst2.setDouble(4, d.getPreciovta());
                
                rs += pst2.executeUpdate();

                pst3 = con.prepareStatement(sql3);
                pst3.setInt(1, d.getCantidad());
                pst3.setString(2, d.getIdprod());
                
                rs += pst3.executeUpdate();
            }

            con.commit();

        } catch (Exception e) {

            System.out.println("Error al realizar venta");

            rs = 0;

            try {
                con.rollback();
            } catch (SQLException e1) {
                System.out.println("Error..." + e1.getMessage());
            }

        } finally {
            MySQLConexion8.closeConexion(con);
        }

        return rs;

    }

}
