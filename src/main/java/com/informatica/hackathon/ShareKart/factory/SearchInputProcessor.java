package com.informatica.hackathon.ShareKart.factory;

import com.informatica.hackathon.ShareKart.model.Gender;
import com.informatica.hackathon.ShareKart.model.SearchInputResponse;
import com.informatica.hackathon.ShareKart.repository.CategoryRepository;
import com.informatica.hackathon.ShareKart.repository.ProductRepository;
import com.informatica.hackathon.ShareKart.repository.ProfileRepository;
import com.informatica.hackathon.ShareKart.repository.SubCategoryRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

@Component
public class SearchInputProcessor {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProfileRepository profileRepository;

    public SearchInputResponse processInputString(String input, String profileId) {
        //call luis and return search type and list of ids

//        String url = "https://australiaeast.api.cognitive.microsoft.com/luis/prediction/v3.0/apps/9bb381a3-3ed5-43a7-af98-6c035413ade4/slots/staging/predict?subscription-key=e600a20e460d404dae030e7c953cb1a9&verbose=true&query="+input;
//        String itemType = sendGetRequest(url);

        //input = input.toLowerCase(Locale.ROOT);
        input = input.toLowerCase(Locale.ROOT);
        HashMap<String, String> searchToBe = new HashMap<>();
        searchToBe.put("strawberry cake", "product");
        searchToBe.put("cakes", "subcategory");
        searchToBe.put("tshirt", "product");
        searchToBe.put("red rose", "product");
        searchToBe.put("smartphone", "subcategory");
        searchToBe.put("iphone 13", "product");
        searchToBe.put("gadgets", "category");
        searchToBe.put("Saree", "product");
        searchToBe.put("ethnic", "subcategory");
        searchToBe.put("fashion", "category");
        searchToBe.put("flowers", "category");
        searchToBe.put("shakes", "subcategory");
        searchToBe.put("icecreams", "subcategory");
        searchToBe.put("white tulip", "product");
        searchToBe.put("white orchid", "product");

        if (searchToBe.get(input).equals("product")) {
            return new SearchInputResponse("product", productRepository
                    .findSubCatByProdName(input,
                            Gender.valueOf(profileRepository.getGenderForProfile(profileId)).value));
        } else if (searchToBe.get(input).equals("subcategory")) {
            return new SearchInputResponse("subcategory", subCategoryRepository.findSubcatByName(input));
        } else if (searchToBe.get(input).equals("category")) {
            return new SearchInputResponse("category",
                    Arrays.asList(categoryRepository.findCatByCatId(input).getId()));
        }
        return null;
    }

    private String sendGetRequest(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try (Response response = client.newCall(request).execute()) {
            String responseBody = response.body().string();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSONObject intents = jsonObject.getJSONObject("prediction").getJSONObject("intents");
            JSONObject entities = jsonObject.getJSONObject("prediction").getJSONObject("entities");
            String category = entities.get("Category").toString();
            category.substring(3, category.length() - 3);
            return null;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }
}
