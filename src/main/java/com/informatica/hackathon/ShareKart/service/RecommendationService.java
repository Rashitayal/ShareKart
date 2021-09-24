package com.informatica.hackathon.ShareKart.service;

import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.model.RecommendationResponse;
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

    public RecommendationResponse allRecommendations(String profileId){
        List<Product> likedList = productRecommendation.searchRecommendationsByLikes(profileId);
        List<Product> general = productRecommendation.searchGeneral(profileId);
        RecommendationResponse recommendationResponse = new RecommendationResponse();
        recommendationResponse.setLikes(likedList);
        recommendationResponse.setGeneral(general);
        return recommendationResponse;
    }

    public RecommendationResponse filterRecommendation(String searchInput, String profileId){
      /*  chocolate cake -> product = 5,
                cake = subcategory = 1
                food = category= 1
        chocolate brownie -> <product>*/

        //process searchInput to find categoryId/ subCategoryId/ productId user is looking for

        Integer value =0;
        String type="";



        List<Product> likedList = filteredProductRecommendation.searchRecommendationsByLikes(profileId,type,value);
        List<Product> general = filteredProductRecommendation.searchGeneral(profileId,type,value);
        RecommendationResponse recommendationResponse = new RecommendationResponse();
        recommendationResponse.setLikes(likedList);
        recommendationResponse.setGeneral(general);
        return recommendationResponse;

    }

}
