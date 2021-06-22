package beans;

public class CabeceraBoletaDTO {

    private String num_bol, fch_bol;
    private int cod_cliente;

    public CabeceraBoletaDTO() {
    }

    public String getNum_bol() {
        return num_bol;
    }

    public void setNum_bol(String num_bol) {
        this.num_bol = num_bol;
    }

    public String getFch_bol() {
        return fch_bol;
    }

    public void setFch_bol(String fch_bol) {
        this.fch_bol = fch_bol;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

}
