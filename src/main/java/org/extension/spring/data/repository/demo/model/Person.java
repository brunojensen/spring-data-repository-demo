package org.extension.spring.data.repository.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@SqlResultSetMapping(
    name = "PersonContactResultMapping",
    classes = @ConstructorResult(
        targetClass = PersonContactResultMapping.class,
        columns = {
            @ColumnResult(name = "email", type = String.class),
            @ColumnResult(name = "name", type = String.class),
            @ColumnResult(name = "contact", type = String.class)
        }
    )
)
@Entity
@Table(name = "person")
public class Person {

    @Id
    private String email;
    private String name;
    private String surname;
    private LocalDate birth;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    public Person() {}

    public Person(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
