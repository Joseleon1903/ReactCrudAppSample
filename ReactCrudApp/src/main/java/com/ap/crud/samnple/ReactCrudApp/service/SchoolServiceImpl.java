package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.School;
import com.ap.crud.samnple.ReactCrudApp.exception.EntityAlreadyExist;
import com.ap.crud.samnple.ReactCrudApp.exception.NoExistEntityException;
import com.ap.crud.samnple.ReactCrudApp.reporitory.SchoolRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SchoolServiceImpl implements SchoolService{

    Logger logger = Logger.getLogger(SchoolService.class.getName());

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School register(School school) throws EntityAlreadyExist {
        logger.info("Entering register method");
        logger.info("param: "+ school);

        if (school.getId() != null && schoolRepository.findById(school.getId()).isPresent()){
            throw new EntityAlreadyExist("Ya existe un registro con este Id");
        }
        School entity = schoolRepository.save(school);
        logger.info("Existing register method");
        return entity;
    }

    @Override
    public School findById(Long id) throws NoExistEntityException {
        logger.info("Entering findById method");
        logger.info("param id: "+ id);

        if (id != null && schoolRepository.findById(id).isPresent()){
            logger.info("Existing findById method");
            return schoolRepository.findById(id).get();
        }
        throw new NoExistEntityException("No existe una entidad con este Id");
    }

    @Override
    public School update(School school) throws NoExistEntityException {
        logger.info("Entering update method");
        logger.info("param school: "+ school);

        if (school.getId() != null && schoolRepository.findById(school.getId()).isPresent()){
            logger.info("Existing update method");
            return schoolRepository.save(school);
        }
        throw new NoExistEntityException("No existe una entidad con este Id");
    }

    @Override
    public void deleteById(Long id) {
        logger.info("Entering deleteById method");
        logger.info("param id: "+ id);
        schoolRepository.deleteById(id);
        logger.info("Existing deleteById method");
    }

    @Override
    public List<School> findByParam(Long id, String text) {
        logger.info("Entering findByParam method");
        logger.info("param id: "+ id);
        logger.info("param text: "+ text);
        List<School> response = new ArrayList<>();
        if (id != null && schoolRepository.findById(id).isPresent()){
            logger.info("Existing findByParam method");
            response.add(schoolRepository.findById(id).get());
        }
        response = schoolRepository.findAll();
        if(text == null){
            logger.info("Existing findByParam method");
            return response;
        }
        logger.info("Existing findByParam method");
        return response.stream().filter( r -> r.getName().toUpperCase().contains(text.toUpperCase())).toList();
    }
}
