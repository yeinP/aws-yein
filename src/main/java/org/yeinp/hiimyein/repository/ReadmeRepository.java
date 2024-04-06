package org.yeinp.hiimyein.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.yeinp.hiimyein.entity.Readme;

public interface ReadmeRepository extends MongoRepository<Readme, String> {
    Readme findByProjecttitle(String projectitle);

    void deleteByProjecttitle(String projecttitle);
}
