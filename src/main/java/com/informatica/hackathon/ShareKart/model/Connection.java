package com.informatica.hackathon.ShareKart.model;

import javax.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {
    @Id
    @Column(name = "connection_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    String id;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "from_id", nullable = false)
    Profile from;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "to_id", nullable = false)
    Profile to;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "relation_id", nullable = false)
    Relation relation;

    public Connection() {
    }

    public Connection(String id, Profile from, Profile to, Relation relation) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.relation = relation;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Profile getFrom() {
        return from;
    }

    public void setFrom(Profile from) {
        this.from = from;
    }

    public Profile getTo() {
        return to;
    }

    public void setTo(Profile to) {
        this.to = to;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }
}
