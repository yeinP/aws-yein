package org.yeinp.hiimyein.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.dto.ReadmeDto;
import org.yeinp.hiimyein.entity.Project;
import org.yeinp.hiimyein.entity.Readme;

@Component
public class ReadmeMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateReadme(ReadmeDto readmeDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(readmeDto.getId()));

        Update update = new Update();
        update.set("projecttitle", readmeDto.getProjecttitle());
        update.set("summary", readmeDto.getSummary());
        update.set("mainfunction", readmeDto.getMainfunction());
        update.set("tech", readmeDto.getTech());
        update.set("rolebe", readmeDto.getRolebe());
        update.set("rolefe", readmeDto.getRolefe());
        update.set("review", readmeDto.getReview());
        update.set("code", readmeDto.getCode());


        mongoTemplate.updateFirst(query, update, Readme.class);
    }
}
