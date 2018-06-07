package org.extension.spring.data.repository.controller;

import org.extension.spring.data.repository.model.Contact;
import org.extension.spring.data.repository.model.Person;
import org.extension.spring.data.repository.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/person")
    public List<Person> search() {
        personService.countBy(new Person("John"));
        personService.count();
        personService.findById("");
        personService.searchBy(new Person("John"));
        personService.searchBy(new Person("John"), PageRequest.of(2, 100));
        personService.searchBy(new Person("John"), PageRequest.of(2, 100, new Sort(Sort.Direction.ASC, "name")));
        personService.findAll(PageRequest.of(2, 100));
        personService.findAll();
        personService.findAll2();
        return null;
    }

    @GetMapping("/person/create")
    public void create() {
        IntStream.range(1, 999).forEach(index -> {
            Person person = new Person("John");
            person.setBirth(LocalDate.of(1988, 9, 1));
            person.setEmail("app+"+index+"@gmail.com");
            person.setContacts(Arrays.asList(new Contact("001", "Name", person)));
            personService.save(person);
        });
    }
}
