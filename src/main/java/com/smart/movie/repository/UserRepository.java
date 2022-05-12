package com.smart.movie.repository;

import com.smart.movie.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author Choudhury Subham on 12-05-2022
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Serializable> {

}

