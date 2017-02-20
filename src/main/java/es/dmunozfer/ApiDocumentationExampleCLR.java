package es.dmunozfer;

import es.dmunozfer.model.Player;
import es.dmunozfer.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class ApiDocumentationExampleCLR implements CommandLineRunner {

    PersonRepository personRepository;

    @Autowired
    public ApiDocumentationExampleCLR(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.personRepository.save(Player.builder().name("Zidane").location("Marsella").birth(LocalDate.of(1972, Month.JUNE, 23)).build());
        this.personRepository.save(Player.builder().name("Cristiano").location("Madeira").birth(LocalDate.of(1985, Month.FEBRUARY, 15)).build());
        this.personRepository.save(Player.builder().name("Ronaldo").location("Rio de Janeiro").birth(LocalDate.of(1976, Month.SEPTEMBER, 22)).build());
        this.personRepository.save(Player.builder().name("Messi").location("Rosario").birth(LocalDate.of(1987, Month.JUNE, 24)).build());
        this.personRepository.save(Player.builder().name("Ronaldinho").location("Rosario").birth(LocalDate.of(1980, Month.MARCH, 21)).build());
    }
}
