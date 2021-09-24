package com.informatica.hackathon.ShareKart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @Column(name = "sub_cat_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sub_cat_name")
    private String name;

    @JsonBackReference(value="category")
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonManagedReference(value="subCategory")
    @OneToMany(mappedBy = "subCategory")
    private List<Likes> likesList;

    @JsonManagedReference(value="subCategory")
    @OneToMany(mappedBy = "subCategory")
    private List<DisLikes> dislikesList;

    @JsonManagedReference(value="subCategory")
    @OneToMany(mappedBy = "subCategory")
    private List<Product> productList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Likes> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Likes> likesList) {
        this.likesList = likesList;
    }

    public List<DisLikes> getDislikesList() {
        return dislikesList;
    }

    public void setDislikesList(List<DisLikes> dislikesList) {
        this.dislikesList = dislikesList;
    }
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
