package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.model.DisLikes;
import com.informatica.hackathon.ShareKart.model.Gender;
import com.informatica.hackathon.ShareKart.model.Likes;
import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.repository.DisLikesRepository;
import com.informatica.hackathon.ShareKart.repository.LikesRepository;
import com.informatica.hackathon.ShareKart.repository.ProductRepository;
import com.informatica.hackathon.ShareKart.repository.ProfileRepository;
import com.informatica.hackathon.ShareKart.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class FilteredProductRecommendation {

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private DisLikesRepository dislikesRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public List<Product> searchRecommendations(List<Integer> catId, List<Integer> subCatId, List<Integer> prodId,
                                               String gender) {

        List<Product> products = new ArrayList<>();
        List<Integer> subcats = new ArrayList<>();

        if (catId != null && catId.size() > 0) {
            subcats = subCategoryRepository.findSubcatByCatId(catId);
        }
        if (subCatId != null && subCatId.size() > 0) {
            subcats.addAll(subCatId);
        }

        if (subcats.size() > 0) {
            products.addAll(productRepository.findProductBySubCatId(subcats, gender));
        }

        if (prodId != null && prodId.size() > 0) {
            products.addAll(productRepository.findProductById(prodId, gender));
        }

        return products;
    }

    private List<Integer> searchProductId(List<Integer> catId, List<Integer> subCatId, List<Integer> prodId,
                                          String gender) {

        List<Integer> products = new ArrayList<>();
        List<Integer> subcats = new ArrayList<>();

        if (catId != null && catId.size() > 0) {
            subcats = subCategoryRepository.findSubcatByCatId(catId);
        }
        if (subCatId != null && subCatId.size() > 0) {
            subcats.addAll(subCatId);
        }

        if (subcats.size() > 0) {
            products.addAll(productRepository.findProductIds(subcats, gender));
        }

        if (prodId != null && prodId.size() > 0) {
            products.addAll(prodId);
        }

        return products;
    }

    public List<Product> searchRecommendationsByLikes(String profileId, String searchType, List<Integer> searchId,
                                                      String searchInput) {

        if (searchType.equalsIgnoreCase("category")) {
            List<Likes> cats = likesRepository.findlikesByProfileIdAndCatId(profileId, searchId);
            if (cats != null && cats.size() > 0) {
                return searchRecommendations(searchId, null, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(searchId);
                List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchRecommendations(null, result, null,
                            Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchRecommendations(null, result, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchRecommendations(null, null, productRepository.findProductsbyName(searchInput,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value),
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }
        }

        return Collections.EMPTY_LIST;

    }

    public List<Integer> searchLikedProductIds(String profileId, String searchType, List<Integer> searchId,
                                               String searchInput) {
        List<Integer> dislikedSubcats = new ArrayList<>();
        List<Integer> dislikedCats = new ArrayList<>();

        if (searchType.equalsIgnoreCase("category")) {
            List<Likes> cats = likesRepository.findlikesByProfileIdAndCatId(profileId, searchId);
            if (cats != null && cats.size() > 0) {
                return searchProductId(searchId, null, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(searchId);
                List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchProductId(null, result, null,
                            Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result =
                    likesRepository.findlikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchProductId(null, result, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchProductId(null, null, productRepository.findProductsbyName(searchInput,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value),
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }
        }

        return Collections.EMPTY_LIST;

        //handle products also

    }

    public List<Integer> searchDislikedProductIds(String profileId, String searchType, List<Integer> searchId,
                                                  String searchInput) {
        List<Integer> dislikedSubcats = new ArrayList<>();
        List<Integer> dislikedCats = new ArrayList<>();

        if (searchType.equalsIgnoreCase("category")) {
            List<DisLikes> cats = dislikesRepository.findDislikesByProfileIdAndCatId(profileId, searchId);
            if (cats != null && cats.size() > 0) {
                return searchProductId(searchId, null, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(searchId);
                List<Integer> result = dislikesRepository.findDislikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchProductId(null, result, null,
                            Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result =
                    dislikesRepository.findDislikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchProductId(null, result, null,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result = dislikesRepository.findDislikesByProfileIdAndSubCatId(profileId, searchId);
            if (result.size() > 0) {
                return searchProductId(null, null, productRepository.findProductsbyName(searchInput,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value),
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }
        }

        return Collections.EMPTY_LIST;

        //handle products also

    }

    public List<Product> searchGeneral(String profileId, String type, List<Integer> searchId, String searchInput) {
        List<Integer> productsToExclude = new ArrayList<>();
        productsToExclude.addAll(searchDislikedProductIds(profileId, type, searchId, searchInput));
        productsToExclude.addAll(searchLikedProductIds(profileId, type, searchId, searchInput));

        if (productsToExclude == null || productsToExclude.size() == 0) {
            if (type.equalsIgnoreCase("category")) {
                return productRepository.findProductBySubCatId(subCategoryRepository.findSubcatByCatId(searchId),
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            } else if (type.equalsIgnoreCase("subcategory")) {
                return productRepository.findProductBySubCatId(searchId,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            } else if (type.equalsIgnoreCase("product")) {
                return productRepository.findProductBySubCatId(searchId,
                        Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value);
            }
        } else {
            if (type.equalsIgnoreCase("category")) {
                return productRepository.findProductsToExcludeBySearch(productsToExclude,
                        subCategoryRepository.findSubcatByCatId(searchId));
            } else if (type.equalsIgnoreCase("subcategory")) {
                return productRepository.findProductsToExcludeBySearch(productsToExclude, searchId);
            } else if (type.equalsIgnoreCase("product")) {
                return productRepository.findProductsToExcludeBySearch(productsToExclude, searchId);
            }
        }

        return Collections.EMPTY_LIST;

    }

}
