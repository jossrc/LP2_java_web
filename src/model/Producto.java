package model;

public class Producto {

    private String id;
    private String descripcion;
    private int stock;
    private double precio;
    private int idCategoria;
    private int estado;

    public Producto(String id, String descripcion, int stock, double precio, int idCategoria, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.stock = stock;
        this.precio = precio;
        this.idCategoria = idCategoria;
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto [id=" + id + ", descripcion=" + descripcion + ", stock=" + stock + ", precio=" + precio
                + ", idCategoria=" + idCategoria + ", estado=" + estado + "]";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
