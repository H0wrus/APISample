package fr.morandini.APISample.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class User {

    @Id
    private long id;
    private String lastName;
    private String firstName;
    private String email;
    private String pseudo;

}
