package com.bea.spring.boot.controller;

import com.bea.spring.boot.model.Person;
import com.bea.spring.boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> search() {
        personService.countBy(new Person());
        personService.findById("");
        return personService.searchBy(new Person());
    }
}
