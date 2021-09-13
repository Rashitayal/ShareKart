package com.informatica.hackathon.ShareKart.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sub_category")
public class SubCategory {

    @Id
    @Column(name = "sub_cat_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "sub_cat_name")
    private String name;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", nullable = false)
    private Category category;

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

}
