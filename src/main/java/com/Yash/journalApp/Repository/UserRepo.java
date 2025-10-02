package com.Yash.journalApp.Repository;

import com.Yash.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, ObjectId>
{
    User findByUserName (String username);
    User deleteByUserName (String username);

}
