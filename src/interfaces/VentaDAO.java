package interfaces;

import java.util.ArrayList;

import beans.CabeceraBoletaDTO;
import beans.DetalleBoletaDTO;

public interface VentaDAO {

    public String generaNumBoleta();

    public int realizarVenta(CabeceraBoletaDTO cab, ArrayList<DetalleBoletaDTO> det);

}
