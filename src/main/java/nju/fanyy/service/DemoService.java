package nju.fanyy.service;

import nju.fanyy.model.Person;

/**
 * Created by fanyunyi on 2017/3/16.
 */
public interface DemoService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);

    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);
}
