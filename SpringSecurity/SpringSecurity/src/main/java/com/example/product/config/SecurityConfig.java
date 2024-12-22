package com.example.product.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Autowired
    public UserDetailsService userDetailsService;

    @Autowired
    public JWTFilter jwtFilter;
//    //used to disable security level
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.build();
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(Customizer -> Customizer.disable()) //csrf disable
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/security/register", "/security/login")//it will allow without authenticate these 2 endpoints.
                        .permitAll()
                        .anyRequest().authenticated())// restrict all request
                //http.formLogin(Customizer.withDefaults());//only it should allow browser not postman(username and pass)
                .httpBasic(Customizer.withDefaults())//postman also will work(username and pass)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))//every time it will create new session but if we enable this form login its not work because every time it will create new session so we need to comment formlogin.
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)//after JWT filter it will goes to UPAF
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); No password encoded
        provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration auth) throws Exception {
        return auth.getAuthenticationManager();
    }

    //For temporary usage
//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails userDetails = User
//                .withDefaultPasswordEncoder()
//                .username("Bala")
//                .password("admin")
//                .build();
//
//        UserDetails userDetails1 = User
//                .withDefaultPasswordEncoder()
//                .username("Krish")
//                .password("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(userDetails,userDetails1);
//    }

}
