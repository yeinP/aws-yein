package org.yeinp.hiimyein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.dto.ReadmeDto;


import org.yeinp.hiimyein.entity.Readme;

import org.yeinp.hiimyein.repository.ReadmeRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReadmeServiceImpl implements ReadmeService{

    @Autowired
    ReadmeRepository readmeRepository;

    @Override
    public ReadmeDto getReadMe(String projectitle) {
        Readme readme = readmeRepository.findByProjecttitle(projectitle);
        return reademeEntityToReadmeDto(readme);
    }

    @Override
    public int uploadReadme(ProjectDto projectDto) {


        ReadmeDto readmeDto = new ReadmeDto(null, projectDto.getTitle(), "", new ArrayList<>(),  new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), "", "");

        Readme readme = redmeDtoToReadmeEntity(readmeDto);
        Readme saveReadme = readmeRepository.save(readme);

        return saveReadme != null ? 1 : 0;
    }




}
