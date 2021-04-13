package interfaces;

import model.Producto;

public interface ProductoInterface {

    public int registrar(Producto producto);

    public int actualizar(Producto producto);

    public int eliminar(Producto producto);
}
