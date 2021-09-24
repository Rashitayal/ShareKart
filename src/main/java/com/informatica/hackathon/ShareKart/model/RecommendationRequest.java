package com.informatica.hackathon.ShareKart.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecommendationRequest {
    @JsonProperty("ProfileId")
    private String ProfileId;

    @JsonProperty("searchInput")
    private String searchInput;

    public String getProfileId() {
        return ProfileId;
    }

    public void setProfileId(String profileId) {
        ProfileId = profileId;
    }

    public String getSearchInput() {
        return searchInput;
    }

    public void setSearchInput(String searchInput) {
        this.searchInput = searchInput;
    }
}
