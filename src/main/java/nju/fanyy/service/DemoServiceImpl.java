package nju.fanyy.service;

import nju.fanyy.dao.PersonRepository;
import nju.fanyy.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by fanyunyi on 2017/3/16.
 */
@Component
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if(person.getName().equals("fan")){
            throw new IllegalArgumentException("fan already exists, rolling back");
        }

        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {

        Person p = personRepository.save(person);

        if(person.getName().equals("fan")){
            throw new IllegalArgumentException("already exists, will not rollback");

        }

        return p;
    }

    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("Caching" +
                p.getId()+p.getName()+" data");

        return p;
    }

    @Override
    @CacheEvict("value = people")
    public void remove(Long id) {

        personRepository.delete(id);

        System.out.println("deleting cache of " +
                id);

        return;

    }

    @Override
    @Cacheable(value = "people",key = "#person.id")
    public Person findOne(Person person) {

        Person p  = personRepository.findOne(person.getId());

        System.out.println("Caching for " + person.getName());
        return p;
    }

}
