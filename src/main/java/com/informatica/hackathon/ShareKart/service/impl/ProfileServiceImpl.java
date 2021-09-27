package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.exception.ResourceNotFoundException;
import com.informatica.hackathon.ShareKart.model.*;
import com.informatica.hackathon.ShareKart.repository.*;
import com.informatica.hackathon.ShareKart.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private DisLikesRepository dislikesRepository;

    @Autowired
    private ConnectionRepository connectionRepository;

    @Override
    @Transactional
    public Profile saveProfile(Profile profile) {
        if (profileRepository.findProfileByEmail(profile.getEmail()) != null) {
            throw new InvalidRequestException(
                    String.format("%s with %s %s exists", "profile", "email", profile.getEmail()));
        }
        if (profile.getGender() != null) {
            String genderLabel = Gender.valueOfLabel(profile.getGender().toLowerCase());
            profile.setGender(genderLabel);
        }

        if (profile.getLikesList()!= null && profile.getLikesList().size() > 0) {
            profile.getLikesList().stream().forEach(e -> {
                        e.setProfile(profile);
                        if (e.getSubCategory() != null) {
                            e.setSubCategory(subCategoryRepository.findSubCatSubCatAndCatId(e.getSubCategory().getName(),
                                    e.getSubCategory().getCategory().getName()));
                        } else if (e.getCategory() != null) {
                            e.setCategory(categoryRepository.findCatByCatId(e.getCategory().getName()));
                        }
                    }
            );
        }
        if (profile.getDislikesList()!= null && profile.getDislikesList().size() > 0) {
            profile.getDislikesList().stream().forEach(e -> {
                        e.setProfile(profile);
                        if (e.getSubCategory() != null) {
                            e.setSubCategory(subCategoryRepository.findSubCatSubCatAndCatId(e.getSubCategory().getName(),
                                    e.getSubCategory().getCategory().getName()));
                        } else if (e.getCategory() != null) {
                            e.setCategory(categoryRepository.findCatByCatId(e.getCategory().getName()));
                        }
                    }
            );
        }
        return profileRepository.save(profile);

    }

    @Override
    public ProfileResponse getProfileByEmail(String email) {
        Profile p = profileRepository.findProfileByEmail(email);
        return getProfileResponse(p);
    }

    private ProfileResponse getProfileResponse(Profile p) {
        p.setLikesList(likesRepository.findlikesByProfileId(p.getProfileId()));
        p.setDislikesList(dislikesRepository.findDislikesByProfileId(p.getProfileId()));
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setEmail(p.getEmail());
        profileResponse.setProfileId(p.getProfileId());
        profileResponse.setDateOfBirth(p.getDateOfBirth());
        profileResponse.setHeight(p.getHeight());
        profileResponse.setFirstName(p.getFirstName());
        profileResponse.setLastName(p.getLastName());
        profileResponse.setGender(p.getGender());
        List<Product> likesList = new ArrayList<>();
        for (int i = 0; i< p.getLikesList().size(); i++){
            Product product = new Product();
            if(p.getLikesList().get(i).getSubCategory()!=null){
                product.setName(p.getLikesList().get(i).getSubCategory().getName());
                product.setLikesList(p.getLikesList());
                likesList.add(product);
            }

        }
        profileResponse.setLikesList(likesList);

        List<Product> disLikesList = new ArrayList<>();
        for (int i = 0; i< p.getDislikesList().size(); i++){
            Product product = new Product();
            if(p.getDislikesList().get(i).getSubCategory()!=null) {
                product.setName(p.getDislikesList().get(i).getSubCategory().getName());
                product.setDislikesList(p.getDislikesList());
                disLikesList.add(product);
            }

        }
        profileResponse.setDislikesList(disLikesList);
        profileResponse.setConnectedFrom(p.getConnectedFrom());
        profileResponse.setConnectedTo(p.getConnectedTo());
        return profileResponse;
    }

    @Override
    public ProfileResponse updateProfile(Profile profile, String profileId) {
        Profile p = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile", "profileId", profileId));
        Profile pByEmail = profileRepository.findProfileByEmail(profile.getEmail());
        if (pByEmail != null && !pByEmail.getProfileId().equals(profileId)) {
            throw new InvalidRequestException(
                    String.format("%s with %s %s exists", "profile", "email", profile.getEmail()));
        }
        profile.setProfileId(profileId);

        if (profile.getGender() != null) {
            String genderLabel = Gender.valueOfLabel(profile.getGender().toLowerCase());
            profile.setGender(genderLabel);
        }
        likesRepository.clearCategorySubCategoryByProfileId(profile.getProfileId());
        dislikesRepository.clearCategorySubCategoryByProfileId(profile.getProfileId());

        if (profile.getLikesList() != null && profile.getLikesList().size() > 0) {
            profile.getLikesList().stream().forEach(e -> {
                        e.setProfile(profile);
                        if (e.getSubCategory() != null) {
                            e.setSubCategory(subCategoryRepository.findSubCatSubCatAndCatId(e.getSubCategory().getName(),
                                    e.getSubCategory().getCategory().getName()));
                        } else if (e.getCategory() != null) {
                            e.setCategory(categoryRepository.findCatByCatId(e.getCategory().getName()));
                        }
                    }
            );
        }
        if (profile.getDislikesList() != null && profile.getDislikesList().size() > 0) {
            profile.getDislikesList().stream().forEach(e -> {
                        e.setProfile(profile);
                        if (e.getSubCategory() != null) {
                            e.setSubCategory(subCategoryRepository.findSubCatSubCatAndCatId(e.getSubCategory().getName(),
                                    e.getSubCategory().getCategory().getName()));
                        } else if (e.getCategory() != null) {
                            e.setCategory(categoryRepository.findCatByCatId(e.getCategory().getName()));
                        }
                    }
            );
        }
        Profile profile1 = profileRepository.save(profile);
        return getProfileResponse(profile1);
    }

    @Override
    public void deleteProfile(String profileId) {
        profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile", "profileId", profileId));
        profileRepository.deleteById(profileId);
    }

    @Override
    public List<Profile> getAllProfile(String profileId) {
        List<String> output = connectionRepository.findConnectionsIdsForProfile(profileId);
        if(output==null || output.size()==0){
            output=new ArrayList<>();
            output.add(profileId);
        }
        return profileRepository.getUnconnectedProfile(output,profileId);
    }

}
