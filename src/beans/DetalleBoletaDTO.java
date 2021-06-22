package beans;

public class DetalleBoletaDTO {

    private String num_bol, idprod;
    private int cantidad;
    private double preciovta;

    private String nomprod;
    private double importe;

    public DetalleBoletaDTO() {
    }

    public String getNum_bol() {
        return num_bol;
    }

    public void setNum_bol(String num_bol) {
        this.num_bol = num_bol;
    }

    public String getIdprod() {
        return idprod;
    }

    public void setIdprod(String idprod) {
        this.idprod = idprod;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreciovta() {
        return preciovta;
    }

    public void setPreciovta(double preciovta) {
        this.preciovta = preciovta;
    }

    public String getNomprod() {
        return nomprod;
    }

    public void setNomprod(String nomprod) {
        this.nomprod = nomprod;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

}
