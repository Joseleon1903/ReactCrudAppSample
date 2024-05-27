package com.ap.crud.samnple.ReactCrudApp.repository;

import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, String> {

}
