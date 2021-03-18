package com.domum.entities;

public class OrderItem {
    private Integer id;
    private Product product;
    private Integer quantity;

    public OrderItem() {
    }

    public OrderItem(Integer id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double subTotal(){
        return product.getPrice() * quantity;
    }
}
