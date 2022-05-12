package com.smart.movie.security;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author Choudhury Subham on 12-05-2022
 */

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private final PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","index","/css/*","/api/*")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails viewerDetails=User.builder()
                .username("smith")
                .password(passwordEncoder.encode("password"))
                .roles("VIEWER")
                .build();

        UserDetails adminDetails= User.builder()
                .username("linda")
                .password(passwordEncoder.encode("password123"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(viewerDetails,adminDetails);
    }
}
