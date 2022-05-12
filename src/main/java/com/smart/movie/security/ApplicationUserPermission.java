package com.smart.movie.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Choudhury Subham on 12-05-2022
 */
@AllArgsConstructor
@Getter
public enum ApplicationUserPermission {

    VIEWER_READ("viewer:read"),
    VIEWER_WRITE("viewer:write"),
    MOVIE_READ ("movie:read"),
    MOVIE_WRITE("movie:write");

    private final String permission;

}
