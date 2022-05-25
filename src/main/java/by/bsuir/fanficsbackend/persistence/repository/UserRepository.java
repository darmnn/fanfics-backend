package by.bsuir.fanficsbackend.persistence.repository;

import by.bsuir.fanficsbackend.persistence.entity.User;

import java.util.Optional;

public interface UserRepository extends CustomCrudRepository<User>{
    Optional<User> findByName(String name);
    User findByEmail(String email);
}
