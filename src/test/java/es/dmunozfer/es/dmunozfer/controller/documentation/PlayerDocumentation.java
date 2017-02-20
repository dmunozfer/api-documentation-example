package es.dmunozfer.es.dmunozfer.controller.documentation;

import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.restdocs.payload.JsonFieldType;

import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;

/**
 * Created by David Muñoz on 20/02/2017.
 */
public interface PlayerDocumentation {

    public static final FieldDescriptor[] player = new FieldDescriptor[]{
            fieldWithPath("id").type(JsonFieldType.NUMBER).description("Identificador"),
            fieldWithPath("name").type(JsonFieldType.STRING).description("Nombre"),
            fieldWithPath("birthPlace").type(JsonFieldType.STRING).description("Lugar de nacimiento"),
            fieldWithPath("birth").type(JsonFieldType.STRING).description("Fecha de nacimiento (dd-MM-yyyy).")
    };

    public static final FieldDescriptor[] listPlayers = new FieldDescriptor[]{
            fieldWithPath("[]").description("Listado de jugadores"),

    };
}