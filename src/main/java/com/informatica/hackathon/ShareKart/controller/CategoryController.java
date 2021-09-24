package com.informatica.hackathon.ShareKart.controller;

import com.informatica.hackathon.ShareKart.exception.InputValidator;
import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.model.Category;
import com.informatica.hackathon.ShareKart.model.RecommendationResponse;
import com.informatica.hackathon.ShareKart.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, consumes = "application/json", produces = "application/json")
    public ResponseEntity<Category> getRecommendation(@PathVariable(value = "catId") Integer catId) throws InvalidRequestException {
        InputValidator.validateInteger(catId);
        return new ResponseEntity<Category>(categoryService.getCategory(catId), HttpStatus.OK);
    }
}
