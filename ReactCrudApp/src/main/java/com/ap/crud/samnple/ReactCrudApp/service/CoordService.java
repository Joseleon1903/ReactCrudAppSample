package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Coord;

import java.util.List;

public interface CoordService {

    Coord[] getAll();

    Coord[] saveAll(Coord[] coods);

}
