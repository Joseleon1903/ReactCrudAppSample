package com.ap.crud.samnple.ReactCrudApp.service;

import com.ap.crud.samnple.ReactCrudApp.dto.TagsDto;

import java.util.Set;

public interface TagsService {

    Set<TagsDto> findAllTags();

}
