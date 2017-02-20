package es.dmunozfer.es.dmunozfer.controller;

import es.dmunozfer.controller.PlayersAPI;
import es.dmunozfer.model.Player;
import es.dmunozfer.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static es.dmunozfer.es.dmunozfer.controller.documentation.PlayerDocumentation.listPlayers;
import static es.dmunozfer.es.dmunozfer.controller.documentation.PlayerDocumentation.player;
import static org.mockito.BDDMockito.given;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;


/**
 * Created by shadd on 20/02/2017.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PlayersAPI.class)
@AutoConfigureRestDocs(outputDir = "target/generated-snippets")
public class PlayersApiControllerTest {

    @MockBean
    PersonRepository personRepository;

    @Autowired
    private MockMvc mvc;
    @Autowired
    private RestDocumentationResultHandler restDocumentation;

    @Test
    public void listPlayers() throws Exception {
        // Given:
        //  - existen jugadores
        given(this.personRepository.findAll()).willReturn(listOfPlayers());

        // When:
        //  - obtiene listado de jugadores
        this.mvc.perform(get("/api/players").header("Authorization", "a")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(restDocumentation.document(
                        responseFields(listPlayers).andWithPrefix("[].", player)
                ))
                // Then:
                //  - Devuelve 200 ok
                .andExpect(status().isOk())
                //  - Tiene 5 elementos
                .andExpect(jsonPath("[*]", hasSize(5)))
        ;
    }

    // --------------------------------------------------------------------------
    // -- Privated methods
    // --------------------------------------------------------------------------

    private List<Player> listOfPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(Player.builder().id(1L).name("Zidane").birthPlace("Marsella").birth(LocalDate.of(1972, Month.JUNE, 23)).build());
        players.add(Player.builder().id(2L).name("Cristiano").birthPlace("Madeira").birth(LocalDate.of(1985, Month.FEBRUARY, 15)).build());
        players.add(Player.builder().id(3L).name("Ronaldo").birthPlace("Rio de Janeiro").birth(LocalDate.of(1976, Month.SEPTEMBER, 22)).build());
        players.add(Player.builder().id(4L).name("Messi").birthPlace("Rosario").birth(LocalDate.of(1987, Month.JUNE, 24)).build());
        players.add(Player.builder().id(5L).name("Ronaldinho").birthPlace("Rosario").birth(LocalDate.of(1980, Month.MARCH, 21)).build());
        return players;
    }

    // --------------------------------------------------------------------------
    // -- TestConfiguration
    // --------------------------------------------------------------------------

    @TestConfiguration
    static class ResultHandlerConfiguration {

        @Bean
        public RestDocumentationResultHandler restDocumentation() {
            return document("{class-name}/{method-name}",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()));
        }

    }
}
