package com.smart.movie.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;

/**
 * @author Choudhury Subham on 11-04-2022
 */
@Data
@Entity
@Table(name = "MOVIE_DETAILS")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer movieId;
    @Column(name = "MOVIE_NAME")
    private String movieName;
    @Column(name = "MOVIE_RATE")
    private String movieRate;
    @Column(name = "MOVIE_TYPE")
    private String movieType;
    @Column(name = "MOVIE_COLLECTION")
    private Double movieCollection;
    @Column(name = "MOVIE_DESC")
    private String movieDesc;
    @Column(name = "CRATED_DATE")
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

}
