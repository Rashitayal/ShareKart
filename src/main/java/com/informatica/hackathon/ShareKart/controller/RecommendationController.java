package com.informatica.hackathon.ShareKart.controller;

import com.informatica.hackathon.ShareKart.exception.InputValidator;
import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.model.RecommendationRequest;
import com.informatica.hackathon.ShareKart.model.RecommendationResponse;
import com.informatica.hackathon.ShareKart.service.RecommendationService;
import com.informatica.hackathon.ShareKart.service.impl.AllProductRecommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/recommendation")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @RequestMapping(method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<RecommendationResponse> getRecommendation(@RequestBody RecommendationRequest recommendationRequest) throws InvalidRequestException {
        InputValidator.validateString(recommendationRequest.getSearchInput());
        RecommendationResponse recommendationResponse = recommendationService.filterRecommendation(recommendationRequest.getSearchInput(), recommendationRequest.getProfileId());
        return new ResponseEntity<RecommendationResponse>(recommendationResponse, HttpStatus.CREATED);
    }
}
