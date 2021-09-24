package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.repository.DisLikesRepository;
import com.informatica.hackathon.ShareKart.repository.LikesRepository;
import com.informatica.hackathon.ShareKart.repository.ProductRepository;
import com.informatica.hackathon.ShareKart.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllProductRecommendation {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private DisLikesRepository dislikesRepository;

    public List<Product> searchRecommendations(List<Integer> catId, List<Integer> subCatId, List<Integer> prodId) {

        List<Product> products = new ArrayList<>();
        List<Integer> subcats = new ArrayList<>();

        if (catId != null && catId.size() > 0) {
            subcats = subCategoryRepository.findSubcatByCatId(catId);
        }
        if (subCatId != null && subCatId.size() > 0) {
            subcats.addAll(subCatId);
        }

        if (subcats.size() > 0) {
            products.addAll(productRepository.findProductBySubCatId(subcats));
        }

        if (prodId != null && prodId.size() > 0) {
            products.addAll(productRepository.findProductById(prodId));
        }

        return products;
    }

    private List<Integer> searchProductId(List<Integer> catId, List<Integer> subCatId, List<Integer> prodId) {

        List<Integer> products = new ArrayList<>();
        List<Integer> subcats = new ArrayList<>();

        if (catId != null && catId.size() > 0) {
            subcats = subCategoryRepository.findSubcatByCatId(catId);
        }
        if (subCatId != null && subCatId.size() > 0) {
            subcats.addAll(subCatId);
        }

        if (subcats.size() > 0) {
            products.addAll(productRepository.findProductIds(subcats));
        }

        if (prodId != null && prodId.size() > 0) {
            products.addAll(prodId);
        }

        return products;
    }

    public List<Product> searchRecommendationsByLikes(String profileId) {

        List<Integer> subcats = new ArrayList<>(likesRepository.findSubcatIdByProfileId(profileId));
        List<Integer> cats = new ArrayList<>(likesRepository.findCatIdByProfileId(profileId));
        //add product likes also
        return searchRecommendations(cats, subcats, null);

    }

    public List<Integer> searchLikedProductIds(String profileId) {

        List<Integer> likedSubcats = new ArrayList<>(likesRepository.findSubcatIdByProfileId(profileId));
        List<Integer> likedCats = new ArrayList<>(likesRepository.findCatIdByProfileId(profileId));

        //handle products also
        return searchProductId(likedCats, likedSubcats, null);
    }

    public List<Integer> searchDislikedProductIds(String profileId) {

        List<Integer> dislikedSubcats = new ArrayList<>(dislikesRepository.findSubcatIdByProfileId(profileId));
        List<Integer> dislikedCats = new ArrayList<>(dislikesRepository.findCatIdByProfileId(profileId));

        //handle products also
        return searchProductId(dislikedCats, dislikedSubcats, null);

    }

    public List<Product> searchGeneral(String profileId) {
        List<Integer> productsToExclude = new ArrayList<>();
        productsToExclude.addAll(searchDislikedProductIds(profileId));
        productsToExclude.addAll(searchLikedProductIds(profileId));
        return productRepository.findProductsToExclude(productsToExclude);
    }

    //search by orderHistory

}
