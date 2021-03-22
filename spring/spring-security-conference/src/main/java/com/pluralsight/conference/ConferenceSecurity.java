package com.pluralsight.conference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class ConferenceSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.authorizeRequests()
                // Everyone who wants to access these pages, can do so in anonymous mode
                .antMatchers("/anonymous*").anonymous()

                // Every request is permitted onto this endpoint
                .antMatchers("/login*").permitAll()

                // Permit all assets
                .antMatchers("/assets/css/**", "/assets/js/**", "/images/**").permitAll()

                .antMatchers("/index*").permitAll()

                // Every other request needs to be authenticated
                .anyRequest().authenticated()
                .and()

                // Login form specific settings, like url path and action path
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login") // Action path
                .defaultSuccessUrl("/", true);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        //auth.jdbcAuthentication().dataSource(dataSource);
        auth.ldapAuthentication()
                // Setting up domain name pattern
                // uid={0} = first character to parse in for search
                // ou = Organisational Unit
                .userDnPatterns("uid={0},ou=people")

                .groupSearchBase("ou=groups")
                .contextSource()

                // dc = Directory Context
                .url("ldap://localhost:8389/dc=pluralsight,dc=com")
                .and()
                .passwordCompare()
                .passwordEncoder(passwordEncoder())
                .passwordAttribute("userPassword");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
