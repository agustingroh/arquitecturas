package Entities;

public class Factura {

    private int idFactura;

    private int idCliente;//Dónde indico a que tabla referir

    public Factura(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
