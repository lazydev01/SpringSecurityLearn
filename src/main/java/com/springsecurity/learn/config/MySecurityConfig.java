package com.springsecurity.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer -> CookieCsrfTokenRepository.withHttpOnlyFalse())
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/signIn").permitAll()
                        .requestMatchers("/home/**").hasRole("USER")
                        .requestMatchers("/users/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin -> formLogin.loginPage("/signIn"));
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user")
                .password(this.passwordEncoder().encode("arpit"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(this.passwordEncoder().encode("arpit"))
                .roles("ADMIN")
                .build();
        UserDetails user3 = User.withUsername("user3")
                .password(this.passwordEncoder().encode("arpit"))
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(user, user2, user3);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(10);
    }
}
