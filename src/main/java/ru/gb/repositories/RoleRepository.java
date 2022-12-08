package ru.gb.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {
}
