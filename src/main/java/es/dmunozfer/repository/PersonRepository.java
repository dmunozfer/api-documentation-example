package es.dmunozfer.repository;

import es.dmunozfer.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by David Muñoz on 18/02/2017.
 */
public interface PersonRepository extends JpaRepository<Player, Long> {

}
