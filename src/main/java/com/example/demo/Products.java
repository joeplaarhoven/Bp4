package com.example.demo;

import javax.persistence.*;

@Entity
public class Products {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer product_Id;
    private String product_Name;

    public Products() {  }

    public Products(String product_Name) {  this.product_Name = product_Name;}


    public Integer getProductId() {
        return product_Id;
    }

    void setProductId(Integer productId) {
        this.product_Id = productId;
    }

    public String getProductName() {
        return product_Name;
    }

    void setProductName(String product_Name) {
        this.product_Name = product_Name;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + product_Id +
                ", content='" + product_Name + '\'' +
                '}';
    }
}