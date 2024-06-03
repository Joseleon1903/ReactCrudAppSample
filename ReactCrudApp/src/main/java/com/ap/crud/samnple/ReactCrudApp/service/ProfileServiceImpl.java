package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import com.ap.crud.samnple.ReactCrudApp.dto.LoginDto;
import com.ap.crud.samnple.ReactCrudApp.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ProfileServiceImpl implements ProfileService{

    Logger logger = Logger.getLogger(ProfileService.class.getName());

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


    @Override
    public Profile createProfile(Profile profile) {
        logger.info("entering in createProfile");
        logger.info("param : "+profile);
        profile = profileRepository.save(profile);
        return profile;
    }

    @Override
    public Profile login(LoginDto loginDto) {
        logger.info("entering in login");
        logger.info("param : "+loginDto);
        Optional<Profile> profile = profileRepository.findByEmail(loginDto.getEmail());
        if(profile.isPresent() && profile.get().getPassword().equals(loginDto.getPassword())){
            return profile.get();
        }
        return null;
    }
}
