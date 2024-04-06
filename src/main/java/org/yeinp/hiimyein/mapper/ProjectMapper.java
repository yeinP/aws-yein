package org.yeinp.hiimyein.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.dto.ProjectDto;
import org.yeinp.hiimyein.entity.Me;
import org.yeinp.hiimyein.entity.Project;

@Component
public class ProjectMapper {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateProject(ProjectDto projectDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(projectDto.getId()));

        Update update = new Update();
        update.set("title", projectDto.getTitle());
        update.set("sumup", projectDto.getSumup());
        update.set("content", projectDto.getContent());
        update.set("function", projectDto.getFunction());
        update.set("giturl", projectDto.getGiturl());
        update.set("backend", projectDto.getBackend());
        update.set("frontend", projectDto.getFrontend());
        update.set("db", projectDto.getDb());
        update.set("ide", projectDto.getIde());
        update.set("deployment", projectDto.getDeployment());
        update.set("role", projectDto.getRole());
        update.set("server", projectDto.getServer());
        update.set("imageURLs", projectDto.getImageURLs());
        update.set("regdate", projectDto.getRegdate());

        mongoTemplate.updateFirst(query, update, Project.class);
    }
}
