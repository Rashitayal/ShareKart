package com.informatica.hackathon.ShareKart.model;

import javax.persistence.*;

@Entity
@Table(name = "connections")
public class OrderHistory {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @Column(name = "purchaseDate")
    String purchaseDate;

    @Column(name = "purchaseCount")
    String purchaseCount;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "profile_id", nullable = false)
    Profile profile;

    public OrderHistory() {
    }

    public OrderHistory(String id, Product product, String purchaseDate, String purchaseCount, Profile profile) {
        this.id = id;
        this.product = product;
        this.purchaseDate = purchaseDate;
        this.purchaseCount = purchaseCount;
        this.profile = profile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public String getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(String purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
