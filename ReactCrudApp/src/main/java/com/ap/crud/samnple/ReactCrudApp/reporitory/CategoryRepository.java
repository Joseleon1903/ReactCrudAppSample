package com.ap.crud.samnple.ReactCrudApp.reporitory;

import com.ap.crud.samnple.ReactCrudApp.domain.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, String> {
}
