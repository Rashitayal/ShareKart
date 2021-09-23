package com.informatica.hackathon.ShareKart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.*;
//import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "profile")
public class Profile {

    @Id
    @Column(name = "profile_id")
    @GenericGenerator(name = "sequence_profile_id", strategy = "com.informatica.hackathon.ShareKart.model.generator.ProfileIdGenerator", parameters = @Parameter(name = "prefix", value = "P-"))
    @GeneratedValue(generator = "sequence_profile_id")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String profileId;

    //@Email
    private String email;

    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private Integer height;

    /*@OneToMany(mappedBy = "profile")
    private List<OrderHistory> orderHistoryList;*/


    @Column(name = "gender")
    private String gender;

    @JsonManagedReference(value="profile")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    private List<Likes> likesList;

    @JsonManagedReference(value="profile")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "profile")
    private List<DisLikes> dislikesList;

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
}
