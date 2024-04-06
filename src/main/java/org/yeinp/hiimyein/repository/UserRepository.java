package org.yeinp.hiimyein.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.yeinp.hiimyein.dto.UserDto;
import org.yeinp.hiimyein.entity.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserid(String userid);
}
