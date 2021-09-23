package com.informatica.hackathon.ShareKart.controller;

import com.informatica.hackathon.ShareKart.exception.InputValidator;
import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.model.RecommendationResponse;
import com.informatica.hackathon.ShareKart.service.impl.AllProductRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/profile")
public class RecommendationController {

    @Autowired
    private AllProductRecommendation allProductRecommendation;

    @RequestMapping(method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<RecommendationResponse> getRecommendation(@PathVariable(value = "searchString") String searchString) throws InvalidRequestException {
        InputValidator.validateSearch(searchString);
        //TODO : why its returning integer list in UI need data only we cnt show Ids.
        List<Integer> integerList = allProductRecommendation.searchLikedProductIds(searchString);
        return new ResponseEntity<RecommendationResponse>(, HttpStatus.CREATED);
    }
}
