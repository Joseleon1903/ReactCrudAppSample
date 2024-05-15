package com.ap.crud.samnple.ReactCrudApp.reporitory;

import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import com.ap.crud.samnple.ReactCrudApp.domain.Profile;
import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository extends CrudRepository<Profile, String> {

}
