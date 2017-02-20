package es.dmunozfer.controller;

import es.dmunozfer.model.Player;

import java.util.Collection;

/**
 * Created by David Muñoz on 18/02/2017.
 */
public interface PlayersAPI {

    Player create(Player person);

    Player get(Long id);

    Collection<Player> findAll();

    void delete(Long id);
}
