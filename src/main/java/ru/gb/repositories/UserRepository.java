package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.UsersEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UsersEntity, Long> {

    Optional<UsersEntity> findByUsername(String username);
}