package org.yeinp.hiimyein.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.hiimyein.entity.Skill;

import java.util.List;

@Repository
public interface SkillRepository extends MongoRepository<Skill, String> {
    List<Skill> findByDiv(String div);
}
