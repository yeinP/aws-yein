package org.yeinp.hiimyein.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yeinp.hiimyein.entity.Project;

import java.util.List;

public interface ProjectRepository extends MongoRepository<Project, String> {

    List<Project> findAllByOrderByRegdateDesc();

}
