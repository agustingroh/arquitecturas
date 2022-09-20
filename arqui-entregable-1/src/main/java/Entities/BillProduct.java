package Entities;

public class BillProduct {
    private int idBill;

    private int idProduct;

    private int quantity;

    public BillProduct(int idBill, int idProduct, int quantity) {
        this.idBill = idBill;
        this.idProduct = idProduct;
        this.quantity = quantity;
    }

    public int getIdBill() {
        return idBill;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
