package org.yeinp.hiimyein.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.entity.Me;


@Component
public class AboutmeMapper {


    @Autowired
    private MongoTemplate mongoTemplate;

    public void updateAboutMe(MeDto meDto) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(meDto.getId()));

        Update update = new Update();
        update.set("name", meDto.getName());
        update.set("phone", meDto.getPhone());
        update.set("birth", meDto.getBirth());
        update.set("mail", meDto.getMail());
        update.set("git", meDto.getGit());
        update.set("blog", meDto.getBlog());
        update.set("portfolio", meDto.getPortfolio());

        mongoTemplate.updateFirst(query, update, Me.class);
    }
}
