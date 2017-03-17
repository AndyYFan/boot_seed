package nju.fanyy.model;

import org.hibernate.annotations.NamedQuery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by fanyunyi on 2017/3/12.
 */
@Entity
//@NamedQuery(name = "Person.withNameAndAddressNamedQuery",
//        query="select p from Person p where p.name =?1 and address =?2")
public class Person implements Serializable{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Integer age;

    private String address;

    protected Person() {
        super();
    }

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address= address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
