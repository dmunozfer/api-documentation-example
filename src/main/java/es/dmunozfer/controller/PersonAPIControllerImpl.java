package es.dmunozfer.controller;

import es.dmunozfer.model.Person;
import es.dmunozfer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by David Muñoz on 18/02/2017.
 */
@RestController
@RequestMapping("/api/persons")
public class PersonAPIControllerImpl implements PersonAPI {

    PersonRepository personRepository;

    @Autowired
    public PersonAPIControllerImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    @PostMapping
    public Person create(Person person) {
        return personRepository.save(person);
    }

    @Override
    @GetMapping
    public Collection<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(Long id) {
        personRepository.delete(id);
    }
}
