package nju.fanyy.dao;

import nju.fanyy.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fanyunyi on 2017/3/10.
 */

@RepositoryRestResource(path="people")
public interface PersonRepository extends JpaRepository<Person,Long> {
    List<Person> findByAddress(String name);

    Person findByNameAndAddress(String name, String address);

}
