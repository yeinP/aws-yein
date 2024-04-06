package org.yeinp.hiimyein.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.hiimyein.dto.MeDto;
import org.yeinp.hiimyein.entity.Me;

import java.util.Optional;

@Repository
public interface MeRepository extends MongoRepository<Me, String> {
    Me findByName(String name);

}
