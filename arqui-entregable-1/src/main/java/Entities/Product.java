package Entities;

public class Product {

    private int idProduct;

    private String name;

    private float value;

    public Product(int idProduct, String name, float value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
