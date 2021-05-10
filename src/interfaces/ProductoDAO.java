package interfaces;

import java.util.ArrayList;

import beans.CategoriaDTO;
import beans.ProductoDTO;

public interface ProductoDAO {

    public int registrar(ProductoDTO producto);

    public int actualizar(ProductoDTO producto);

    public int eliminar(ProductoDTO producto);
    
    public ArrayList<ProductoDTO> listado();
    
    public ArrayList<CategoriaDTO> listadoCategoria();
    
    public ArrayList<ProductoDTO> listadoPorCategoria(int categoria);
    
    public ProductoDTO buscar(String codigo);
}
