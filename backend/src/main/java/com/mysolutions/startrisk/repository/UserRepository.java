package com.mysolutions.startrisk.repository;


import com.mysolutions.startrisk.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(@Param("lastname") String lastname);

    List<User> findByFirstName(@Param("firstname") String firstname);

}
