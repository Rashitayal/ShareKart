package com.informatica.hackathon.ShareKart.controller;

import com.informatica.hackathon.ShareKart.exception.EmailValidator;
import com.informatica.hackathon.ShareKart.exception.InvalidRequestException;
import com.informatica.hackathon.ShareKart.model.Profile;
import com.informatica.hackathon.ShareKart.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileManagementController {

    @Autowired
    private ProfileService profileService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<Profile> saveProfile(@RequestBody Profile profile) throws InvalidRequestException {
        EmailValidator.validateEmail(profile.getEmail());
        return new ResponseEntity<Profile>(profileService.saveProfile(profile), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{email}", method = RequestMethod.GET,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<Profile> getProfileByEmail(@PathVariable(value = "email") String email) {
        return new ResponseEntity<Profile>(profileService.getProfileByEmail(email), HttpStatus.OK);
    }

    @RequestMapping(value = "/{profileId}", method = RequestMethod.PUT,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<Profile> updateProfileById(@PathVariable(value = "profileId") String profileId,
                                                     @RequestBody Profile profile) throws InvalidRequestException {
        EmailValidator.validateEmail(profile.getEmail());
        return new ResponseEntity<Profile>(profileService.updateProfile(profile, profileId), HttpStatus.OK);
    }

    @RequestMapping(value = "/{profileId}", method = RequestMethod.DELETE,
            consumes = "application/json", produces = "application/json")
    public ResponseEntity<Profile> deleteProfileById(@PathVariable(value = "profileId") String profileId) {
        profileService.deleteProfile(profileId);
        return new ResponseEntity<Profile>(HttpStatus.OK);
    }

}
