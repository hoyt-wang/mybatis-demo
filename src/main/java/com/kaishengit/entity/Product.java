package com.kaishengit.entity;

/**
 * Created by Administrator on 2017/10/24.
 */
public class Product {
    private int id;
    private String productName;

    public Product() {}

    public Product(String productName, int productInventory) {
        this.productName = productName;
        this.productInventory = productInventory;
    }

    private int productInventory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(int productInventory) {
        this.productInventory = productInventory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productInventory=" + productInventory +
                '}';
    }
}
