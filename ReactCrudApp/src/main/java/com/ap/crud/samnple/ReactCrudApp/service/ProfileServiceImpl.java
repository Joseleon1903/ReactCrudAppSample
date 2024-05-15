package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.reporitory.ProfileRepository;
import com.ap.crud.samnple.ReactCrudApp.reporitory.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProfileServiceImpl implements ProfileService{

    Logger logger = Logger.getLogger(ProfileService.class.getName());

    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }


}
