package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.exception.ResourceNotFoundException;
import com.informatica.hackathon.ShareKart.model.Gender;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.repository.*;
import com.informatica.hackathon.ShareKart.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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

        if (profile.getLikesList().size() > 0) {
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
        if (profile.getDislikesList().size() > 0) {
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
    public Profile getProfileByEmail(String email) {
        Profile p = profileRepository.findProfileByEmail(email);
        if (p == null) {
            throw new ResourceNotFoundException("profile", "email", email);
        }
        return p;
    }

    @Override
    public Profile updateProfile(Profile profile, String profileId) {
        Profile p = profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile", "profileId", profileId));
        Profile pByEmail = profileRepository.findProfileByEmail(profile.getEmail());
        if (pByEmail != null && !pByEmail.getProfileId().equals(profileId)) {
            throw new InvalidRequestException(
                    String.format("%s with %s %s exists", "profile", "email", profile.getEmail()));
        }
        profile.setProfileId(profileId);

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
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(String profileId) {
        profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile", "profileId", profileId));
        profileRepository.deleteById(profileId);
    }

}
