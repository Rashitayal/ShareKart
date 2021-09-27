package com.informatica.hackathon.ShareKart.service;

import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.model.ProfileResponse;

import java.util.List;

public interface ProfileService {
    Profile saveProfile(Profile profile);

    ProfileResponse getProfileByEmail(String email);

    ProfileResponse updateProfile(Profile profile, String profileId);

    void deleteProfile(String profileId);

    List<Profile> getAllProfile(String profileId);
}
