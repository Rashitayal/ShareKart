package com.informatica.hackathon.ShareKart.model;

import java.util.Date;
import java.util.List;

public class ProfileResponse {

    private String profileId;
    private String email;
    private Date dateOfBirth;
    private String firstName;
    private String lastName;
    private Integer height;
    private String gender;
    private List<Product> likesList;
    private List<Product> dislikesList;
    private List<Connection> connectedTo;
    private List<Connection> connectedFrom;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Product> getLikesList() {
        return likesList;
    }

    public void setLikesList(List<Product> likesList) {
        this.likesList = likesList;
    }

    public List<Product> getDislikesList() {
        return dislikesList;
    }

    public void setDislikesList(List<Product> dislikesList) {
        this.dislikesList = dislikesList;
    }

    public List<Connection> getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(List<Connection> connectedTo) {
        this.connectedTo = connectedTo;
    }

    public List<Connection> getConnectedFrom() {
        return connectedFrom;
    }

    public void setConnectedFrom(List<Connection> connectedFrom) {
        this.connectedFrom = connectedFrom;
    }
}
