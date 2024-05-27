package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Coord;
import com.ap.crud.samnple.ReactCrudApp.repository.CoordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class CoordServiceImpl implements CoordService {

    Logger logger = Logger.getLogger(CoordService.class.getName());

    private final CoordRepository coordRepository;

    @Autowired
    public CoordServiceImpl(CoordRepository coordRepository) {
        this.coordRepository = coordRepository;
    }


    @Override
    public Coord[] getAll() {
        List<Coord> listOut = new ArrayList<>();
        coordRepository.findAll().iterator().forEachRemaining(
                listOut::add
        );
        return listOut.toArray(Coord[]::new);
    }

    @Override
    public Coord[] saveAll(Coord[] coods) {
        logger.entering(RestaurantServiceImpl.class.getName(),"saveAll" );
        logger.info("entering in saveAll");
        logger.info("coods count: "+coods.length);

        for (Coord entity : coods){
            logger.info("save: "+entity);
            coordRepository.save(entity);
        }
        return coods;
    }
}
