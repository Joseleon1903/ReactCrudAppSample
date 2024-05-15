package com.ap.crud.samnple.ReactCrudApp.reporitory;

import com.ap.crud.samnple.ReactCrudApp.domain.Coord;
import org.springframework.data.repository.CrudRepository;

public interface CoordRepository extends CrudRepository<Coord, String> {
}
