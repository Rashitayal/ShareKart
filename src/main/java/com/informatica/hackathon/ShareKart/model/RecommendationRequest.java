package com.informatica.hackathon.ShareKart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationRequest {
    private String profileId;

    private String searchInput;

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
}
