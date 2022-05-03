package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.User;

public interface UserRepository extends CustomCrudRepository<User>{
    User findByName(String name);
}
