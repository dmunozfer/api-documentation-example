package es.dmunozfer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Created by David Muñoz on 18/02/2017.
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate birth;

}
