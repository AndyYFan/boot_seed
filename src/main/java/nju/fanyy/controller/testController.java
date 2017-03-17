package nju.fanyy.controller;

import nju.fanyy.dao.PersonRepository;
import nju.fanyy.model.Message;
import nju.fanyy.model.Person;
import nju.fanyy.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fanyunyi on 2017/3/6.
 */

@RestController
public class testController {

    @Autowired
    PersonRepository personRepository;


    @Autowired
    DemoService demoService;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age){

        Person p = personRepository.save(new Person(name, age, address));

        return p;

    }


    @RequestMapping("/q1")
    public List<Person>ql(String address){
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

//    @RequestMapping("/q2")
//    public Person q2(String name, String address){
//        Person p = personRepository.withNameAndAddressNamedQuery(name, address);
//        return p;
//    }

    @RequestMapping("/q3")
    public Person q3(String name, String address){
        Person p = personRepository.findByNameAndAddress(name,address);
        return p;
    }

    @RequestMapping("/sort")
    public List<Person>sort(){
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC,"age"));
        return people;
    }

    @RequestMapping("/page/{id}" )
    public Page<Person>page(@PathVariable("id")int pageNum){
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(pageNum,2));
        return pagePeople;
    }


    @RequestMapping(value = "/rollback")
    public Person rollback(Person person){
        return demoService.savePersonWithRollBack(person);
    }

    @RequestMapping("/norollback")
    public Person noRollback(Person person){
        return demoService.savePersonWithoutRollBack(person);
    }

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cachable(Person person){
        return demoService.findOne(person);
    }

    @RequestMapping("/rm")
    public String evit(Long id){
         demoService.remove(id);
         return " id removed";
    }
}
