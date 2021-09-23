package com.informatica.hackathon.ShareKart.factory;

import com.informatica.hackathon.ShareKart.repository.CategoryRepository;
import com.informatica.hackathon.ShareKart.repository.ProductRepository;
import com.informatica.hackathon.ShareKart.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class SearchInputProcessor {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Integer> processInputString(String input) {
        HashMap<String, String> searchToBe = new HashMap<>();
        searchToBe.put("butterscotch icecream", "product");
        searchToBe.put("cake", "subcategory");
        searchToBe.put("tshirt", "product");
        searchToBe.put("red rose", "product");
        searchToBe.put("smartphone", "subcategory");
        searchToBe.put("iphone 13", "product");
        searchToBe.put("gadgets", "category");
        if (searchToBe.get(input).equals("product")) {
            return productRepository.findProductsbyName(input);
        } else if (searchToBe.get(input).equals("subcategory")) {
            return productRepository.findProductIds(subCategoryRepository.findSubcatByName(input));
        } else if (searchToBe.get(input).equals("category")) {
            return productRepository.findProductIds(subCategoryRepository
                    .findSubcatByCatId(Arrays.asList(categoryRepository.findCatByCatId(input).getId())));
        }
        return null;
    }

}
