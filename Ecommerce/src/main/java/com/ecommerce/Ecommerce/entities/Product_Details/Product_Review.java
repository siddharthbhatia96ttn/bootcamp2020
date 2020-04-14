package com.ecommerce.Ecommerce.entities.Product_Details;

import com.ecommerce.Ecommerce.entities.Registration_Details.Customer;

import javax.persistence.*;

@Entity
public class Product_Review {
    @Id
    @GeneratedValue(generator = "increment")
    private Integer id;
    private String review;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "customer_user_id")
    private Customer customer_name;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Customer getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(Customer customer_name) {
        this.customer_name = customer_name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
