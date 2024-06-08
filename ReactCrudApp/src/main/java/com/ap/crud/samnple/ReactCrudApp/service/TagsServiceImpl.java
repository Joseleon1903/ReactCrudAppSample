package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.domain.Tags;
import com.ap.crud.samnple.ReactCrudApp.dto.TagsDto;
import com.ap.crud.samnple.ReactCrudApp.repository.TagsRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

@Service
public class TagsServiceImpl implements TagsService{

    Logger logger = Logger.getLogger(TagsService.class.getName());

    private final TagsRepository tagsRepository;

    public TagsServiceImpl(TagsRepository tagsRepository) {
        this.tagsRepository = tagsRepository;
    }

    @Override
    public Set<TagsDto> findAllTags() {
        Set<TagsDto> listOut =  new HashSet<>();

        List<Tags> entityList = tagsRepository.findAll();

        entityList.forEach( entity ->{
            TagsDto dto = new TagsDto();
            dto.setId(entity.getId());
            dto.setName(entity.getValue());
            dto.setValue(entity.getValue());
            listOut.add(dto);
        });

        return listOut;
    }
}
