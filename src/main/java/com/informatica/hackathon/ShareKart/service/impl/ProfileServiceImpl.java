package com.informatica.hackathon.ShareKart.service.impl;

import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.exception.ResourceNotFoundException;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.repository.ProfileRepository;
import com.informatica.hackathon.ShareKart.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile saveProfile(Profile profile) {
        if (profileRepository.findProfileByEmail(profile.getEmail()) != null) {
            throw new InvalidRequestException(
                    String.format("%s with %s %s exists", "profile", "email", profile.getEmail()));
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
        if (!profileRepository.findProfileByEmail(profile.getEmail()).getProfileId().equals(profileId)) {
            throw new InvalidRequestException(
                    String.format("%s with %s %s exists", "profile", "email", profile.getEmail()));
        }
        profile.setProfileId(profileId);
        return profileRepository.save(profile);
    }

    @Override
    public void deleteProfile(String profileId) {
        profileRepository.findById(profileId)
                .orElseThrow(() -> new ResourceNotFoundException("profile", "profileId", profileId));
        profileRepository.deleteById(profileId);
    }

}
