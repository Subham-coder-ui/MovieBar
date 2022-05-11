package com.smart.movie.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Choudhury Subham on 11-04-2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private Integer movieId;
    private String movieName;
    private String movieRate;
    private String movieType;
    private String movieDesc;
    private Double movieCollection;
    private Date createdDate;
    private Date updatedDate;

}
