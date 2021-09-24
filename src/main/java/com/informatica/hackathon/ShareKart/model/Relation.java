package com.informatica.hackathon.ShareKart.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "relation")
public class Relation {

    @Id
    @Column(name = "relation_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @Column(name = "relation_name")
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
