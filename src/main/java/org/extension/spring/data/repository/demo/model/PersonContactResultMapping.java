package org.extension.spring.data.repository.demo.model;

import org.extension.spring.data.repository.annotations.TypedAsSqlResultSetMapping;

@TypedAsSqlResultSetMapping("PersonContactResultMapping")
public class PersonContactResultMapping {

    private String email;

    private String name;

    private String contact;

    public PersonContactResultMapping(String email, String name, String contact) {
        this.email = email;
        this.name = name;
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }
}
