package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {

    public int registrar(Producto producto);

    public int actualizar(Producto producto);

    public int eliminar(Producto producto);
    
    public ArrayList<Producto> listado();
    
    public ArrayList<Producto> listadoPorCategoria(int categoria);
}
