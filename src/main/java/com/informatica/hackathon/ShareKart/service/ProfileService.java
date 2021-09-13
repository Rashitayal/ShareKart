package com.informatica.hackathon.ShareKart.service;

import com.informatica.hackathon.ShareKart.model.Profile;

public interface ProfileService {
    Profile saveProfile(Profile profile);
    Profile getProfileByEmail(String email);
    Profile updateProfile(Profile profile, String profileId);
    void deleteProfile(String profileId);
}
