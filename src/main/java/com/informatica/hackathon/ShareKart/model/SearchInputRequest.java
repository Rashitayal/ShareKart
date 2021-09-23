package com.informatica.hackathon.ShareKart.model;

import java.util.List;

public class SearchInputRequest {

    private String searchType;
    private List<Integer> searchId;

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public List<Integer> getSearchId() {
        return searchId;
    }

    public void setSearchId(List<Integer> searchId) {
        this.searchId = searchId;
    }
}
