package Entities;

public class Bill {
    private int idBill;
    private int idClient;
    public Bill(int idBill, int idClient) {
        this.idBill = idBill;
        this.idClient = idClient;
    }
    public int getIdBill() {
        return idBill;
    }
    public int getIdClient() {
        return idClient;
    }
    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }


    public String toString(){
        return "Billd id: " + this.idBill + " " + "Client id: " + this.idClient;
    }
}
