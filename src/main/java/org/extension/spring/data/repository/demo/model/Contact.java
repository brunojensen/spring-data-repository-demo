package org.extension.spring.data.repository.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "contact")
public class Contact {

    @Id
    private String code;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Person person;

    Contact() {}

    public Contact(String code, String name, Person person) {
        this.code = code;
        this.name = name;
        this.person = person;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
