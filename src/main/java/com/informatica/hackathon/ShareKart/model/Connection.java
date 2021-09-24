package com.informatica.hackathon.ShareKart.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "connections")
public class Connection {
    @Id
    @Column(name = "connection_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @JsonBackReference(value = "profilefrom")
    @ManyToOne
    @JoinColumn(name = "from_id", nullable = false)
    Profile from;

    @JsonBackReference(value = "profileto")
    @ManyToOne
    @JoinColumn(name = "to_id", nullable = false)
    Profile to;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
