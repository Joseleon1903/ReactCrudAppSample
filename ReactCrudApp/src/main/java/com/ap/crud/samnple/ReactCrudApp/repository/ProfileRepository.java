package com.ap.crud.samnple.ReactCrudApp.repository;

import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ProfileRepository extends CrudRepository<Profile, String> {

    Optional<Profile> findByEmail(String email);

}
