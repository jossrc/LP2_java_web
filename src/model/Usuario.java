package model;

public class Usuario {

    private int codigo;
    private String nombre;
    private String apellido;
    private String usuario;
    private String password;
    private String fechNac;
    private int tipo;
    private int estado;

    public Usuario(int codigo, String nombre, String apellido, String usuario, String password, String fechNac,
            int tipo, int estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.fechNac = fechNac;
        this.tipo = tipo;
        this.estado = estado;
    }

    public Usuario(String nombre, String apellido, String usuario, String password, String fechNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.password = password;
        this.fechNac = fechNac;
        this.tipo = 2;
        this.estado = 1;
    }

    @Override
    public String toString() {
        return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario
               + ", password=" + password + ", fechNac=" + fechNac + ", tipo=" + tipo + ", estado=" + estado + "]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechNac() {
        return fechNac;
    }

    public void setFechNac(String fechNac) {
        this.fechNac = fechNac;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
