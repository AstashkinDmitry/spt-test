package com.spt.test.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = "product_order")
@Entity
public class ProductOrder extends BasicEntity {

    @Column(nullable = false)
    private String seller;

    @Column(nullable = false)
    private String customer;

    @OneToMany(mappedBy = "productOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> products = new HashSet<>();

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setProductOrder(this);
    }

    public void removeProduct(Product product) {
        products.remove(product);
        product.setProductOrder(null);
    }
}
