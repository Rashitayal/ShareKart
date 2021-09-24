package com.informatica.hackathon.ShareKart.model;

import java.util.List;

public class SearchInputResponse {

    private List<Integer> searchIds;
    private String searchType;

    public List<Integer> getSearchIds() {
        return searchIds;
    }

    public void setSearchIds(List<Integer> searchIds) {
        this.searchIds = searchIds;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public SearchInputResponse(String searchType, List<Integer> searchIds) {
        this.searchIds = searchIds;
        this.searchType = searchType;
    }
}
