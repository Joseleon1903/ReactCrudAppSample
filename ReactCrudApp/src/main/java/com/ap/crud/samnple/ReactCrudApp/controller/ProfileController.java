package com.ap.crud.samnple.ReactCrudApp.controller;

import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import com.ap.crud.samnple.ReactCrudApp.dto.LoginDto;
import com.ap.crud.samnple.ReactCrudApp.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/api/profile")
@CrossOrigin("http://localhost:3000/")
public class ProfileController {

    Logger logger = Logger.getLogger(SchoolController.class.getName());

    private final ProfileService profileService;

    @Autowired
    public ProfileController (ProfileService profileService){
        this.profileService= profileService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Profile> createProfile(@RequestBody Profile profile){
        Profile profileOut = profileService.createProfile(profile);
        return new ResponseEntity<>(profileOut, HttpStatus.OK);
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Profile> loginProfile(@RequestBody LoginDto loginDto){
        Profile profileOut = profileService.login(loginDto);
        if(profileOut == null){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(profileOut, HttpStatus.OK);
    }


}
