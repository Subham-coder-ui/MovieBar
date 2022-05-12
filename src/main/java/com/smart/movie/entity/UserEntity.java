package com.smart.movie.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Choudhury Subham on 12-05-2022
 */

@Entity
@Data
@ToString
public class UserEntity {

    @Id
    private Long id;
    private String username;
    private String password;
    private String role;


}
