package com.investment.proposal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Investment Security Configuration Class
 * Spring Boot: Security configuration for investment system protection
 * This class manages investment system authentication and authorization
 * ensuring secure access to investment proposal management services
 */
@Configuration  // Spring Boot: Configuration class annotation for investment security
// Registers this class as a source of security configuration beans
@EnableWebSecurity  // Spring Boot: Enable web security for investment protection
// Activates Spring Security web security features for investment system
@EnableMethodSecurity  // Spring Boot: Enable method-level security for investment access control
// Allows fine-grained security control on investment service methods
public class SecurityConfig {

    /**
     * Security Filter Chain Configuration for Investment System
     * Spring Boot: Security filter chain for investment system protection
     * Configures authentication and authorization for investment management services
     * Implements investment system access control and user authentication workflows
     *
     * @param http HttpSecurity instance for investment security configuration
     *             Provides builder for configuring investment security rules
     * @return SecurityFilterChain instance for investment system security
     *         Defines security processing chain for investment HTTP requests
     * @throws Exception if security configuration fails for investment system
     *                   Handles investment security configuration errors
     */
    @Bean  // Spring Boot: Bean definition for investment security filter chain
    // Registers SecurityFilterChain as a managed Spring security component
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Spring Boot: Configure HTTP security for investment system protection
        // Defines authentication and authorization rules for investment services
        http
                // Spring Boot: Configure authorization rules for investment endpoints
                // Defines access control for different investment management resources
                .authorizeHttpRequests(authz -> authz
                        // Spring Boot: Protect investment API endpoints with authentication
                        // Requires valid credentials for investment proposal management operations
                        .requestMatchers("/api/investment-proposals/**").authenticated()
                        // Spring Boot: Allow public access to investment web interface
                        // Enables investment management UI without authentication for demo
                        .requestMatchers("/", "/home", "/css/**", "/js/**").permitAll()
                        // Spring Boot: Allow access to H2 console for investment development
                        // Provides database access for investment system development and testing
                        .requestMatchers("/h2-console/**").permitAll()
                        // Spring Boot: Allow access to actuator endpoints for investment monitoring
                        // Enables investment system health checks and operational metrics
                        .requestMatchers("/actuator/**").permitAll()
                        // Spring Boot: Default access rule for other investment endpoints
                        // Requires authentication for any other investment system resources
                        .anyRequest().authenticated()
                )
                // Spring Boot: Enable HTTP Basic authentication for investment system
                // Provides simple authentication mechanism for investment API access
                .httpBasic()
                // Spring Boot: Disable CSRF protection for investment development
                // Allows investment system to work with H2 console and REST clients
                .and()
                .csrf().disable()
                // Spring Boot: Disable frame options for investment H2 console access
                // Enables investment system to display H2 database console in frames
                .headers().frameOptions().disable();

        // Spring Boot: Return configured security filter chain for investment system
        // Completes investment security configuration with defined rules and policies
        return http.build();
    }
}