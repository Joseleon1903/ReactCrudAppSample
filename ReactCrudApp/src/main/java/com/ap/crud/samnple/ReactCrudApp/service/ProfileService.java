package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import com.ap.crud.samnple.ReactCrudApp.dto.LoginDto;

public interface ProfileService {

    Profile createProfile(Profile profile);


    Profile login(LoginDto loginDto);
}
