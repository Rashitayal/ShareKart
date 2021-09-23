package com.informatica.hackathon.ShareKart.model;

import java.util.List;

public class RecommendationResponse {

    private List<Product> orderHistory;
    private List<Product> likes;
    private List<Product> general;

    public List<Product> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(List<Product> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public List<Product> getLikes() {
        return likes;
    }

    public void setLikes(List<Product> likes) {
        this.likes = likes;
    }

    public List<Product> getGeneral() {
        return general;
    }

    public void setGeneral(List<Product> general) {
        this.general = general;
    }
}
