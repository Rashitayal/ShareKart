package com.informatica.hackathon.ShareKart.service;

import com.informatica.hackathon.ShareKart.factory.SearchInputProcessor;
import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.model.RecommendationResponse;
import com.informatica.hackathon.ShareKart.model.SearchInputResponse;
import com.informatica.hackathon.ShareKart.service.impl.AllProductRecommendation;
import com.informatica.hackathon.ShareKart.service.impl.FilteredProductRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private AllProductRecommendation productRecommendation;

    @Autowired
    private FilteredProductRecommendation filteredProductRecommendation;

    @Autowired
    private SearchInputProcessor searchInputProcessor;

    public RecommendationResponse allRecommendations(String profileId) {
        List<Product> likedList = productRecommendation.searchRecommendationsByLikes(profileId);
        List<Product> general = productRecommendation.searchGeneral(profileId);
        RecommendationResponse recommendationResponse = new RecommendationResponse();
        recommendationResponse.setLikes(likedList);
        recommendationResponse.setGeneral(general);
        return recommendationResponse;
    }

    public RecommendationResponse filterRecommendation(String searchInput, String profileId) {
        //process searchInput to find categoryId/ subCategoryId/ productId user is looking for

        //find method in searchInputProcessor.processInputString

        SearchInputResponse searchInputResponse = searchInputProcessor.processInputString(searchInput);

        List<Product> likedList = filteredProductRecommendation
                .searchRecommendationsByLikes(profileId, searchInputResponse.getSearchType(),
                        searchInputResponse.getSearchIds());
        List<Product> general = filteredProductRecommendation
                .searchGeneral(profileId, searchInputResponse.getSearchType(), searchInputResponse.getSearchIds());
        RecommendationResponse recommendationResponse = new RecommendationResponse();
        recommendationResponse.setLikes(likedList);
        recommendationResponse.setGeneral(general);
        return recommendationResponse;

    }

}
