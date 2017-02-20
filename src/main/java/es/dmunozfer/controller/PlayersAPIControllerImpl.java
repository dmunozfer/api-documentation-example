package es.dmunozfer.controller;

import es.dmunozfer.model.Player;
import es.dmunozfer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by David Muñoz on 18/02/2017.
 */
@RestController
@RequestMapping("/api/players")
public class PlayersAPIControllerImpl implements PlayersAPI {

    @Autowired
    PersonRepository personRepository;

    @Override
    @PostMapping
    public Player create(Player person) {
        return personRepository.save(person);
    }

    @Override
    @GetMapping(value = "/{id}")
    public Player get(@PathVariable("id") Long id) {
        return personRepository.findOne(id);
    }

    @Override
    @GetMapping
    public Collection<Player> findAll() {
        return personRepository.findAll();
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Long id) {
        personRepository.delete(id);
    }

}
