package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.model.Product;
import com.informatica.hackathon.ShareKart.repository.DisLikesRepository;
import com.informatica.hackathon.ShareKart.repository.LikesRepository;
import com.informatica.hackathon.ShareKart.repository.ProductRepository;
import com.informatica.hackathon.ShareKart.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
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

    public List<Product> searchRecommendationsByLikes(String profileId, String searchType, Integer searchId) {

        if (searchType.equalsIgnoreCase("category")) {

            if (likesRepository.findlikesByProfileIdAndCatId(profileId, searchId) != null) {
                return searchRecommendations(Arrays.asList(searchId), null, null);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(Arrays.asList(searchId));
                List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchRecommendations(null, result, null);
                } else {
                    List<Integer> resultnew = likesRepository
                            .findlikesByProfileIdAndProdId(profileId, productRepository.findProductIds(subcats));
                    if (resultnew.size() > 0) {
                        return searchRecommendations(null, null, result);
                    }
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchRecommendations(null, result, null);
            } else {
                List<Integer> resultnew = likesRepository.findlikesByProfileIdAndProdId(profileId,
                        productRepository.findProductIds(Arrays.asList(searchId)));
                if (resultnew.size() > 0) {
                    return searchRecommendations(null, null, result);
                }
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result = likesRepository.findlikesByProfileIdAndProdId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchRecommendations(null, null, result);
            }
        }

        return Collections.EMPTY_LIST;

    }

    public List<Integer> searchLikedProductIds(String profileId, String searchType, Integer searchId) {
        List<Integer> dislikedSubcats = new ArrayList<>();
        List<Integer> dislikedCats = new ArrayList<>();

        if (searchType.equalsIgnoreCase("category")) {
            if (likesRepository.findlikesByProfileIdAndCatId(profileId, searchId) != null) {
                return searchProductId(Arrays.asList(searchId), null, null);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(Arrays.asList(searchId));
                List<Integer> result = likesRepository.findlikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchProductId(null, result, null);
                } else {
                    List<Integer> resultnew = likesRepository
                            .findlikesByProfileIdAndProdId(profileId, productRepository.findProductIds(subcats));
                    if (resultnew.size() > 0) {
                        return searchProductId(null, null, resultnew);
                    }
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result =
                    likesRepository.findlikesByProfileIdAndSubCatId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchProductId(null, result, null);
            } else {
                List<Integer> resultnew = likesRepository.findlikesByProfileIdAndProdId(profileId,
                        productRepository.findProductIds(Arrays.asList(searchId)));
                if (resultnew.size() > 0) {
                    return searchProductId(null, null, result);
                }
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result =
                    likesRepository.findlikesByProfileIdAndProdId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchProductId(null, null, result);
            }
        }

        return Collections.EMPTY_LIST;

        //handle products also

    }

    public List<Integer> searchDislikedProductIds(String profileId, String searchType, Integer searchId) {
        List<Integer> dislikedSubcats = new ArrayList<>();
        List<Integer> dislikedCats = new ArrayList<>();

        if (searchType.equalsIgnoreCase("category")) {
            if (dislikesRepository.findDislikesByProfileIdAndCatId(profileId, searchId) != null) {
                return searchProductId(Arrays.asList(searchId), null, null);
            } else {
                List<Integer> subcats = subCategoryRepository.findSubcatByCatId(Arrays.asList(searchId));
                List<Integer> result = dislikesRepository.findDislikesByProfileIdAndSubCatId(profileId, subcats);
                if (result.size() > 0) {
                    return searchProductId(null, result, null);
                } else {
                    List<Integer> resultnew = dislikesRepository
                            .findDislikesByProfileIdAndProdId(profileId, productRepository.findProductIds(subcats));
                    if (resultnew.size() > 0) {
                        return searchProductId(null, null, resultnew);
                    }
                }
            }

        } else if (searchType.equalsIgnoreCase("subcategory")) {

            List<Integer> result =
                    dislikesRepository.findDislikesByProfileIdAndSubCatId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchProductId(null, result, null);
            } else {
                List<Integer> resultnew = dislikesRepository.findDislikesByProfileIdAndProdId(profileId,
                        productRepository.findProductIds(Arrays.asList(searchId)));
                if (resultnew.size() > 0) {
                    return searchProductId(null, null, result);
                }
            }

        } else if (searchType.equalsIgnoreCase("product")) {
            List<Integer> result =
                    dislikesRepository.findDislikesByProfileIdAndProdId(profileId, Arrays.asList(searchId));
            if (result.size() > 0) {
                return searchProductId(null, null, result);
            }
        }

        return Collections.EMPTY_LIST;

        //handle products also

    }

    public List<Product> searchGeneral(String profileId, String type, Integer searchId) {
        List<Integer> productsToExclude = new ArrayList<>();
        productsToExclude.addAll(searchDislikedProductIds(profileId, type, searchId));
        productsToExclude.addAll(searchLikedProductIds(profileId, type, searchId));
        return productRepository.findProductsToExclude(productsToExclude);
    }

}
