package org.yeinp.hiimyein.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.dto.ReadmeDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.Readme;

import java.util.List;

public interface ReadmeService {

    ReadmeDto getReadMe(String projectitle);

    default ReadmeDto reademeEntityToReadmeDto(Readme readme){
        return ReadmeDto.builder().id(readme.getId())
                .projecttitle(readme.getProjecttitle())
                .summary(readme.getSummary())
                .mainfunction(readme.getMainfunction())
                .tech(readme.getTech())
                .rolefe(readme.getRolefe())
                .rolebe(readme.getRolebe())
                .review(readme.getReview())
                .code(readme.getCode())
                .build();
    }

    default  Readme redmeDtoToReadmeEntity(ReadmeDto readmeDto){
       return Readme.builder().id(readmeDto.getId())
                .projecttitle(readmeDto.getProjecttitle())
                .summary(readmeDto.getSummary())
                .mainfunction(readmeDto.getMainfunction())
                .tech(readmeDto.getTech())
               .rolefe(readmeDto.getRolefe())
               .rolebe(readmeDto.getRolebe())
                .review(readmeDto.getReview()).code(readmeDto.getCode())
                .build();
    }
    public int uploadReadme(ProjectDto projectDto);




}
