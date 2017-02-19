package es.dmunozfer.controller;

import es.dmunozfer.model.Person;

import java.util.Collection;

/**
 * Created by David Muñoz on 18/02/2017.
 */
public interface PersonAPI {

    Person create(Person person);

    Collection<Person> findAll();

    void delete(Long id);
}
