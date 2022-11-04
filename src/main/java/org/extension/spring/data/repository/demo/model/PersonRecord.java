package org.extension.spring.data.repository.demo.model;

public interface PersonRecord {

  public static final String QUERY = """
          SELECT name as fullName,
                 email as email,
                 32 as age
          FROM Person
          -- #pageable
          """;

    public static final String COUNT_QUERY = " SELECT count(*) FROM Person ";

    String getFullName();

    String getEmail();

    Long getAge();

}
