# Investment Proposal Management System - Spring Boot Demo Project

Here's a complete Spring Boot demo project for investment proposal management with detailed comments:

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/investment/proposal/
│   │       ├── InvestmentProposalApplication.java
│   │       ├── config/
│   │       │   ├── InvestmentConfig.java
│   │       │   ├── SecurityConfig.java
│   │       │   └── CacheConfig.java
│   │       ├── controller/
│   │       │   ├── InvestmentProposalController.java
│   │       │   └── HomeController.java
│   │       ├── entity/
│   │       │   └── InvestmentProposal.java
│   │       ├── repository/
│   │       │   └── InvestmentProposalRepository.java
│   │       ├── service/
│   │       │   ├── InvestmentProposalService.java
│   │       │   └── InvestmentAsyncService.java
│   │       ├── dto/
│   │       │   └── InvestmentProposalDTO.java
│   │       ├── exception/
│   │       │   ├── InvestmentProposalNotFoundException.java
│   │       │   └── GlobalExceptionHandler.java
│   │       ├── event/
│   │       │   ├── InvestmentProposalCreatedEvent.java
│   │       │   └── InvestmentEventListener.java
│   │       └── scheduler/
│   │           └── InvestmentScheduler.java
│   └── resources/
│       ├── application.yml
│       ├── application-dev.yml
│       ├── application-prod.yml
│       ├── data.sql
│       ├── static/
│       │   └── css/
│       │       └── style.css
│       └── templates/
│           ├── index.html
│           └── proposals.html
└── test/
    └── java/
        └── com/investment/proposal/
            ├── InvestmentProposalApplicationTests.java
            └── service/
                └── InvestmentProposalServiceTest.java
```

## pom.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 
         http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <!-- Spring Boot: Project coordinates and parent configuration -->
    <!-- Defines the project structure and inherits Spring Boot defaults -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.2.0</version>
        <relativePath/> <!-- Spring Boot: Lookup parent from repository -->
    </parent>

    <!-- Spring Boot: Project identification for investment management system -->
    <!-- Unique identifier for the investment proposal management application -->
    <groupId>com.investment</groupId>
    <artifactId>investment-proposal-management</artifactId>
    <version>1.0.0</version>
    <name>investment-proposal-management</name>
    <description>Investment Proposal Management System using Spring Boot</description>

    <!-- Spring Boot: Java version specification for investment application -->
    <!-- Ensures compatibility with modern Java features for investment processing -->
    <properties>
        <java.version>17</java.version>
    </properties>

    <!-- Spring Boot: Dependencies for investment management system -->
    <!-- Core dependencies that enable investment proposal management functionality -->
    <dependencies>
        
        <!-- Spring Boot: Web starter for investment REST API and MVC -->
        <!-- Provides embedded Tomcat server and web framework for investment services -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <!-- Spring Boot: Data JPA starter for investment database operations -->
        <!-- Enables investment proposal persistence with Hibernate ORM -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>

        <!-- Spring Boot: Security starter for investment system protection -->
        <!-- Provides authentication and authorization for investment management -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-security</artifactId>
        </dependency>

        <!-- Spring Boot: Validation starter for investment data validation -->
        <!-- Enables investment proposal data validation with Bean Validation -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Spring Boot: Cache starter for investment performance optimization -->
        <!-- Provides caching capabilities for investment portfolio analysis -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-cache</artifactId>
        </dependency>

        <!-- Spring Boot: Actuator starter for investment system monitoring -->
        <!-- Enables investment system health checks and operational metrics -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>

        <!-- Spring Boot: Thymeleaf starter for investment web templates -->
        <!-- Provides server-side rendering for investment management UI -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>

        <!-- Spring Boot: H2 Database for investment development and testing -->
        <!-- Embedded database for investment proposal storage during development -->
        <dependency>
            <groupId>com.h2database</groupId>
            <artifactId>h2</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Spring Boot: Configuration Processor for investment configuration metadata -->
        <!-- Generates metadata for investment configuration properties -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>

        <!-- Spring Boot: Test starter for investment system testing -->
        <!-- Provides testing framework and utilities for investment services -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Spring Boot: Security test utilities for investment security testing -->
        <!-- Provides testing support for investment security configurations -->
        <dependency>
            <groupId>org.springframework.security</groupId>
            <artifactId>spring-security-test</artifactId>
            <scope>test</scope>
        </dependency>
    </dependencies>

    <!-- Spring Boot: Build configuration for investment management system -->
    <!-- Defines how the investment application should be built and packaged -->
    <build>
        <plugins>
            <!-- Spring Boot: Maven plugin for investment application packaging -->
            <!-- Creates executable JAR with embedded dependencies for investment system -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <!-- Spring Boot: Main class specification for investment application -->
                    <!-- Explicitly defines the main class for investment system startup -->
                    <mainClass>com.investment.proposal.InvestmentProposalApplication</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## src/main/resources/application.yml
```yaml
# Spring Boot: Main application configuration for investment management system
# Centralized configuration for investment proposal management application
server:
  # Spring Boot: Server configuration for investment web application
  # Defines HTTP port and context path for investment services
  port: 8080  # Spring Boot: HTTP port for investment management system
  servlet:
    context-path: /investment  # Spring Boot: Base URL path for investment services

# Spring Boot: Application name for investment management system
# Used for logging, monitoring, and service identification
spring:
  application:
    name: investment-proposal-management  # Spring Boot: Investment system name
  
  # Spring Boot: H2 Database configuration for investment development
  # Embedded database setup for investment proposal storage during development
  datasource:
    url: jdbc:h2:mem:investmentdb  # Spring Boot: In-memory H2 database for investment data
    driver-class-name: org.h2.Driver  # Spring Boot: H2 database driver
    username: sa  # Spring Boot: Database username for investment system
    password:  # Spring Boot: Database password (empty for development)
  
  # Spring Boot: JPA/Hibernate configuration for investment data access
  # ORM settings for investment proposal persistence and management
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect  # Spring Boot: H2 database dialect
    hibernate:
      ddl-auto: create-drop  # Spring Boot: Auto-create/drop investment tables
    show-sql: true  # Spring Boot: Show SQL statements for investment debugging
    properties:
      hibernate:
        format_sql: true  # Spring Boot: Format SQL for investment readability
  
  # Spring Boot: H2 Console configuration for investment database access
  # Web-based database console for investment data inspection
  h2:
    console:
      enabled: true  # Spring Boot: Enable H2 web console for investment development
      path: /h2-console  # Spring Boot: URL path for investment database console
  
  # Spring Boot: Cache configuration for investment performance optimization
  # Caching settings for investment portfolio analysis and data retrieval
  cache:
    type: simple  # Spring Boot: Simple cache implementation for investment data
  
  # Spring Boot: Security configuration for investment management system
  # Authentication and authorization settings for investment services
  security:
    user:
      name: admin  # Spring Boot: Default admin username for investment system
      password: password  # Spring Boot: Default admin password for investment access
      roles: ADMIN, INVESTMENT_MANAGER  # Spring Boot: Admin roles for investment management

# Spring Boot: Custom investment management configuration properties
# Application-specific settings for investment proposal management workflows
investment:
  management:
    max-investment-amount: 10000000.00  # Spring Boot: Maximum investment limit
    default-advisor-strategy: ROUND_ROBIN  # Spring Boot: Advisor assignment strategy
    risk-assessment-service-url: http://localhost:8081/risk-assessment  # Spring Boot: Risk service URL
    portfolio-review-cron: "0 0 9 * * MON"  # Spring Boot: Weekly portfolio review schedule

# Spring Boot: Actuator configuration for investment system monitoring
# Operational metrics and health endpoints for investment management
management:
  endpoints:
    web:
      exposure:
        include: "*"  # Spring Boot: Expose all actuator endpoints for investment monitoring
  endpoint:
    health:
      show-details: always  # Spring Boot: Detailed health information for investment system
```

## src/main/resources/application-dev.yml
```yaml
# Spring Boot: Development profile configuration for investment system
# Environment-specific settings for investment development and testing
spring:
  config:
    activate:
      on-profile: dev  # Spring Boot: Activate this configuration for development profile
  
  # Spring Boot: Development database configuration for investment testing
  # Enhanced logging and debugging for investment development workflows
  datasource:
    url: jdbc:h2:mem:dev_investmentdb  # Spring Boot: Development database instance
    driver-class-name: org.h2.Driver  # Spring Boot: H2 driver for development
    username: dev_user  # Spring Boot: Development database user
    password: dev_password  # Spring Boot: Development database password
  
  # Spring Boot: Development JPA settings for investment debugging
  # Verbose logging for investment data access during development
  jpa:
    show-sql: true  # Spring Boot: Show SQL for investment development debugging
    properties:
      hibernate:
        format_sql: true  # Spring Boot: Format SQL for investment readability
        use_sql_comments: true  # Spring Boot: Add comments to investment SQL

# Spring Boot: Development logging configuration for investment system
# Detailed logging for investment development and debugging
logging:
  level:
    com.investment.proposal: DEBUG  # Spring Boot: Debug level for investment package
    org.springframework: INFO  # Spring Boot: Info level for Spring framework
    org.hibernate: DEBUG  # Spring Boot: Debug level for Hibernate investment operations
```

## src/main/resources/application-prod.yml
```yaml
# Spring Boot: Production profile configuration for investment system
# Secure and optimized settings for investment production deployment
spring:
  config:
    activate:
      on-profile: prod  # Spring Boot: Activate this configuration for production profile
  
  # Spring Boot: Production database configuration for investment system
  # Secure database connection for investment proposal management
  datasource:
    url: jdbc:postgresql://localhost:5432/investment_production  # Spring Boot: Production PostgreSQL
    driver-class-name: org.postgresql.Driver  # Spring Boot: PostgreSQL driver
    username: ${DB_USERNAME:investment_user}  # Spring Boot: Environment variable for username
    password: ${DB_PASSWORD:secure_password}  # Spring Boot: Environment variable for password
  
  # Spring Boot: Production JPA settings for investment performance
  # Optimized settings for investment production environment
  jpa:
    hibernate:
      ddl-auto: validate  # Spring Boot: Validate schema in production
    show-sql: false  # Spring Boot: Disable SQL logging in production
    properties:
      hibernate:
        format_sql: false  # Spring Boot: Disable SQL formatting in production

# Spring Boot: Production logging configuration for investment system
# Secure and efficient logging for investment production environment
logging:
  level:
    com.investment.proposal: INFO  # Spring Boot: Info level for investment package
    org.springframework: WARN  # Spring Boot: Warning level for Spring framework
    org.hibernate: WARN  # Spring Boot: Warning level for Hibernate operations

# Spring Boot: Production security configuration for investment system
# Enhanced security settings for investment production deployment
server:
  error:
    include-message: never  # Spring Boot: Hide error messages in production
    include-binding-errors: never  # Spring Boot: Hide binding errors in production
    include-stacktrace: never  # Spring Boot: Hide stack traces in production
    include-exception: false  # Spring Boot: Hide exceptions in production
```

## src/main/resources/data.sql
```sql
-- Spring Boot: Initial data script for investment proposal management system
-- Sample investment proposals for demonstration and testing purposes

-- Spring Boot: Insert sample investment advisors for investment management
-- Pre-populate investment advisor data for system initialization
INSERT INTO investment_advisors (id, name, email, specialization, created_at) VALUES
  (1, 'Alice Johnson', 'alice.johnson@investment.com', 'STOCKS', CURRENT_TIMESTAMP),
  (2, 'Bob Smith', 'bob.smith@investment.com', 'BONDS', CURRENT_TIMESTAMP),
  (3, 'Carol Davis', 'carol.davis@investment.com', 'REAL_ESTATE', CURRENT_TIMESTAMP);

-- Spring Boot: Insert sample investment proposals for investment portfolio demonstration
-- Pre-populate investment proposal data for system testing and showcase
INSERT INTO investment_proposals (
  proposal_reference, client_name, investment_amount, 
  expected_return, risk_level, investment_type, 
  assigned_advisor, created_at, approved
) VALUES
  ('INV-001', 'John Doe', 50000.00, 7.5, 'MEDIUM', 'STOCKS', 'Alice Johnson', CURRENT_TIMESTAMP, false),
  ('INV-002', 'Jane Smith', 100000.00, 12.0, 'HIGH', 'REAL_ESTATE', 'Carol Davis', CURRENT_TIMESTAMP, true),
  ('INV-003', 'Bob Johnson', 25000.00, 5.8, 'LOW', 'BONDS', 'Bob Smith', CURRENT_TIMESTAMP, false),
  ('INV-004', 'Alice Brown', 75000.00, 9.2, 'MEDIUM', 'MUTUAL_FUNDS', 'Alice Johnson', CURRENT_TIMESTAMP, true),
  ('INV-005', 'Charlie Wilson', 150000.00, 15.5, 'HIGH', 'STOCKS', 'Carol Davis', CURRENT_TIMESTAMP, false);

-- Spring Boot: Insert investment portfolio categories for investment management
-- Pre-populate investment category data for portfolio analysis
INSERT INTO investment_categories (id, name, description, minimum_investment, risk_level) VALUES
  (1, 'Conservative Portfolio', 'Low-risk investment strategy', 10000.00, 'LOW'),
  (2, 'Balanced Portfolio', 'Moderate-risk diversified approach', 25000.00, 'MEDIUM'),
  (3, 'Aggressive Portfolio', 'High-risk growth-oriented strategy', 50000.00, 'HIGH');
```

## src/main/java/com/investment/proposal/InvestmentProposalApplication.java
```java
package com.investment.proposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main Spring Boot Application Class for Investment Proposal Management System
 * Spring Boot: Entry point and main configuration class for investment management
 * This class bootstraps the entire investment proposal management application
 * and enables all necessary Spring Boot features for investment operations
 */
@SpringBootApplication  // Spring Boot: Main application annotation enabling auto-configuration
                        // Automatically configures Spring Boot components for investment system
@EnableConfigurationProperties  // Spring Boot: Enable configuration properties processing
                                // Allows investment system to use externalized configuration
@EnableAsync  // Spring Boot: Enable asynchronous method execution for investment processing
              // Supports concurrent investment operations and background tasks
@EnableScheduling  // Spring Boot: Enable scheduled task execution for investment maintenance
                   // Allows investment system to run periodic portfolio reviews and cleanup
public class InvestmentProposalApplication {

    /**
     * Main method to start Spring Boot Investment Management Application
     * Spring Boot: Application entry point with embedded server startup
     * This method launches the investment proposal management system
     * and initializes all Spring Boot components for investment operations
     * 
     * @param args Command line arguments for investment system startup
     *             Allows runtime configuration of investment application
     */
    public static void main(String[] args) {
        // Spring Boot: Launch investment proposal management application
        // Starts embedded web server and initializes all investment components
        SpringApplication.run(InvestmentProposalApplication.class, args);
        
        // Spring Boot: Log successful startup of investment management system
        // Confirms that all investment services are ready for operation
        System.out.println("Investment Proposal Management System Started Successfully!");
        System.out.println("Access investment management features at: http://localhost:8080/investment");
    }
}
```

## src/main/java/com/investment/proposal/config/InvestmentConfig.java
```java
package com.investment.proposal.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * Investment Management Configuration Class
 * Spring Boot: Configuration class for investment system settings and beans
 * This class manages investment configuration properties and system components
 * enabling flexible investment proposal management workflows
 */
@Configuration  // Spring Boot: Configuration class annotation for investment settings
                // Registers this class as a source of bean definitions for investment system
public class InvestmentConfig {

    /**
     * Investment Management Properties Configuration
     * Spring Boot: Type-safe configuration properties for investment system
     * Provides externalized configuration for investment business rules and limits
     * Supports different environments with profile-specific investment settings
     */
    @ConfigurationProperties(prefix = "investment.management")  // Spring Boot: Configuration properties binding
                                                                 // Maps external properties to investment configuration
    @Validated  // Spring Boot: Enable validation for investment configuration properties
                // Ensures investment settings meet business requirements and constraints
    public static class InvestmentManagementProperties {
        
        /**
         * Maximum investment amount allowed in the system
         * Spring Boot: Configuration property with validation constraints
         * Controls investment risk management and regulatory compliance
         * Prevents excessive investment proposals that exceed system limits
         */
        @NotNull  // Spring Boot: Validation constraint requiring non-null value
                  // Ensures investment system has maximum amount configuration
        @DecimalMin(value = "10000.00")  // Spring Boot: Minimum value validation for investment limits
                                         // Prevents unrealistically low maximum investment amounts
        private BigDecimal maxInvestmentAmount;
        
        /**
         * Default investment advisor assignment strategy
         * Spring Boot: Configuration property for investment workflow customization
         * Enables flexible investment advisor allocation based on business rules
         * Supports different advisor assignment algorithms for investment processing
         */
        @NotBlank  // Spring Boot: Validation constraint requiring non-blank string
                   // Ensures investment system has advisor strategy configuration
        private String defaultAdvisorStrategy;
        
        /**
         * Investment risk assessment service URL
         * Spring Boot: External service configuration for investment analysis
         * Supports integration with third-party investment risk evaluation systems
         * Enables distributed investment processing and specialized risk analysis
         */
        private String riskAssessmentServiceUrl;
        
        // Getters and setters for investment configuration properties access
        public BigDecimal getMaxInvestmentAmount() { return maxInvestmentAmount; }
        public void setMaxInvestmentAmount(BigDecimal maxInvestmentAmount) { this.maxInvestmentAmount = maxInvestmentAmount; }
        public String getDefaultAdvisorStrategy() { return defaultAdvisorStrategy; }
        public void setDefaultAdvisorStrategy(String defaultAdvisorStrategy) { this.defaultAdvisorStrategy = defaultAdvisorStrategy; }
        public String getRiskAssessmentServiceUrl() { return riskAssessmentServiceUrl; }
        public void setRiskAssessmentServiceUrl(String riskAssessmentServiceUrl) { this.riskAssessmentServiceUrl = riskAssessmentServiceUrl; }
    }

    /**
     * Investment Management Properties Bean Definition
     * Spring Boot: Bean definition for investment configuration properties
     * Registers investment configuration as a managed Spring bean for dependency injection
     * Enables investment services to access system-wide configuration settings
     * 
     * @return InvestmentManagementProperties instance for investment configuration
     *         Provides centralized access to investment system settings
     */
    @Bean  // Spring Boot: Bean definition annotation for investment configuration
           // Registers InvestmentManagementProperties as a managed Spring component
    public InvestmentManagementProperties investmentManagementProperties() {
        // Spring Boot: Create new investment management properties instance
        // Initializes investment configuration with default values
        return new InvestmentManagementProperties();
    }

    /**
     * RestTemplate Bean for Investment Service Integration
     * Spring Boot: HTTP client bean for external investment services
     * Enables investment system integration with third-party investment services
     * Supports investment risk assessment and portfolio analysis workflows
     * 
     * @return RestTemplate instance for investment HTTP operations
     *         Provides HTTP client capabilities for investment service integration
     */
    @Bean  // Spring Boot: Bean definition for investment HTTP client
           // Registers RestTemplate as a managed Spring component for investment services
    public RestTemplate restTemplate() {
        // Spring Boot: Create new RestTemplate instance for investment services
        // Initializes HTTP client with default configuration for investment operations
        return new RestTemplate();
    }
}
```

## src/main/java/com/investment/proposal/config/SecurityConfig.java
```java
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
```

## src/main/java/com/investment/proposal/config/CacheConfig.java
```java
package com.investment.proposal.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Investment Cache Configuration Class
 * Spring Boot: Cache configuration for investment data access optimization
 * This class manages investment system caching to improve performance
 * and reduce database load for investment portfolio analysis operations
 */
@Configuration  // Spring Boot: Configuration class annotation for investment caching
                // Registers this class as a source of cache configuration beans
@EnableCaching  // Spring Boot: Enable caching mechanisms for investment performance
                // Activates Spring caching features for investment data access optimization
public class CacheConfig {

    /**
     * Cache Manager Bean for Investment System
     * Spring Boot: Cache manager configuration for investment performance optimization
     * Provides caching capabilities for investment portfolio analysis and data retrieval
     * Implements investment system caching strategy for improved response times
     * 
     * @return CacheManager instance for investment system caching
     *         Provides caching infrastructure for investment data access optimization
     */
    @Bean  // Spring Boot: Bean definition for investment cache manager
           // Registers CacheManager as a managed Spring caching component
    public CacheManager cacheManager() {
        // Spring Boot: Create concurrent map cache manager for investment system
        // Initializes simple in-memory caching for investment portfolio data
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        
        // Spring Boot: Configure cache names for investment system components
        // Defines specific caches for different investment data types and operations
        cacheManager.setCacheNames(java.util.Arrays.asList(
            "investmentProposals",  // Spring Boot: Cache for investment proposal data
            "investmentPortfolio",  // Spring Boot: Cache for investment portfolio analysis
            "investmentAdvisors"    // Spring Boot: Cache for investment advisor information
        ));
        
        // Spring Boot: Return configured cache manager for investment system
        // Provides caching infrastructure for investment performance optimization
        return cacheManager;
    }
}
```

## src/main/java/com/investment/proposal/entity/InvestmentProposal.java
```java
package com.investment.proposal.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Investment Proposal Entity for Database Mapping
 * Spring Boot: JPA Entity with Hibernate validation for investment data
 * This class represents investment proposal data in relational database
 * and supports investment audit trails and regulatory compliance requirements
 */
@Entity  // Spring Boot: JPA Entity annotation for database mapping
         // Maps this class to investment_proposals table in database
@Table(name = "investment_proposals")  // Spring Boot: Database table mapping for investment proposals
                                       // Specifies table name for investment proposal storage
public class InvestmentProposal {
    
    /**
     * Unique identifier for investment proposal tracking
     * Spring Boot: Primary key with auto-generation strategy for investment data
     * Ensures investment proposal uniqueness and audit trail integrity
     * Supports investment proposal identification and relationship management
     */
    @Id  // Spring Boot: Primary key annotation for investment proposal ID
         // Marks this field as the primary key for investment proposal entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Spring Boot: Auto-increment ID generation
                                                         // Automatically generates unique IDs for investment proposals
    private Long id;
    
    /**
     * Investment proposal reference number
     * Spring Boot: Unique constraint for investment tracking and client communication
     * Supports investment proposal identification and status monitoring
     * Enables investment portfolio management by reference number
     */
    @Column(unique = true, nullable = false)  // Spring Boot: Database column constraints for investment reference
                                              // Ensures unique and required investment proposal references
    @NotBlank  // Spring Boot: Validation constraint for required investment reference
               // Prevents investment proposals without reference numbers
    @Size(min = 3, max = 20)  // Spring Boot: String length validation for investment reference
                              // Ensures investment reference numbers have appropriate length
    private String proposalReference;
    
    /**
     * Client name for investment relationship management
     * Spring Boot: Indexed column for investment client queries and portfolio management
     * Enables efficient investment portfolio management by client relationship
     * Supports investment client service and communication workflows
     */
    @Column(nullable = false)  // Spring Boot: Non-null database constraint for client name
                               // Ensures all investment proposals have client information
    @NotBlank  // Spring Boot: Validation constraint for required client information
               // Prevents investment proposals without client names
    @Size(min = 2, max = 100)  // Spring Boot: String length validation for client names
                               // Ensures client names have appropriate length for investment processing
    private String clientName;
    
    /**
     * Investment amount for portfolio allocation
     * Spring Boot: Decimal precision for financial data storage and calculations
     * Ensures accurate investment calculations and reporting requirements
     * Supports investment portfolio analysis and financial compliance
     */
    @Column(nullable = false, precision = 15, scale = 2)  // Spring Boot: Financial data precision for investment amounts
                                                          // Ensures accurate storage of investment financial data
    @DecimalMin(value = "1000.00")  // Spring Boot: Minimum investment validation for risk management
                                    // Prevents unrealistically small investment proposals
    @DecimalMax(value = "10000000.00")  // Spring Boot: Maximum investment validation for risk control
                                        // Prevents excessively large investment proposals
    private BigDecimal investmentAmount;
    
    /**
     * Expected return rate for investment performance tracking
     * Spring Boot: Percentage format for investment metrics and analysis
     * Supports investment performance analysis and client reporting requirements
     * Enables investment portfolio optimization and risk assessment
     */
    @Column(nullable = false)  // Spring Boot: Required expected return data for investment analysis
                               // Ensures all investment proposals have expected return information
    @DecimalMin(value = "0.0")  // Spring Boot: Non-negative return validation for investment metrics
                                // Prevents negative expected return values in investment proposals
    @DecimalMax(value = "100.0")  // Spring Boot: Realistic return validation for investment proposals
                                  // Prevents unrealistically high expected return values
    private BigDecimal expectedReturn;
    
    /**
     * Investment risk level for portfolio management and risk assessment
     * Spring Boot: Enum mapping for investment categorization and risk management
     * Enables investment risk-based portfolio allocation and management strategies
     * Supports investment compliance and regulatory reporting requirements
     */
    @Enumerated(EnumType.STRING)  // Spring Boot: String-based enum storage for investment risk levels
                                  // Stores risk level as readable strings in investment database
    @Column(nullable = false)  // Spring Boot: Required risk level data for investment proposals
                               // Ensures all investment proposals have risk level classification
    private RiskLevel riskLevel;
    
    /**
     * Investment type for asset allocation analysis and portfolio management
     * Spring Boot: Category-based investment classification for portfolio optimization
     * Supports investment diversification and asset allocation strategies
     * Enables investment portfolio analysis and reporting workflows
     */
    @Column(nullable = false)  // Spring Boot: Required investment type data for investment proposals
                               // Ensures all investment proposals have investment type classification
    @NotBlank  // Spring Boot: Validation constraint for required investment category
               // Prevents investment proposals without investment type information
    private String investmentType;
    
    /**
     * Assigned investment advisor for client service and accountability
     * Spring Boot: Investment advisor relationship tracking for service delivery
     * Ensures proper investment service delivery and professional accountability
     * Supports investment advisor performance tracking and client relationship management
     */
    @Column(nullable = false)  // Spring Boot: Required advisor assignment for investment proposals
                               // Ensures all investment proposals have assigned advisors
    @NotBlank  // Spring Boot: Validation constraint for required advisor information
               // Prevents investment proposals without advisor assignments
    private String assignedAdvisor;
    
    /**
     * Investment proposal creation timestamp for audit trails and compliance
     * Spring Boot: Automatic timestamp for investment audit trails and historical analysis
     * Supports investment compliance and regulatory reporting requirements
     * Enables investment proposal tracking and historical analysis workflows
     */
    @Column(nullable = false)  // Spring Boot: Required timestamp data for investment proposals
                               // Ensures all investment proposals have creation timestamps
    private LocalDateTime createdAt;
    
    /**
     * Investment proposal approval status for workflow management
     * Spring Boot: Boolean flag for investment workflow management and tracking
     * Enables investment proposal tracking and processing workflows
     * Supports investment compliance and regulatory approval processes
     */
    @Column(nullable = false)  // Spring Boot: Required approval status for investment proposals
                               // Ensures all investment proposals have approval status tracking
    private Boolean approved = false;
    
    /**
     * Default constructor for investment proposal entity
     * Spring Boot: Default constructor for JPA entity instantiation
     * Initializes investment proposal with automatic timestamp creation
     * Supports investment proposal entity lifecycle management
     */
    public InvestmentProposal() {
        // Spring Boot: Initialize creation timestamp for investment proposal
        // Automatically sets current time for investment proposal creation
        this.createdAt = LocalDateTime.now();
    }
    
    /**
     * Parameterized constructor for investment proposal creation
     * Spring Boot: Constructor for investment proposal initialization with data
     * Creates investment proposal with provided parameters and automatic timestamp
     * Supports investment proposal creation workflows and data initialization
     * 
     * @param proposalReference Unique reference for investment proposal tracking
     * @param clientName Client name for investment relationship management
     * @param investmentAmount Investment amount for portfolio allocation
     * @param expectedReturn Expected return rate for performance tracking
     * @param riskLevel Risk level for portfolio management and risk assessment
     * @param investmentType Investment type for asset allocation analysis
     * @param assignedAdvisor Assigned advisor for client service and accountability
     */
    public InvestmentProposal(String proposalReference, String clientName, BigDecimal investmentAmount,
                            BigDecimal expectedReturn, RiskLevel riskLevel, String investmentType, String assignedAdvisor) {
        // Spring Boot: Call default constructor for timestamp initialization
        // Ensures investment proposal has automatic creation timestamp
        this();
        // Spring Boot: Initialize investment proposal with provided parameters
        // Sets all investment proposal fields with provided data values
        this.proposalReference = proposalReference;
        this.clientName = clientName;
        this.investmentAmount = investmentAmount;
        this.expectedReturn = expectedReturn;
        this.riskLevel = riskLevel;
        this.investmentType = investmentType;
        this.assignedAdvisor = assignedAdvisor;
    }
    
    // Getters and setters for investment proposal data access
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getProposalReference() { return proposalReference; }
    public void setProposalReference(String proposalReference) { this.proposalReference = proposalReference; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public BigDecimal getInvestmentAmount() { return investmentAmount; }
    public void setInvestmentAmount(BigDecimal investmentAmount) { this.investmentAmount = investmentAmount; }
    public BigDecimal getExpectedReturn() { return expectedReturn; }
    public void setExpectedReturn(BigDecimal expectedReturn) { this.expectedReturn = expectedReturn; }
    public RiskLevel getRiskLevel() { return riskLevel; }
    public void setRiskLevel(RiskLevel riskLevel) { this.riskLevel = riskLevel; }
    public String getInvestmentType() { return investmentType; }
    public void setInvestmentType(String investmentType) { this.investmentType = investmentType; }
    public String getAssignedAdvisor() { return assignedAdvisor; }
    public void setAssignedAdvisor(String assignedAdvisor) { this.assignedAdvisor = assignedAdvisor; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public Boolean getApproved() { return approved; }
    public void setApproved(Boolean approved) { this.approved = approved; }
    
    /**
     * String representation for investment proposal logging and debugging
     * Spring Boot: ToString method for investment data presentation and audit trails
     * Supports investment audit trails and debugging workflows for investment operations
     * Enables clear investment proposal data visualization and logging
     */
    @Override
    public String toString() {
        // Spring Boot: Format investment proposal data for logging and presentation
        // Provides readable investment proposal information for debugging and monitoring
        return String.format("InvestmentProposal{id=%d, reference='%s', client='%s', amount=%s, return=%s%%, risk=%s, approved=%s}",
                id, proposalReference, clientName, investmentAmount, expectedReturn, riskLevel, approved);
    }
}

/**
 * Risk Level Enum for Investment Categorization
 * Spring Boot: Enum for investment risk classification and portfolio management
 * Supports investment portfolio management and risk assessment workflows
 * Enables investment risk-based analysis and regulatory compliance
 */
enum RiskLevel {
    LOW,      // Conservative investment strategies with minimal risk
    MEDIUM,   // Balanced investment approaches with moderate risk
    HIGH      // Aggressive investment opportunities with elevated risk
}
```

## src/main/java/com/investment/proposal/repository/InvestmentProposalRepository.java
```java
package com.investment.proposal.repository;

import com.investment.proposal.entity.InvestmentProposal;
import com.investment.proposal.entity.RiskLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

/**
 * Investment Proposal Repository for Database Operations
 * Spring Boot: JPA Repository with custom investment queries and data access
 * This interface provides investment data access layer with optimized database operations
 * and supports investment portfolio analysis and reporting requirements
 */
@Repository  // Spring Boot: Repository component annotation for data access layer
             // Registers this interface as a managed Spring Data repository component
public interface InvestmentProposalRepository extends JpaRepository<InvestmentProposal, Long> {
    
    /**
     * Find investment proposals by client name with case-insensitive search
     * Spring Boot: Query method with parameter binding for investment client queries
     * Enables investment portfolio management by client relationship and name search
     * Supports investment client service and relationship management workflows
     * 
     * @param clientName Client name for investment proposal search and filtering
     *                   Supports partial and case-insensitive client name matching
     * @return List of investment proposals for specified client name
     *         Provides investment portfolio data for client relationship management
     */
    List<InvestmentProposal> findByClientNameContainingIgnoreCase(String clientName);  // Spring Boot: Query derivation
    
    /**
     * Find investment proposals by risk level for portfolio analysis
     * Spring Boot: Query method for investment risk-based categorization and analysis
     * Supports investment risk-based portfolio allocation and management strategies
     * Enables investment compliance and regulatory risk assessment workflows
     * 
     * @param riskLevel Risk level for investment proposal filtering and categorization
     *                  Supports investment risk-based portfolio analysis and management
     * @return List of investment proposals with specified risk level classification
     *         Provides investment data for risk-based portfolio management
     */
    List<InvestmentProposal> findByRiskLevel(RiskLevel riskLevel);  // Spring Boot: Enum-based querying
    
    /**
     * Find investment proposals by approval status for workflow management
     * Spring Boot: Query method for investment workflow management and tracking
     * Enables investment proposal tracking and processing workflows
     * Supports investment compliance and regulatory approval processes
     * 
     * @param approved Approval status for investment proposal filtering and tracking
     *                 Supports investment workflow management and status monitoring
     * @return List of investment proposals with specified approval status
     *         Provides investment data for workflow management and tracking
     */
    List<InvestmentProposal> findByApproved(Boolean approved);  // Spring Boot: Boolean-based filtering
    
    /**
     * Find investment proposals by investment type and minimum amount for analysis
     * Spring Boot: Custom JPQL query with multiple parameters for investment filtering
     * Supports investment portfolio analysis and targeted investment searches
     * Enables investment diversification and asset allocation analysis workflows
     * 
     * @param type Investment type for portfolio categorization and analysis
     *             Supports investment type-based portfolio management and reporting
     * @param minAmount Minimum investment amount for value-based filtering
     *                  Enables investment portfolio analysis by investment value ranges
     * @return List of investment proposals matching type and minimum amount criteria
     *         Provides targeted investment data for portfolio analysis and management
     */
    @Query("SELECT ip FROM InvestmentProposal ip WHERE ip.investmentType = :type AND ip.investmentAmount >= :minAmount")
    List<InvestmentProposal> findByInvestmentTypeAndMinAmount(
            @Param("type") String type,  // Spring Boot: Named parameter binding for investment type
            @Param("minAmount") BigDecimal minAmount);  // Spring Boot: Named parameter binding for minimum amount
    
    /**
     * Find high-value investment proposals for premium client analysis
     * Spring Boot: Native SQL query for complex investment filtering and analysis
     * Enables investment portfolio analysis for premium clients and high-value investments
     * Supports investment client segmentation and premium service workflows
     * 
     * @param thresholdAmount Threshold amount for high-value investment identification
     *                        Enables investment portfolio analysis by value thresholds
     * @return List of investment proposals exceeding specified value threshold
     *         Provides high-value investment data for premium client management
     */
    @Query(value = "SELECT * FROM investment_proposals WHERE investment_amount > ?1 ORDER BY investment_amount DESC", nativeQuery = true)
    List<InvestmentProposal> findHighValueInvestments(BigDecimal thresholdAmount);  // Spring Boot: Native query execution
    
    /**
     * Find investment proposals by advisor for performance tracking
     * Spring Boot: Query method for investment advisor performance analysis
     * Supports investment advisor performance tracking and client relationship management
     * Enables investment service quality monitoring and advisor assignment optimization
     * 
     * @param advisorName Advisor name for investment proposal filtering and analysis
     *                    Supports investment advisor performance tracking and management
     * @return List of investment proposals assigned to specified advisor
     *         Provides advisor-specific investment data for performance analysis
     */
    List<InvestmentProposal> findByAssignedAdvisor(String advisorName);
    
    /**
     * Find investment proposals with pagination for large portfolio management
     * Spring Boot: Query method with pagination for large investment portfolio handling
     * Supports efficient investment portfolio management and large data set processing
     * Enables investment system scalability and performance optimization
     * 
     * @param pageable Pagination information for investment proposal retrieval
     *                 Supports efficient investment data retrieval and display
     * @return Page of investment proposals with pagination metadata
     *         Provides paginated investment data for efficient portfolio management
     */
    Page<InvestmentProposal> findAll(Pageable pageable);
    
    /**
     * Count investment proposals by risk level for portfolio statistics
     * Spring Boot: Query method for investment portfolio statistical analysis
     * Supports investment portfolio analysis and reporting requirements
     * Enables investment risk assessment and regulatory compliance reporting
     * 
     * @param riskLevel Risk level for investment proposal counting and analysis
     *                  Supports investment risk-based statistical analysis
     * @return Count of investment proposals with specified risk level
     *         Provides statistical data for investment portfolio analysis
     */
    long countByRiskLevel(RiskLevel riskLevel);
}
```

## src/main/java/com/investment/proposal/service/InvestmentProposalService.java
```java
package com.investment.proposal.service;

import com.investment.proposal.config.InvestmentConfig;
import com.investment.proposal.entity.InvestmentProposal;
import com.investment.proposal.entity.RiskLevel;
import com.investment.proposal.exception.InvestmentProposalNotFoundException;
import com.investment.proposal.repository.InvestmentProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Investment Proposal Service for Business Logic Implementation
 * Spring Boot: Service layer with transaction management and business rules
 * This class implements investment business rules and processing workflows
 * and supports investment risk management and compliance requirements
 */
@Service  // Spring Boot: Service component annotation for business logic layer
          // Registers this class as a managed Spring service component
@Transactional  // Spring Boot: Transaction management for investment operations
                // Ensures data consistency and integrity for investment operations
public class InvestmentProposalService {
    
    /**
     * Investment proposal repository for data access operations
     * Spring Boot: Dependency injection for investment data operations
     * Enables investment service layer data access and manipulation capabilities
     * Supports investment business logic with efficient data operations
     */
    @Autowired  // Spring Boot: Automatic dependency injection for investment repository
                // Injects InvestmentProposalRepository for investment data access
    private InvestmentProposalRepository investmentProposalRepository;
    
    /**
     * Investment management properties for configuration access
     * Spring Boot: Configuration injection for investment business settings
     * Supports externalized investment business rules and system limits
     * Enables investment service customization and configuration management
     */
    @Autowired  // Spring Boot: Configuration properties injection for investment settings
                // Injects InvestmentManagementProperties for investment configuration access
    private InvestmentConfig.InvestmentManagementProperties investmentProperties;
    
    /**
     * Application event publisher for investment workflow notifications
     * Spring Boot: Event publishing for investment workflow notifications
     * Enables investment system integration and monitoring capabilities
     * Supports investment audit trails and real-time processing workflows
     */
    @Autowired  // Spring Boot: Event publisher injection for investment events
                // Injects ApplicationEventPublisher for investment event publishing
    private ApplicationEventPublisher eventPublisher;
    
    /**
     * Investment async service for background processing operations
     * Spring Boot: Async service injection for investment background operations
     * Enables investment service scalability and performance optimization
     * Supports investment workflow parallelization and efficiency improvements
     */
    @Autowired  // Spring Boot: Async service injection for investment background processing
                // Injects InvestmentAsyncService for investment async operations
    private InvestmentAsyncService investmentAsyncService;
    
    /**
     * Create new investment proposal with validation and business rules
     * Spring Boot: Service method with business logic validation and processing
     * Implements investment proposal creation workflow with risk controls
     * Supports investment compliance and regulatory requirements
     * 
     * @param proposal Investment proposal data for creation and validation
     *                 Contains investment proposal information for processing
     * @return Created investment proposal with generated ID and timestamps
     *         Provides confirmed investment proposal data for portfolio management
     * @throws IllegalArgumentException if investment amount exceeds system limits
     *                                  Ensures investment risk management compliance
     */
    @Transactional  // Spring Boot: Transaction boundary for investment proposal creation
                    // Ensures data consistency during investment proposal creation process
    @CacheEvict(value = "investmentProposals", allEntries = true)  // Spring Boot: Cache eviction for investment data refresh
                                                                   // Clears investment proposal cache to reflect new data
    public InvestmentProposal createInvestmentProposal(@Valid InvestmentProposal proposal) {
        // Spring Boot: Validate investment amount against system limits for risk management
        // Prevents investment proposals that exceed maximum allowed investment amounts
        if (proposal.getInvestmentAmount().compareTo(investmentProperties.getMaxInvestmentAmount()) > 0) {
            // Spring Boot: Throw exception for investment amount exceeding system limits
            // Ensures investment risk management and regulatory compliance
            throw new IllegalArgumentException("Investment amount exceeds maximum allowed limit of " + 
                                             investmentProperties.getMaxInvestmentAmount());
        }
        
        // Spring Boot: Save investment proposal to database with transaction management
        // Persists investment proposal data with automatic ID generation and timestamps
        InvestmentProposal savedProposal = investmentProposalRepository.save(proposal);
        
        // Spring Boot: Publish investment proposal creation event for system integration
        // Enables investment workflow notifications and audit trail maintenance
        eventPublisher.publishEvent(new com.investment.proposal.event.InvestmentProposalCreatedEvent(savedProposal));
        
        // Spring Boot: Perform async investment risk assessment for background processing
        // Enables investment system scalability and performance optimization
        investmentAsyncService.performInvestmentRiskAssessment(savedProposal);
        
        // Spring Boot: Return created investment proposal with confirmed data
        // Provides successful investment proposal creation confirmation
        return savedProposal;
    }
    
    /**
     * Get all investment proposals with caching for performance optimization
     * Spring Boot: Cached method for investment data retrieval and performance
     * Improves investment portfolio analysis performance and system responsiveness
     * Supports investment portfolio management and reporting efficiency
     * 
     * @return List of all investment proposals with caching optimization
     *         Provides efficient investment portfolio data for management and analysis
     */
    @Cacheable("investmentProposals")  // Spring Boot: Caching annotation for investment data performance
                                       // Caches investment proposal data to improve retrieval performance
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for investment data retrieval
                                     // Optimizes database access for investment portfolio analysis
    public List<InvestmentProposal> getAllInvestmentProposals() {
        // Spring Boot: Retrieve all investment proposals from database with caching
        // Provides efficient investment portfolio data for management and analysis
        return investmentProposalRepository.findAll();
    }
    
    /**
     * Get investment proposal by ID with exception handling and validation
     * Spring Boot: Service method with error handling and data validation
     * Provides safe investment data retrieval with proper error management
     * Supports investment audit trails and compliance requirements
     * 
     * @param id Investment proposal ID for data retrieval and validation
     *           Unique identifier for specific investment proposal access
     * @return Investment proposal data for specified ID with validation
     *         Provides confirmed investment proposal data for portfolio management
     * @throws InvestmentProposalNotFoundException if investment proposal not found
     *                                            Ensures proper error handling for missing data
     */
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for investment data retrieval
                                     // Optimizes database access for investment proposal access
    public InvestmentProposal getInvestmentProposalById(Long id) {
        // Spring Boot: Retrieve investment proposal by ID with exception handling
        // Provides safe investment data retrieval with proper error management
        return investmentProposalRepository.findById(id)
                .orElseThrow(() -> new InvestmentProposalNotFoundException("Investment proposal not found with ID: " + id));
    }
    
    /**
     * Update investment proposal approval status with audit trail management
     * Spring Boot: Transactional method for investment workflow updates and tracking
     * Implements investment approval processing with audit trails and compliance
     * Supports investment regulatory requirements and status monitoring
     * 
     * @param id Investment proposal ID for approval status update
     *           Unique identifier for investment proposal status modification
     * @param approved New approval status for investment proposal processing
     *                 Boolean value indicating investment proposal approval state
     * @return Updated investment proposal with new approval status and audit trail
     *         Provides confirmed investment proposal data with updated status
     * @throws InvestmentProposalNotFoundException if investment proposal not found
     *                                            Ensures proper error handling for missing data
     */
    @Transactional  // Spring Boot: Transaction boundary for investment approval status updates
                    // Ensures data consistency during investment approval processing
    @CacheEvict(value = "investmentProposals", allEntries = true)  // Spring Boot: Cache eviction for investment data refresh
                                                                   // Clears investment proposal cache to reflect status changes
    public InvestmentProposal updateApprovalStatus(Long id, Boolean approved) {
        // Spring Boot: Retrieve investment proposal by ID with validation
        // Ensures investment proposal exists before status update processing
        InvestmentProposal proposal = getInvestmentProposalById(id);
        
        // Spring Boot: Update investment proposal approval status with audit trail
        // Maintains investment proposal status history and compliance records
        proposal.setApproved(approved);
        
        // Spring Boot: Save updated investment proposal with transaction management
        // Persists investment proposal status changes with data consistency
        InvestmentProposal updatedProposal = investmentProposalRepository.save(proposal);
        
        // Spring Boot: Publish investment approval status change event for system integration
        // Enables investment workflow notifications and audit trail maintenance
        eventPublisher.publishEvent(new com.investment.proposal.event.InvestmentProposalStatusChangedEvent(updatedProposal));
        
        // Spring Boot: Send investment notification for client communication
        // Enables investment client service and status communication workflows
        investmentAsyncService.sendInvestmentNotification(updatedProposal);
        
        // Spring Boot: Return updated investment proposal with confirmed status
        // Provides successful investment approval status update confirmation
        return updatedProposal;
    }
    
    /**
     * Delete investment proposal with cascade operations and audit trail
     * Spring Boot: Service method for investment data cleanup and compliance
     * Ensures proper investment data management and regulatory compliance
     * Supports investment audit trails and data governance requirements
     * 
     * @param id Investment proposal ID for data removal and cleanup
     *           Unique identifier for investment proposal deletion processing
     * @throws InvestmentProposalNotFoundException if investment proposal not found
     *                                            Ensures proper error handling for missing data
     */
    @Transactional  // Spring Boot: Transaction boundary for investment proposal deletion
                    // Ensures data consistency during investment data removal process
    @CacheEvict(value = "investmentProposals", allEntries = true)  // Spring Boot: Cache eviction for investment data cleanup
                                                                   // Clears investment proposal cache to reflect data removal
    public void deleteInvestmentProposal(Long id) {
        // Spring Boot: Retrieve investment proposal by ID with validation
        // Ensures investment proposal exists before deletion processing
        InvestmentProposal proposal = getInvestmentProposalById(id);
        
        // Spring Boot: Delete investment proposal from database with transaction management
        // Removes investment proposal data with proper cascade operations
        investmentProposalRepository.delete(proposal);
        
        // Spring Boot: Publish investment proposal deletion event for system integration
        // Enables investment workflow notifications and audit trail maintenance
        eventPublisher.publishEvent(new com.investment.proposal.event.InvestmentProposalDeletedEvent(proposal));
    }
    
    /**
     * Find investment proposals by client with performance optimization
     * Spring Boot: Service method with optimized data retrieval and filtering
     * Supports investment client relationship management and portfolio analysis
     * Enables investment service personalization and client-specific reporting
     * 
     * @param clientName Client name for investment proposal filtering and retrieval
     *                   Supports investment portfolio management by client relationship
     * @return List of investment proposals for specified client with optimization
     *         Provides efficient client-specific investment data for portfolio management
     */
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for investment client data retrieval
                                     // Optimizes database access for investment client portfolio analysis
    public List<InvestmentProposal> getInvestmentProposalsByClient(String clientName) {
        // Spring Boot: Retrieve investment proposals by client with case-insensitive search
        // Provides flexible investment client portfolio data retrieval and management
        return investmentProposalRepository.findByClientNameContainingIgnoreCase(clientName);
    }
    
    /**
     * Get investment portfolio summary by risk level for analysis and reporting
     * Spring Boot: Service method with investment analytics and statistical processing
     * Provides investment portfolio analysis and reporting capabilities
     * Supports investment risk management and regulatory compliance reporting
     * 
     * @return Map of risk levels with corresponding investment proposal counts
     *         Provides statistical data for investment portfolio risk analysis
     */
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for investment portfolio analysis
                                     // Optimizes database access for investment statistical processing
    public Map<RiskLevel, Long> getPortfolioSummaryByRiskLevel() {
        // Spring Boot: Stream through risk levels and count investment proposals for each
        // Provides comprehensive investment portfolio risk level analysis and statistics
        return java.util.Arrays.stream(RiskLevel.values())
                .collect(Collectors.toMap(
                        riskLevel -> riskLevel,  // Spring Boot: Risk level key mapping for investment statistics
                        riskLevel -> investmentProposalRepository.countByRiskLevel(riskLevel)  // Spring Boot: Count retrieval for risk level
                ));
    }
    
    /**
     * Get investment proposals with pagination for large portfolio management
     * Spring Boot: Service method with pagination for large investment portfolio handling
     * Supports efficient investment portfolio management and large data set processing
     * Enables investment system scalability and performance optimization
     * 
     * @param pageable Pagination information for investment proposal retrieval
     *                 Supports efficient investment data retrieval and display
     * @return Page of investment proposals with pagination metadata and optimization
     *         Provides paginated investment data for efficient portfolio management
     */
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for investment pagination retrieval
                                     // Optimizes database access for investment portfolio pagination
    public Page<InvestmentProposal> getInvestmentProposalsPaginated(Pageable pageable) {
        // Spring Boot: Retrieve investment proposals with pagination for efficient processing
        // Provides scalable investment portfolio data retrieval for large datasets
        return investmentProposalRepository.findAll(pageable);
    }
    
    /**
     * Get high-value investment proposals for premium client analysis
     * Spring Boot: Service method with value-based filtering for investment analysis
     * Enables investment portfolio analysis for premium clients and high-value investments
     * Supports investment client segmentation and premium service workflows
     * 
     * @param thresholdAmount Threshold amount for high-value investment identification
     *                        Enables investment portfolio analysis by value thresholds
     * @return List of high-value investment proposals for premium client management
     *         Provides high-value investment data for premium client analysis
     */
    @Transactional(readOnly = true)  // Spring Boot: Read-only transaction for high-value investment retrieval
                                     // Optimizes database access for investment value-based analysis
    public List<InvestmentProposal> getHighValueInvestments(BigDecimal thresholdAmount) {
        // Spring Boot: Retrieve high-value investment proposals with native query optimization
        // Provides efficient high-value investment data for premium client management
        return investmentProposalRepository.findHighValueInvestments(thresholdAmount);
    }
}
```

## src/main/java/com/investment/proposal/service/InvestmentAsyncService.java
```java
package com.investment.proposal.service;

import com.investment.proposal.entity.InvestmentProposal;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Investment Async Service for Background Processing Operations
 * Spring Boot: Async service for investment background operations and scalability
 * This class implements investment system scalability and performance optimization
 * and supports investment workflow parallelization and efficiency improvements
 */
@Service  // Spring Boot: Service component annotation for async investment operations
          // Registers this class as a managed Spring async service component
public class InvestmentAsyncService {
    
    /**
     * Async method for investment risk assessment with background processing
     * Spring Boot: Async method execution for investment processing and scalability
     * Implements investment system scalability and performance optimization
     * Supports investment workflow parallelization and efficiency improvements
     * 
     * @param proposal Investment proposal for risk assessment processing
     *                 Contains investment proposal information for risk analysis
     * @return CompletableFuture with risk assessment result for investment processing
     *         Provides async investment risk assessment completion status
     */
    @Async  // Spring Boot: Async method annotation for background investment processing
            // Enables investment risk assessment to run concurrently without blocking
    public CompletableFuture<String> performInvestmentRiskAssessment(InvestmentProposal proposal) {
        try {
            // Spring Boot: Simulate investment risk assessment processing with delay
            // Represents actual investment risk analysis and evaluation workflows
            Thread.sleep(5000);  // Spring Boot: Simulated processing time for investment risk assessment
            
            // Spring Boot: Log successful investment risk assessment completion
            // Provides investment system monitoring and processing status information
            System.out.println("Investment risk assessment completed for: " + proposal.getProposalReference());
            
            // Spring Boot: Return successful risk assessment completion result
            // Provides async investment risk assessment success confirmation
            return CompletableFuture.completedFuture("Risk assessment completed successfully for proposal: " + 
                                                   proposal.getProposalReference());
        } catch (InterruptedException e) {
            // Spring Boot: Handle investment risk assessment interruption gracefully
            // Ensures proper thread management and error handling for investment processing
            Thread.currentThread().interrupt();  // Spring Boot: Restore interrupted status for investment processing
            
            // Spring Boot: Return failed risk assessment result with error information
            // Provides async investment risk assessment failure confirmation
            return CompletableFuture.completedFuture("Risk assessment failed for proposal: " + 
                                                   proposal.getProposalReference() + " - " + e.getMessage());
        }
    }
    
    /**
     * Async method for investment portfolio notification with client communication
     * Spring Boot: Async method for investment communication and client service
     * Implements investment system scalability and client notification workflows
     * Supports investment client service and communication efficiency improvements
     * 
     * @param proposal Investment proposal for client notification processing
     *                 Contains investment proposal information for client communication
     * @return CompletableFuture with notification result for investment communication
     *         Provides async investment notification completion status
     */
    @Async  // Spring Boot: Async method for investment client notifications
            // Enables investment notifications to run concurrently without blocking
    public CompletableFuture<String> sendInvestmentNotification(InvestmentProposal proposal) {
        try {
            // Spring Boot: Simulate investment notification processing with delay
            // Represents actual investment client notification and communication workflows
            Thread.sleep(2000);  // Spring Boot: Simulated notification time for investment client communication
            
            // Spring Boot: Log successful investment notification completion
            // Provides investment system monitoring and communication status information
            System.out.println("Investment notification sent to client: " + proposal.getClientName());
            
            // Spring Boot: Return successful notification completion result
            // Provides async investment notification success confirmation
            return CompletableFuture.completedFuture("Notification sent successfully to client: " + 
                                                   proposal.getClientName());
        } catch (InterruptedException e) {
            // Spring Boot: Handle investment notification interruption gracefully
            // Ensures proper thread management and error handling for investment communication
            Thread.currentThread().interrupt();  // Spring Boot: Restore interrupted status for investment communication
            
            // Spring Boot: Return failed notification result with error information
            // Provides async investment notification failure confirmation
            return CompletableFuture.completedFuture("Notification failed for client: " + 
                                                   proposal.getClientName() + " - " + e.getMessage());
        }
    }
}
```

## src/main/java/com/investment/proposal/controller/InvestmentProposalController.java
```java
package com.investment.proposal.controller;

import com.investment.proposal.entity.InvestmentProposal;
import com.investment.proposal.entity.RiskLevel;
import com.investment.proposal.exception.InvestmentProposalNotFoundException;
import com.investment.proposal.service.InvestmentProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Investment Proposal Controller for REST API Implementation
 * Spring Boot: REST Controller with request mapping and security authorization
 * This class provides investment management API endpoints for client applications
 * and supports investment portfolio management and workflow automation
 */
@RestController  // Spring Boot: REST controller annotation for investment API endpoints
                 // Registers this class as a managed Spring REST controller component
@RequestMapping("/api/investment-proposals")  // Spring Boot: Base URL mapping for investment endpoints
                                             // Defines base path for all investment proposal API endpoints
public class InvestmentProposalController {
    
    /**
     * Investment proposal service for business logic operations
     * Spring Boot: Service injection for investment operations and business logic
     * Enables investment controller to access business functionality and processing
     * Supports investment API endpoint implementation with proper business logic
     */
    @Autowired  // Spring Boot: Service dependency injection for investment operations
                // Injects InvestmentProposalService for investment business logic access
    private InvestmentProposalService investmentProposalService;
    
    /**
     * Get all investment proposals endpoint with security authorization
     * Spring Boot: GET endpoint for investment portfolio retrieval and management
     * Provides investment data access for portfolio management applications
     * Supports investment portfolio analysis and reporting requirements
     * 
     * @return List of all investment proposals with security authorization
     *         Provides investment portfolio data for management and analysis
     */
    @GetMapping  // Spring Boot: HTTP GET mapping for investment portfolio retrieval
                 // Defines endpoint for retrieving all investment proposals
    @PreAuthorize("hasRole('INVESTMENT_VIEWER') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment access
                                                                       // Ensures only authorized users can access investment portfolio data
    public List<InvestmentProposal> getAllInvestmentProposals() {
        // Spring Boot: Delegate to investment service for portfolio retrieval
        // Provides efficient investment portfolio data access with business logic
        return investmentProposalService.getAllInvestmentProposals();
    }
    
    /**
     * Get investment proposal by ID endpoint with security authorization
     * Spring Boot: GET endpoint with path variable for investment access and validation
     * Provides individual investment proposal data retrieval with proper validation
     * Supports investment audit trails and compliance requirements
     * 
     * @param id Investment proposal ID from path variable for data retrieval
     *           Unique identifier for specific investment proposal access
     * @return Investment proposal data for specified ID with validation and security
     *         Provides confirmed investment proposal data for portfolio management
     */
    @GetMapping("/{id}")  // Spring Boot: Path variable mapping for investment ID access
                          // Defines endpoint for retrieving specific investment proposal by ID
    @PreAuthorize("hasRole('INVESTMENT_VIEWER') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment access
                                                                       // Ensures only authorized users can access investment proposal data
    public InvestmentProposal getInvestmentProposal(@PathVariable Long id) {
        // Spring Boot: Delegate to investment service for proposal retrieval
        // Provides safe investment data retrieval with proper error handling
        return investmentProposalService.getInvestmentProposalById(id);
    }
    
    /**
     * Create new investment proposal endpoint with validation and security
     * Spring Boot: POST endpoint for investment proposal creation and validation
     * Implements investment proposal submission workflow with proper validation
     * Supports investment compliance and regulatory requirements
     * 
     * @param proposal Investment proposal data from request body for creation
     *                 Contains investment proposal information for processing
     * @return Created investment proposal with generated ID and security validation
     *         Provides confirmed investment proposal data for portfolio management
     */
    @PostMapping  // Spring Boot: HTTP POST mapping for investment proposal creation
                  // Defines endpoint for creating new investment proposals
    @PreAuthorize("hasRole('INVESTMENT_CREATOR') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment creation
                                                                        // Ensures only authorized users can create investment proposals
    public InvestmentProposal createInvestmentProposal(@Valid @RequestBody InvestmentProposal proposal) {
        // Spring Boot: Delegate to investment service for proposal creation
        // Implements investment proposal creation workflow with proper validation
        return investmentProposalService.createInvestmentProposal(proposal);
    }
    
    /**
     * Update investment proposal approval status endpoint with security
     * Spring Boot: PUT endpoint for investment workflow updates and status management
     * Implements investment approval processing with status management and tracking
     * Supports investment regulatory requirements and compliance workflows
     * 
     * @param id Investment proposal ID from path variable for status update
     *           Unique identifier for investment proposal status modification
     * @param approved New approval status from request parameter for processing
     *                 Boolean value indicating investment proposal approval state
     * @return Updated investment proposal with new approval status and security
     *         Provides confirmed investment proposal data with updated status
     */
    @PutMapping("/{id}/approve")  // Spring Boot: Path variable and request parameter mapping
                                   // Defines endpoint for updating investment proposal approval status
    @PreAuthorize("hasRole('INVESTMENT_APPROVER') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment approval
                                                                         // Ensures only authorized users can approve investment proposals
    public InvestmentProposal updateApprovalStatus(@PathVariable Long id, @RequestParam Boolean approved) {
        // Spring Boot: Delegate to investment service for approval status update
        // Implements investment approval processing with proper audit trails
        return investmentProposalService.updateApprovalStatus(id, approved);
    }
    
    /**
     * Delete investment proposal endpoint with security and compliance
     * Spring Boot: DELETE endpoint for investment data removal and cleanup
     * Implements investment proposal deletion workflow with compliance requirements
     * Supports investment audit trails and data governance requirements
     * 
     * @param id Investment proposal ID from path variable for data removal
     *           Unique identifier for investment proposal deletion processing
     * @return ResponseEntity with HTTP 204 for successful deletion and security
     *         Provides confirmation of successful investment proposal deletion
     */
    @DeleteMapping("/{id}")  // Spring Boot: HTTP DELETE mapping for investment removal
                             // Defines endpoint for deleting investment proposals
    @PreAuthorize("hasRole('INVESTMENT_ADMIN') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment administration
                                                                      // Ensures only authorized administrators can delete investment proposals
    public ResponseEntity<Void> deleteInvestmentProposal(@PathVariable Long id) {
        // Spring Boot: Delegate to investment service for proposal deletion
        // Implements investment proposal deletion workflow with proper cleanup
        investmentProposalService.deleteInvestmentProposal(id);
        
        // Spring Boot: Return HTTP 204 response for successful deletion
        // Provides standard HTTP response for successful investment data removal
        return ResponseEntity.noContent().build();  // Spring Boot: HTTP 204 response for successful deletion
    }
    
    /**
     * Get investment proposals by client endpoint with security authorization
     * Spring Boot: GET endpoint with request parameter for investment filtering
     * Supports investment portfolio management by client relationship and search
     * Enables investment client service and relationship management workflows
     * 
     * @param clientName Client name from path variable for investment filtering
     *                   Supports investment portfolio management by client relationship
     * @return List of investment proposals for specified client with security
     *         Provides client-specific investment data for portfolio management
     */
    @GetMapping("/client/{clientName}")  // Spring Boot: Client name path variable mapping
                                          // Defines endpoint for retrieving investment proposals by client
    @PreAuthorize("hasRole('INVESTMENT_VIEWER') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment access
                                                                       // Ensures only authorized users can access client investment data
    public List<InvestmentProposal> getInvestmentProposalsByClient(@PathVariable String clientName) {
        // Spring Boot: Delegate to investment service for client-specific retrieval
        // Provides efficient investment portfolio data access by client relationship
        return investmentProposalService.getInvestmentProposalsByClient(clientName);
    }
    
    /**
     * Get portfolio summary by risk level endpoint with security authorization
     * Spring Boot: GET endpoint for investment analytics and statistical reporting
     * Provides investment portfolio analysis and reporting data for management
     * Supports investment risk management and regulatory compliance reporting
     * 
     * @return Map of risk levels with corresponding investment proposal counts
     *         Provides statistical data for investment portfolio risk analysis
     */
    @GetMapping("/portfolio/summary")  // Spring Boot: Portfolio summary endpoint mapping
                                       // Defines endpoint for retrieving investment portfolio summary
    @PreAuthorize("hasRole('INVESTMENT_ANALYST') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment analysis
                                                                        // Ensures only authorized analysts can access portfolio analysis data
    public Map<RiskLevel, Long> getPortfolioSummary() {
        // Spring Boot: Delegate to investment service for portfolio summary retrieval
        // Provides investment portfolio analysis and statistical reporting data
        return investmentProposalService.getPortfolioSummaryByRiskLevel();
    }
    
    /**
     * Get investment proposals with pagination endpoint for large portfolios
     * Spring Boot: GET endpoint with pagination for large investment portfolio handling
     * Supports efficient investment portfolio management and large data set processing
     * Enables investment system scalability and performance optimization
     * 
     * @param page Page number from request parameter for pagination
     *             Supports efficient investment data retrieval and display
     * @param size Page size from request parameter for pagination control
     *             Enables investment portfolio data display customization
     * @return Page of investment proposals with pagination metadata and security
     *         Provides paginated investment data for efficient portfolio management
     */
    @GetMapping("/paginated")  // Spring Boot: Paginated endpoint mapping for investment retrieval
                               // Defines endpoint for retrieving investment proposals with pagination
    @PreAuthorize("hasRole('INVESTMENT_VIEWER') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment access
                                                                       // Ensures only authorized users can access paginated investment data
    public Page<InvestmentProposal> getInvestmentProposalsPaginated(
            @RequestParam(defaultValue = "0") int page,  // Spring Boot: Page number parameter with default value
            @RequestParam(defaultValue = "10") int size) {  // Spring Boot: Page size parameter with default value
        // Spring Boot: Create pageable object for investment proposal retrieval
        // Supports efficient investment portfolio data retrieval with pagination
        Pageable pageable = PageRequest.of(page, size);
        
        // Spring Boot: Delegate to investment service for paginated retrieval
        // Provides scalable investment portfolio data retrieval for large datasets
        return investmentProposalService.getInvestmentProposalsPaginated(pageable);
    }
    
    /**
     * Get high-value investment proposals endpoint for premium client analysis
     * Spring Boot: GET endpoint with value-based filtering for investment analysis
     * Enables investment portfolio analysis for premium clients and high-value investments
     * Supports investment client segmentation and premium service workflows
     * 
     * @param threshold Threshold amount from request parameter for value filtering
     *                  Enables investment portfolio analysis by value thresholds
     * @return List of high-value investment proposals for premium client management
     *         Provides high-value investment data for premium client analysis
     */
    @GetMapping("/high-value")  // Spring Boot: High-value endpoint mapping for investment retrieval
                                // Defines endpoint for retrieving high-value investment proposals
    @PreAuthorize("hasRole('INVESTMENT_ANALYST') or hasRole('ADMIN')")  // Spring Boot: Security authorization for investment analysis
                                                                        // Ensures only authorized analysts can access high-value investment data
    public List<InvestmentProposal> getHighValueInvestments(
            @RequestParam(defaultValue = "100000.00") BigDecimal threshold) {  // Spring Boot: Threshold parameter with default value
        // Spring Boot: Delegate to investment service for high-value investment retrieval
        // Provides efficient high-value investment data for premium client management
        return investmentProposalService.getHighValueInvestments(threshold);
    }
}
```

## src/main/java/com/investment/proposal/controller/HomeController.java
```java
package com.investment.proposal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller for Investment Management Web Interface
 * Spring Boot: Controller for investment management web pages and templates
 * This class provides investment management UI endpoints for web interface
 * and supports investment portfolio management and user interaction
 */
@Controller  // Spring Boot: Controller annotation for investment web interface
             // Registers this class as a managed Spring MVC controller component
public class HomeController {
    
    /**
     * Home page endpoint for investment management web interface
     * Spring Boot: GET endpoint for investment management home page display
     * Provides investment management dashboard and navigation interface
     * Supports investment user interaction and portfolio management workflows
     * 
     * @param model Model object for view data binding and template rendering
     *              Provides data binding capabilities for investment web interface
     * @return View name for investment management home page template
     *         Provides investment management dashboard for user interaction
     */
    @GetMapping("/")  // Spring Boot: HTTP GET mapping for investment home page
                      // Defines endpoint for investment management dashboard access
    public String home(Model model) {
        // Spring Boot: Add attributes to model for home page template rendering
        // Provides data binding for investment management dashboard display
        model.addAttribute("title", "Investment Proposal Management System");
        model.addAttribute("description", "Manage investment proposals and portfolio analysis");
        
        // Spring Boot: Return view name for investment management home page
        // Provides investment management dashboard template for user interaction
        return "index";
    }
    
    /**
     * Investment proposals page endpoint for investment portfolio management
     * Spring Boot: GET endpoint for investment proposals management interface
     * Provides investment portfolio management and proposal listing interface
     * Supports investment user interaction and portfolio analysis workflows
     * 
     * @param model Model object for view data binding and template rendering
     *              Provides data binding capabilities for investment proposals interface
     * @return View name for investment proposals management page template
     *         Provides investment portfolio management interface for user interaction
     */
    @GetMapping("/proposals")  // Spring Boot: HTTP GET mapping for investment proposals page
                               // Defines endpoint for investment portfolio management access
    public String proposals(Model model) {
        // Spring Boot: Add attributes to model for proposals page template rendering
        // Provides data binding for investment portfolio management display
        model.addAttribute("title", "Investment Proposals");
        model.addAttribute("description", "View and manage investment proposals");
        
        // Spring Boot: Return view name for investment proposals management page
        // Provides investment portfolio management template for user interaction
        return "proposals";
    }
}
```

## src/main/java/com/investment/proposal/dto/InvestmentProposalDTO.java
```java
package com.investment.proposal.dto;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * Investment Proposal Data Transfer Object for API Communication
 * Spring Boot: DTO for investment proposal data transfer and validation
 * This class provides investment proposal data transfer and validation capabilities
 * and supports investment API communication and client interaction
 */
public class InvestmentProposalDTO {
    
    /**
     * Investment proposal reference number for tracking and identification
     * Spring Boot: DTO field for investment reference with validation constraints
     * Supports investment proposal identification and status monitoring
     */
    @NotBlank  // Spring Boot: Validation constraint for required investment reference
               // Prevents investment proposals without reference numbers in API communication
    @Size(min = 3, max = 20)  // Spring Boot: String length validation for investment reference
                              // Ensures investment reference numbers have appropriate length
    private String proposalReference;
    
    /**
     * Client name for investment relationship management and communication
     * Spring Boot: DTO field for client name with validation constraints
     * Enables efficient investment portfolio management by client relationship
     */
    @NotBlank  // Spring Boot: Validation constraint for required client information
               // Prevents investment proposals without client names in API communication
    @Size(min = 2, max = 100)  // Spring Boot: String length validation for client names
                               // Ensures client names have appropriate length for investment processing
    private String clientName;
    
    /**
     * Investment amount for portfolio allocation and financial analysis
     * Spring Boot: DTO field for investment amount with validation constraints
     * Ensures accurate investment calculations and reporting requirements
     */
    @DecimalMin(value = "1000.00")  // Spring Boot: Minimum investment validation for risk management
                                    // Prevents unrealistically small investment proposals in API communication
    @DecimalMax(value = "10000000.00")  // Spring Boot: Maximum investment validation for risk control
                                        // Prevents excessively large investment proposals in API communication
    private BigDecimal investmentAmount;
    
    /**
     * Expected return rate for investment performance tracking and analysis
     * Spring Boot: DTO field for expected return with validation constraints
     * Supports investment performance analysis and client reporting requirements
     */
    @DecimalMin(value = "0.0")  // Spring Boot: Non-negative return validation for investment metrics
                                // Prevents negative expected return values in investment proposals
    @DecimalMax(value = "100.0")  // Spring Boot: Realistic return validation for investment proposals
                                  // Prevents unrealistically high expected return values in API communication
    private BigDecimal expectedReturn;
    
    /**
     * Investment risk level for portfolio management and risk assessment
     * Spring Boot: DTO field for risk level with validation constraints
     * Enables investment risk-based portfolio allocation and management strategies
     */
    @NotBlank  // Spring Boot: Validation constraint for required risk level information
               // Prevents investment proposals without risk level classification in API communication
    private String riskLevel;
    
    /**
     * Investment type for asset allocation analysis and portfolio management
     * Spring Boot: DTO field for investment type with validation constraints
     * Supports investment diversification and asset allocation strategies
     */
    @NotBlank  // Spring Boot: Validation constraint for required investment category
               // Prevents investment proposals without investment type information in API communication
    private String investmentType;
    
    /**
     * Assigned investment advisor for client service and accountability
     * Spring Boot: DTO field for advisor assignment with validation constraints
     * Ensures proper investment service delivery and professional accountability
     */
    @NotBlank  // Spring Boot: Validation constraint for required advisor information
               // Prevents investment proposals without advisor assignments in API communication
    private String assignedAdvisor;
    
    // Getters and setters for investment proposal DTO data access
    public String getProposalReference() { return proposalReference; }
    public void setProposalReference(String proposalReference) { this.proposalReference = proposalReference; }
    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }
    public BigDecimal getInvestmentAmount() { return investmentAmount; }
    public void setInvestmentAmount(BigDecimal investmentAmount) { this.investmentAmount = investmentAmount; }
    public BigDecimal getExpectedReturn() { return expectedReturn; }
    public void setExpectedReturn(BigDecimal expectedReturn) { this.expectedReturn = expectedReturn; }
    public String getRiskLevel() { return riskLevel; }
    public void setRiskLevel(String riskLevel) { this.riskLevel = riskLevel; }
    public String getInvestmentType() { return investmentType; }
    public void setInvestmentType(String investmentType) { this.investmentType = investmentType; }
    public String getAssignedAdvisor() { return assignedAdvisor; }
    public void setAssignedAdvisor(String assignedAdvisor) { this.assignedAdvisor = assignedAdvisor; }
}
```

## src/main/java/com/investment/proposal/exception/InvestmentProposalNotFoundException.java
```java
package com.investment.proposal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Investment Proposal Not Found Exception for Error Handling
 * Spring Boot: Custom exception for investment management error scenarios
 * This class provides specific error handling for investment data access failures
 * and supports investment system error reporting and debugging capabilities
 */
@ResponseStatus(HttpStatus.NOT_FOUND)  // Spring Boot: HTTP status mapping for investment errors
                                       // Maps this exception to HTTP 404 status for REST API responses
public class InvestmentProposalNotFoundException extends RuntimeException {
    
    /**
     * Constructor for investment proposal not found exception with message
     * Spring Boot: Custom exception with error message for investment errors
     * Enables specific investment error handling and reporting capabilities
     * Supports investment system error reporting and debugging workflows
     * 
     * @param message Error message for investment proposal not found scenario
     *                Provides detailed error information for debugging and logging
     */
    public InvestmentProposalNotFoundException(String message) {
        // Spring Boot: Call parent constructor with error message for investment exception
        // Initializes investment exception with specific error information
        super(message);
    }
    
    /**
     * Constructor for investment proposal not found exception with message and cause
     * Spring Boot: Custom exception with error message and cause for investment errors
     * Enables specific investment error handling with root cause information
     * Supports investment system error reporting and debugging with full context
     * 
     * @param message Error message for investment proposal not found scenario
     *                Provides detailed error information for debugging and logging
     * @param cause Root cause exception for investment proposal not found error
     *              Provides underlying error information for comprehensive debugging
     */
    public InvestmentProposalNotFoundException(String message, Throwable cause) {
        // Spring Boot: Call parent constructor with message and cause for investment exception
        // Initializes investment exception with error message and root cause information
        super(message, cause);
    }
}
```

## src/main/java/com/investment/proposal/exception/GlobalExceptionHandler.java
```java
package com.investment.proposal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global Exception Handler for Investment Management System
 * Spring Boot: Global exception handler for investment system error management
 * This class provides consistent error handling for investment management operations
 * and supports investment system error reporting and debugging capabilities
 */
@ControllerAdvice  // Spring Boot: Controller advice annotation for global exception handling
                   // Registers this class as a global exception handler for investment system
public class GlobalExceptionHandler {
    
    /**
     * Handle investment proposal not found exceptions with proper error response
     * Spring Boot: Exception handler for investment proposal not found errors
     * Provides consistent error responses for investment management operations
     * Supports investment system error reporting and debugging workflows
     * 
     * @param ex InvestmentProposalNotFoundException for error handling
     *           Specific exception for investment proposal not found scenarios
     * @param request WebRequest for error context and request information
     *                Provides request context for investment error handling
     * @return ResponseEntity with error details and HTTP 404 status
     *         Provides consistent error response for investment proposal not found
     */
    @ExceptionHandler(InvestmentProposalNotFoundException.class)  // Spring Boot: Specific exception handling for investment errors
    public ResponseEntity<Map<String, Object>> handleInvestmentProposalNotFound(
            InvestmentProposalNotFoundException ex, WebRequest request) {
        // Spring Boot: Create error response map for investment proposal not found
        // Provides structured error information for investment system error handling
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.NOT_FOUND.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));
        
        // Spring Boot: Return HTTP 404 response with error details for investment error
        // Provides consistent error response for investment proposal not found scenarios
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    
    /**
     * Handle validation errors with detailed error response for investment data
     * Spring Boot: Exception handler for investment data validation errors
     * Provides detailed validation error responses for investment operations
     * Supports investment system error reporting and data quality management
     * 
     * @param ex ConstraintViolationException for validation error handling
     *           Specific exception for investment data validation failures
     * @param request WebRequest for error context and request information
     *                Provides request context for investment validation error handling
     * @return ResponseEntity with validation error details and HTTP 400 status
     *         Provides detailed validation error response for investment data issues
     */
    @ExceptionHandler(ConstraintViolationException.class)  // Spring Boot: Validation exception handling for investment errors
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            ConstraintViolationException ex, WebRequest request) {
        // Spring Boot: Create error response map for investment validation errors
        // Provides structured validation error information for investment system
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "Investment proposal validation failed");
        errorResponse.put("details", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));
        
        // Spring Boot: Return HTTP 400 response with validation error details
        // Provides detailed validation error response for investment data issues
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    
    /**
     * Handle generic exceptions with proper error response for investment system
     * Spring Boot: Exception handler for generic investment system errors
     * Provides consistent error responses for unexpected investment system issues
     * Supports investment system reliability and error recovery workflows
     * 
     * @param ex Exception for generic error handling in investment system
     *           General exception for unexpected investment system errors
     * @param request WebRequest for error context and request information
     *                Provides request context for investment system error handling
     * @return ResponseEntity with error details and HTTP 500 status
     *         Provides consistent error response for investment system failures
     */
    @ExceptionHandler(Exception.class)  // Spring Boot: Generic exception handling for investment system
    public ResponseEntity<Map<String, Object>> handleGenericException(
            Exception ex, WebRequest request) {
        // Spring Boot: Create error response map for generic investment system errors
        // Provides structured error information for unexpected investment system issues
        Map<String, Object> errorResponse = new HashMap<>();
        errorResponse.put("error", "An unexpected error occurred in investment system");
        errorResponse.put("details", ex.getMessage());
        errorResponse.put("timestamp", LocalDateTime.now());
        errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorResponse.put("path", request.getDescription(false).replace("uri=", ""));
        
        // Spring Boot: Return HTTP 500 response with error details for investment system failure
        // Provides consistent error response for unexpected investment system issues
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
```

## src/main/java/com/investment/proposal/event/InvestmentProposalCreatedEvent.java
```java
package com.investment.proposal.event;

import com.investment.proposal.entity.InvestmentProposal;

/**
 * Investment Proposal Created Event for System Integration
 * Spring Boot: Application event for investment workflow notifications
 * This class enables investment system integration and monitoring capabilities
 * and supports investment audit trails and compliance reporting requirements
 */
public class InvestmentProposalCreatedEvent {
    /**
     * Investment proposal associated with creation event for system integration
     * Spring Boot: Event data for investment proposal creation notification
     * Enables investment workflow notifications and audit trail maintenance
     */
    private final InvestmentProposal proposal;
    
    /**
     * Constructor for investment proposal created event with proposal data
     * Spring Boot: Event constructor with investment proposal information
     * Initializes investment event with specific proposal data for notification
     * 
     * @param proposal Investment proposal for creation event notification
     *                 Contains investment proposal information for system integration
     */
    public InvestmentProposalCreatedEvent(InvestmentProposal proposal) {
        // Spring Boot: Initialize investment proposal created event with proposal data
        // Sets investment proposal for event notification and system integration
        this.proposal = proposal;
    }
    
    /**
     * Getter for investment proposal associated with creation event
     * Spring Boot: Event data accessor for investment proposal information
     * Provides investment proposal data for event processing and notification
     * 
     * @return Investment proposal associated with creation event
     *         Provides investment proposal data for system integration
     */
    public InvestmentProposal getProposal() {
        // Spring Boot: Return investment proposal for event processing
        // Provides investment proposal data for workflow notifications
        return proposal;
    }
}
```

## src/main/java/com/investment/proposal/event/InvestmentEventListener.java
```java
package com.investment.proposal.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Investment Event Listener for System Integration and Monitoring
 * Spring Boot: Event listener for investment workflow notifications and processing
 * This class implements investment system integration and monitoring capabilities
 * and supports investment audit trails and real-time processing workflows
 */
@Component  // Spring Boot: Component registration for event listening and processing
            // Registers this class as a managed Spring event listener component
public class InvestmentEventListener {
    
    /**
     * Handle investment proposal creation events for system integration
     * Spring Boot: Event listener for investment workflow notifications and processing
     * Implements investment system integration and monitoring capabilities
     * Supports investment audit trails and real-time processing workflows
     * 
     * @param event InvestmentProposalCreatedEvent for processing and notification
     *              Contains investment proposal creation information for system integration
     */
    @EventListener  // Spring Boot: Event listener annotation for investment creation events
                    // Registers method as listener for investment proposal creation notifications
    public void handleInvestmentProposalCreated(InvestmentProposalCreatedEvent event) {
        // Spring Boot: Log investment proposal creation event for system monitoring
        // Provides investment system integration and audit trail maintenance
        System.out.println("Investment proposal created: " + event.getProposal().getProposalReference() +
                          " for client: " + event.getProposal().getClientName());
        
        // Spring Boot: Integration logic for investment creation notifications and processing
        // Enables investment system integration with external services and workflows
        // Additional integration logic can be implemented here for investment processing
    }
    
    /**
     * Handle investment proposal status change events for system integration
     * Spring Boot: Event listener for investment workflow updates and monitoring
     * Implements investment system integration and real-time monitoring capabilities
     * Supports investment audit trails and compliance workflows
     * 
     * @param event InvestmentProposalStatusChangedEvent for processing and notification
     *              Contains investment proposal status change information for system integration
     */
    @EventListener  // Spring Boot: Event listener for investment status change events
                    // Registers method as listener for investment proposal status notifications
    public void handleInvestmentProposalStatusChanged(InvestmentProposalStatusChangedEvent event) {
        // Spring Boot: Log investment proposal status change event for system monitoring
        // Provides investment system integration and real-time monitoring capabilities
        System.out.println("Investment proposal status changed: " + event.getProposal().getProposalReference() +
                          " - Approved: " + event.getProposal().getApproved() +
                          " for client: " + event.getProposal().getClientName());
        
        // Spring Boot: Integration logic for investment approval notifications and processing
        // Enables investment system integration with approval workflows and client communication
        // Additional integration logic can be implemented here for investment status updates
    }
    
    /**
     * Handle investment proposal deletion events for system integration
     * Spring Boot: Event listener for investment data removal and audit trail maintenance
     * Implements investment system integration and audit trail maintenance capabilities
     * Supports investment compliance and data governance requirements
     * 
     * @param event InvestmentProposalDeletedEvent for processing and notification
     *              Contains investment proposal deletion information for system integration
     */
    @EventListener  // Spring Boot: Event listener for investment deletion events
                    // Registers method as listener for investment proposal deletion notifications
    public void handleInvestmentProposalDeleted(InvestmentProposalDeletedEvent event) {
        // Spring Boot: Log investment proposal deletion event for system monitoring
        // Provides investment system integration and audit trail maintenance
        System.out.println("Investment proposal deleted: " + event.getProposal().getProposalReference() +
                          " for client: " + event.getProposal().getClientName());
        
        // Spring Boot: Integration logic for investment deletion notifications and cleanup
        // Enables investment system integration with data governance and compliance workflows
        // Additional integration logic can be implemented here for investment data removal
    }
}
```

## src/main/java/com/investment/proposal/event/InvestmentProposalStatusChangedEvent.java
```java
package com.investment.proposal.event;

import com.investment.proposal.entity.InvestmentProposal;

/**
 * Investment Proposal Status Changed Event for Workflow Updates
 * Spring Boot: Application event for investment workflow updates and notifications
 * This class enables investment system integration and real-time monitoring capabilities
 * and supports investment audit trails and compliance workflows
 */
public class InvestmentProposalStatusChangedEvent {
    /**
     * Investment proposal associated with status change event for system integration
     * Spring Boot: Event data for investment proposal status change notification
     * Enables investment workflow updates and audit trail maintenance
     */
    private final InvestmentProposal proposal;
    
    /**
     * Constructor for investment proposal status changed event with proposal data
     * Spring Boot: Event constructor with investment proposal information
     * Initializes investment event with specific proposal data for notification
     * 
     * @param proposal Investment proposal for status change event notification
     *                 Contains investment proposal information for system integration
     */
    public InvestmentProposalStatusChangedEvent(InvestmentProposal proposal) {
        // Spring Boot: Initialize investment proposal status changed event with proposal data
        // Sets investment proposal for event notification and system integration
        this.proposal = proposal;
    }
    
    /**
     * Getter for investment proposal associated with status change event
     * Spring Boot: Event data accessor for investment proposal information
     * Provides investment proposal data for event processing and notification
     * 
     * @return Investment proposal associated with status change event
     *         Provides investment proposal data for system integration
     */
    public InvestmentProposal getProposal() {
        // Spring Boot: Return investment proposal for event processing
        // Provides investment proposal data for workflow notifications
        return proposal;
    }
}
```

## src/main/java/com/investment/proposal/event/InvestmentProposalDeletedEvent.java
```java
package com.investment.proposal.event;

import com.investment.proposal.entity.InvestmentProposal;

/**
 * Investment Proposal Deleted Event for Data Removal and Audit Trail
 * Spring Boot: Application event for investment data removal and audit trail maintenance
 * This class enables investment system integration and audit trail maintenance capabilities
 * and supports investment compliance and data governance requirements
 */
public class InvestmentProposalDeletedEvent {
    /**
     * Investment proposal associated with deletion event for system integration
     * Spring Boot: Event data for investment proposal deletion notification
     * Enables investment audit trail maintenance and data governance
     */
    private final InvestmentProposal proposal;
    
    /**
     * Constructor for investment proposal deleted event with proposal data
     * Spring Boot: Event constructor with investment proposal information
     * Initializes investment event with specific proposal data for notification
     * 
     * @param proposal Investment proposal for deletion event notification
     *                 Contains investment proposal information for system integration
     */
    public InvestmentProposalDeletedEvent(InvestmentProposal proposal) {
        // Spring Boot: Initialize investment proposal deleted event with proposal data
        // Sets investment proposal for event notification and system integration
        this.proposal = proposal;
    }
    
    /**
     * Getter for investment proposal associated with deletion event
     * Spring Boot: Event data accessor for investment proposal information
     * Provides investment proposal data for event processing and notification
     * 
     * @return Investment proposal associated with deletion event
     *         Provides investment proposal data for system integration
     */
    public InvestmentProposal getProposal() {
        // Spring Boot: Return investment proposal for event processing
        // Provides investment proposal data for workflow notifications
        return proposal;
    }
}
```

## src/main/java/com/investment/proposal/scheduler/InvestmentScheduler.java
```java
package com.investment.proposal.scheduler;

import com.investment.proposal.config.InvestmentConfig;
import com.investment.proposal.service.InvestmentProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Investment Scheduled Tasks for System Maintenance and Monitoring
 * Spring Boot: Scheduled component for investment system operations and maintenance
 * This class implements investment system maintenance and monitoring workflows
 * and supports investment data cleanup and compliance reporting requirements
 */
@Component  // Spring Boot: Component registration for scheduled investment tasks
            // Registers this class as a managed Spring scheduled task component
public class InvestmentScheduler {
    
    /**
     * Investment proposal service for scheduled operations and maintenance
     * Spring Boot: Service injection for investment maintenance tasks and operations
     * Enables scheduled investment system operations and monitoring capabilities
     * Supports investment data cleanup and compliance reporting workflows
     */
    @Autowired  // Spring Boot: Service dependency injection for investment maintenance
                // Injects InvestmentProposalService for scheduled investment operations
    private InvestmentProposalService investmentProposalService;
    
    /**
     * Investment management properties for scheduled task configuration
     * Spring Boot: Configuration injection for investment scheduled task settings
     * Enables externalized configuration for investment maintenance operations
     * Supports investment system customization and maintenance workflow management
     */
    @Autowired  // Spring Boot: Configuration properties injection for investment scheduling
                // Injects InvestmentManagementProperties for investment scheduled task configuration
    private InvestmentConfig.InvestmentManagementProperties investmentProperties;
    
    /**
     * Scheduled task for investment portfolio review and analysis
     * Spring Boot: Scheduled method execution for investment maintenance and monitoring
     * Implements investment system monitoring and compliance workflows
     * Supports investment portfolio analysis and regulatory reporting requirements
     */
    @Scheduled(cron = "${investment.management.portfolio-review-cron:0 0 9 * * MON}")  // Spring Boot: Cron expression for weekly investment review
                                                                                      // Configurable cron expression for investment portfolio maintenance
    public void weeklyInvestmentPortfolioReview() {
        // Spring Boot: Log weekly investment portfolio review start for system monitoring
        // Provides investment system maintenance and monitoring capabilities
        System.out.println("Weekly investment portfolio review started at: " + LocalDateTime.now());
        
        // Spring Boot: Perform investment portfolio analysis and reporting logic
        // Implements investment system monitoring and compliance workflows
        try {
            // Spring Boot: Get portfolio summary for investment analysis and reporting
            // Provides investment portfolio data for maintenance and monitoring
            var portfolioSummary = investmentProposalService.getPortfolioSummaryByRiskLevel();
            
            // Spring Boot: Log portfolio summary for investment system monitoring
            // Provides investment portfolio analysis and reporting information
            System.out.println("Portfolio Summary: " + portfolioSummary);
            
            // Spring Boot: Additional investment portfolio analysis and reporting logic
            // Implements investment system maintenance and compliance workflows
            // Additional analysis logic can be implemented here for investment maintenance
        } catch (Exception e) {
            // Spring Boot: Handle investment portfolio review errors gracefully
            // Ensures investment system reliability and error recovery capabilities
            System.err.println("Investment portfolio review failed: " + e.getMessage());
        }
    }
    
    /**
     * Scheduled task for investment data cleanup and optimization
     * Spring Boot: Fixed rate scheduling for investment maintenance and optimization
     * Implements investment system data management and optimization workflows
     * Supports investment system performance and data governance requirements
     */
    @Scheduled(fixedRateString = "${investment.management.data-cleanup-interval:3600000}")  // Spring Boot: Configurable interval for investment data cleanup
                                                                                            // Hourly execution for investment data cleanup with configuration
    public void hourlyInvestmentDataCleanup() {
        // Spring Boot: Log hourly investment data cleanup execution for system monitoring
        // Provides investment system maintenance and optimization capabilities
        System.out.println("Hourly investment data cleanup executed at: " + LocalDateTime.now());
        
        // Spring Boot: Perform investment data optimization and maintenance logic
        // Implements investment system data management and optimization workflows
        try {
            // Spring Boot: Investment data optimization and maintenance operations
            // Provides investment system performance and data governance capabilities
            // Cleanup logic can be implemented here for investment data optimization
            
            // Spring Boot: Log successful investment data cleanup completion
            // Provides investment system maintenance status information
            System.out.println("Investment data cleanup completed successfully");
        } catch (Exception e) {
            // Spring Boot: Handle investment data cleanup errors gracefully
            // Ensures investment system reliability and error recovery capabilities
            System.err.println("Investment data cleanup failed: " + e.getMessage());
        }
    }
}
```

## src/main/resources/templates/index.html
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <!-- Spring Boot: HTML head section for investment management web interface -->
    <!-- Provides metadata and styling for investment management dashboard -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title th:text="${title}">Investment Proposal Management System</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <!-- Spring Boot: Main container for investment management dashboard -->
    <!-- Provides layout structure for investment management web interface -->
    <div class="container">
        <!-- Spring Boot: Header section for investment management dashboard -->
        <!-- Displays investment system title and navigation information -->
        <header>
            <h1 th:text="${title}">Investment Proposal Management System</h1>
            <p th:text="${description}">Manage investment proposals and portfolio analysis</p>
        </header>
        
        <!-- Spring Boot: Navigation section for investment management dashboard -->
        <!-- Provides links to different investment management sections -->
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/proposals">Investment Proposals</a></li>
                <li><a href="/h2-console" target="_blank">Database Console</a></li>
                <li><a href="/actuator" target="_blank">System Monitoring</a></li>
            </ul>
        </nav>
        
        <!-- Spring Boot: Main content section for investment management dashboard -->
        <!-- Displays investment system features and functionality information -->
        <main>
            <section class="features">
                <h2>Investment Management Features</h2>
                <div class="feature-grid">
                    <div class="feature-card">
                        <h3>Proposal Management</h3>
                        <p>Create, view, and manage investment proposals with comprehensive tracking.</p>
                    </div>
                    <div class="feature-card">
                        <h3>Portfolio Analysis</h3>
                        <p>Analyze investment portfolios by risk level, client, and investment type.</p>
                    </div>
                    <div class="feature-card">
                        <h3>Risk Assessment</h3>
                        <p>Evaluate investment risks with automated risk assessment workflows.</p>
                    </div>
                    <div class="feature-card">
                        <h3>Client Management</h3>
                        <p>Manage client relationships and investment portfolios efficiently.</p>
                    </div>
                </div>
            </section>
            
            <section class="api-info">
                <h2>REST API Endpoints</h2>
                <div class="endpoint-list">
                    <div class="endpoint">
                        <code>GET /api/investment-proposals</code>
                        <span>Retrieve all investment proposals</span>
                    </div>
                    <div class="endpoint">
                        <code>POST /api/investment-proposals</code>
                        <span>Create new investment proposal</span>
                    </div>
                    <div class="endpoint">
                        <code>GET /api/investment-proposals/{id}</code>
                        <span>Get investment proposal by ID</span>
                    </div>
                    <div class="endpoint">
                        <code>PUT /api/investment-proposals/{id}/approve</code>
                        <span>Update investment proposal approval status</span>
                    </div>
                </div>
            </section>
        </main>
        
        <!-- Spring Boot: Footer section for investment management dashboard -->
        <!-- Displays investment system information and copyright details -->
        <footer>
            <p>&copy; 2024 Investment Proposal Management System. All rights reserved.</p>
        </footer>
    </div>
</body>
</html>
```

## src/main/resources/templates/proposals.html
```html
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <!-- Spring Boot: HTML head section for investment proposals management interface -->
    <!-- Provides metadata and styling for investment portfolio management -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title th:text="${title}">Investment Proposals</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <!-- Spring Boot: Main container for investment proposals management interface -->
    <!-- Provides layout structure for investment portfolio management web interface -->
    <div class="container">
        <!-- Spring Boot: Header section for investment proposals management -->
        <!-- Displays investment portfolio management title and information -->
        <header>
            <h1 th:text="${title}">Investment Proposals</h1>
            <p th:text="${description}">View and manage investment proposals</p>
        </header>
        
        <!-- Spring Boot: Navigation section for investment proposals management -->
        <!-- Provides links to different investment management sections -->
        <nav>
            <ul>
                <li><a href="/">Home</a></li>
                <li><a href="/proposals">Investment Proposals</a></li>
                <li><a href="/h2-console" target="_blank">Database Console</a></li>
                <li><a href="/actuator" target="_blank">System Monitoring</a></li>
            </ul>
        </nav>
        
        <!-- Spring Boot: Main content section for investment proposals management -->
        <!-- Displays investment portfolio data and management controls -->
        <main>
            <section class="proposal-actions">
                <h2>Investment Proposal Actions</h2>
                <div class="action-buttons">
                    <button onclick="createNewProposal()">Create New Proposal</button>
                    <button onclick="refreshProposals()">Refresh Proposals</button>
                    <button onclick="exportProposals()">Export Proposals</button>
                </div>
            </section>
            
            <section class="proposal-list">
                <h2>Current Investment Proposals</h2>
                <div class="table-container">
                    <table>
                        <thead>
                            <tr>
                                <th>Reference</th>
                                <th>Client Name</th>
                                <th>Amount</th>
                                <th>Expected Return</th>
                                <th>Risk Level</th>
                                <th>Investment Type</th>
                                <th>Advisor</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>INV-001</td>
                                <td>John Doe</td>
                                <td>$50,000.00</td>
                                <td>7.5%</td>
                                <td>MEDIUM</td>
                                <td>STOCKS</td>
                                <td>Alice Johnson</td>
                                <td><span class="status pending">Pending</span></td>
                                <td>
                                    <button class="btn-small">View</button>
                                    <button class="btn-small">Edit</button>
                                    <button class="btn-small btn-danger">Delete</button>
                                </td>
                            </tr>
                            <tr>
                                <td>INV-002</td>
                                <td>Jane Smith</td>
                                <td>$100,000.00</td>
                                <td>12.0%</td>
                                <td>HIGH</td>
                                <td>REAL_ESTATE</td>
                                <td>Carol Davis</td>
                                <td><span class="status approved">Approved</span></td>
                                <td>
                                    <button class="btn-small">View</button>
                                    <button class="btn-small">Edit</button>
                                    <button class="btn-small btn-danger">Delete</button>
                                </td>
                            </tr>
                            <tr>
                                <td>INV-003</td>
                                <td>Bob Johnson</td>
                                <td>$25,000.00</td>
                                <td>5.8%</td>
                                <td>LOW</td>
                                <td>BONDS</td>
                                <td>Bob Smith</td>
                                <td><span class="status pending">Pending</span></td>
                                <td>
                                    <button class="btn-small">View</button>
                                    <button class="btn-small">Edit</button>
                                    <button class="btn-small btn-danger">Delete</button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </section>
            
            <section class="portfolio-summary">
                <h2>Portfolio Summary</h2>
                <div class="summary-cards">
                    <div class="summary-card">
                        <h3>Total Proposals</h3>
                        <p class="summary-value">15</p>
                    </div>
                    <div class="summary-card">
                        <h3>Total Investment</h3>
                        <p class="summary-value">$1,250,000.00</p>
                    </div>
                    <div class="summary-card">
                        <h3>Average Return</h3>
                        <p class="summary-value">8.7%</p>
                    </div>
                    <div class="summary-card">
                        <h3>Approval Rate</h3>
                        <p class="summary-value">67%</p>
                    </div>
                </div>
            </section>
        </main>
        
        <!-- Spring Boot: Footer section for investment proposals management -->
        <!-- Displays investment portfolio management information and copyright details -->
        <footer>
            <p>&copy; 2024 Investment Proposal Management System. All rights reserved.</p>
        </footer>
    </div>
    
    <!-- Spring Boot: JavaScript section for investment proposals management -->
    <!-- Provides client-side functionality for investment portfolio management -->
    <script>
        // Spring Boot: Function for creating new investment proposal
        // Provides client-side investment proposal creation workflow
        function createNewProposal() {
            alert('Create new investment proposal functionality would be implemented here');
        }
        
        // Spring Boot: Function for refreshing investment proposals
        // Provides client-side investment portfolio data refresh capability
        function refreshProposals() {
            location.reload();
        }
        
        // Spring Boot: Function for exporting investment proposals
        // Provides client-side investment portfolio data export capability
        function exportProposals() {
            alert('Export investment proposals functionality would be implemented here');
        }
    </script>
</body>
</html>
```

## src/main/resources/static/css/style.css
```css
/* Spring Boot: CSS styling for investment management web interface */
/* Provides visual design and layout for investment management system */

/* Spring Boot: Base styles for investment management web interface */
/* Defines fundamental styling for investment system components */
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

/* Spring Boot: Body styles for investment management web interface */
/* Provides overall styling for investment system web pages */
body {
    font-family: 'Arial', sans-serif;
    line-height: 1.6;
    color: #333;
    background-color: #f4f4f4;
}

/* Spring Boot: Container styles for investment management layout */
/* Defines main container styling for investment system components */
.container {
    max-width: 1200px;
    margin: 0 auto;
    padding: 20px;
    background-color: white;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    min-height: 100vh;
}

/* Spring Boot: Header styles for investment management dashboard */
/* Provides styling for investment system header and title sections */
header {
    text-align: center;
    padding: 20px 0;
    border-bottom: 2px solid #007bff;
    margin-bottom: 30px;
}

header h1 {
    color: #007bff;
    margin-bottom: 10px;
}

/* Spring Boot: Navigation styles for investment management interface */
/* Provides styling for investment system navigation and menu sections */
nav {
    background-color: #007bff;
    padding: 10px 0;
    margin-bottom: 30px;
}

nav ul {
    list-style: none;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
}

nav ul li {
    margin: 0 15px;
}

nav ul li a {
    color: white;
    text-decoration: none;
    font-weight: bold;
    padding: 8px 16px;
    border-radius: 4px;
    transition: background-color 0.3s;
}

nav ul li a:hover {
    background-color: #0056b3;
}

/* Spring Boot: Feature card styles for investment management dashboard */
/* Provides styling for investment system feature presentation components */
.feature-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
    gap: 20px;
    margin: 20px 0;
}

.feature-card {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
    border-left: 4px solid #007bff;
}

.feature-card h3 {
    color: #007bff;
    margin-bottom: 10px;
}

/* Spring Boot: API endpoint styles for investment management dashboard */
/* Provides styling for investment system API documentation components */
.endpoint-list {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 8px;
    margin: 20px 0;
}

.endpoint {
    margin: 15px 0;
    padding: 10px;
    background-color: white;
    border-radius: 4px;
    border-left: 3px solid #28a745;
}

.endpoint code {
    background-color: #e9ecef;
    padding: 2px 6px;
    border-radius: 3px;
    font-family: 'Courier New', monospace;
    display: block;
    margin-bottom: 5px;
}

/* Spring Boot: Proposal management styles for investment portfolio interface */
/* Provides styling for investment portfolio management components */
.proposal-actions {
    margin-bottom: 30px;
}

.action-buttons {
    display: flex;
    gap: 10px;
    flex-wrap: wrap;
}

.action-buttons button {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 4px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.action-buttons button:hover {
    background-color: #0056b3;
}

/* Spring Boot: Table styles for investment proposal listing */
/* Provides styling for investment portfolio data presentation */
.table-container {
    overflow-x: auto;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin: 20px 0;
}

th, td {
    padding: 12px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

th {
    background-color: #007bff;
    color: white;
    font-weight: bold;
}

tr:hover {
    background-color: #f5f5f5;
}

/* Spring Boot: Status styling for investment proposal management */
/* Provides styling for investment proposal status indicators */
.status {
    padding: 4px 8px;
    border-radius: 12px;
    font-size: 0.8em;
    font-weight: bold;
}

.status.pending {
    background-color: #ffc107;
    color: #212529;
}

.status.approved {
    background-color: #28a745;
    color: white;
}

/* Spring Boot: Button styling for investment proposal actions */
/* Provides styling for investment portfolio management action buttons */
.btn-small {
    padding: 4px 8px;
    margin: 2px;
    border: none;
    border-radius: 3px;
    cursor: pointer;
    font-size: 0.8em;
}

.btn-small {
    background-color: #007bff;
    color: white;
}

.btn-small:hover {
    background-color: #0056b3;
}

.btn-small.btn-danger {
    background-color: #dc3545;
}

.btn-small.btn-danger:hover {
    background-color: #c82333;
}

/* Spring Boot: Portfolio summary styles for investment management */
/* Provides styling for investment portfolio analysis and reporting */
.summary-cards {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
    gap: 20px;
    margin: 20px 0;
}

.summary-card {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 8px;
    text-align: center;
    box-shadow: 0 2px 4px rgba(0,0,0,0.1);
}

.summary-card h3 {
    color: #007bff;
    margin-bottom: 10px;
    font-size: 1em;
}

.summary-value {
    font-size: 1.5em;
    font-weight: bold;
    color: #28a745;
}

/* Spring Boot: Footer styles for investment management interface */
/* Provides styling for investment system footer and copyright information */
footer {
    text-align: center;
    padding: 20px 0;
    margin-top: 30px;
    border-top: 1px solid #ddd;
    color: #666;
}

/* Spring Boot: Responsive design for investment management interface */
/* Provides mobile-friendly styling for investment system components */
@media (max-width: 768px) {
    .container {
        padding: 10px;
    }
    
    nav ul {
        flex-direction: column;
        align-items: center;
    }
    
    nav ul li {
        margin: 5px 0;
    }
    
    .feature-grid {
        grid-template-columns: 1fr;
    }
    
    .summary-cards {
        grid-template-columns: 1fr;
    }
    
    .action-buttons {
        flex-direction: column;
    }
    
    .action-buttons button {
        width: 100%;
        margin-bottom: 10px;
    }
}
```

## src/test/java/com/investment/proposal/InvestmentProposalApplicationTests.java
```java
package com.investment.proposal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Investment Proposal Application Integration Tests
 * Spring Boot: Integration tests for investment management system components
 * This class provides comprehensive testing for investment system functionality
 * and ensures proper integration of all investment management components
 */
@SpringBootTest  // Spring Boot: Integration test annotation for investment system
                 // Loads complete investment application context for testing
class InvestmentProposalApplicationTests {

    /**
     * Test context loading for investment proposal management system
     * Spring Boot: Context loading test for investment application startup
     * Ensures all investment system components are properly configured
     * Validates investment application context and dependency injection
     */
    @Test  // Spring Boot: Test method annotation for investment system testing
           // Registers method as a test case for investment application verification
    void contextLoads() {
        // Spring Boot: Empty test to verify investment application context loading
        // Ensures all investment system components start without errors
        // Validates investment application configuration and bean registration
    }
}
```

## src/test/java/com/investment/proposal/service/InvestmentProposalServiceTest.java
```java
package com.investment.proposal.service;

import com.investment.proposal.config.InvestmentConfig;
import com.investment.proposal.entity.InvestmentProposal;
import com.investment.proposal.entity.RiskLevel;
import com.investment.proposal.exception.InvestmentProposalNotFoundException;
import com.investment.proposal.repository.InvestmentProposalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Investment Proposal Service Unit Tests
 * Spring Boot: Unit tests for investment service business logic implementation
 * This class provides comprehensive testing for investment service functionality
 * and ensures proper business logic and data processing workflows
 */
class InvestmentProposalServiceTest {

    /**
     * Mock investment proposal repository for testing data access operations
     * Spring Boot: Mock repository for investment service testing and validation
     * Enables isolated testing of investment service business logic without database
     * Supports investment service unit testing with controlled test data
     */
    @Mock  // Spring Boot: Mock annotation for investment repository testing
           // Creates mock InvestmentProposalRepository for unit testing
    private InvestmentProposalRepository investmentProposalRepository;

    /**
     * Mock investment management properties for testing configuration access
     * Spring Boot: Mock configuration for investment service testing and validation
     * Enables isolated testing of investment service with controlled configuration
     * Supports investment service unit testing with specific test settings
     */
    @Mock  // Spring Boot: Mock annotation for investment configuration testing
           // Creates mock InvestmentManagementProperties for unit testing
    private InvestmentConfig.InvestmentManagementProperties investmentProperties;

    /**
     * Mock application event publisher for testing event publishing operations
     * Spring Boot: Mock event publisher for investment service testing and validation
     * Enables isolated testing of investment service event handling without external systems
     * Supports investment service unit testing with controlled event scenarios
     */
    @Mock  // Spring Boot: Mock annotation for event publisher testing
           // Creates mock ApplicationEventPublisher for unit testing
    private ApplicationEventPublisher eventPublisher;

    /**
     * Mock investment async service for testing background processing operations
     * Spring Boot: Mock async service for investment service testing and validation
     * Enables isolated testing of investment service with controlled async operations
     * Supports investment service unit testing with specific background scenarios
     */
    @Mock  // Spring Boot: Mock annotation for async service testing
           // Creates mock InvestmentAsyncService for unit testing
    private InvestmentAsyncService investmentAsyncService;

    /**
     * Investment proposal service under test with injected mock dependencies
     * Spring Boot: Service instance for investment business logic testing
     * Enables comprehensive testing of investment service functionality
     * Supports investment service unit testing with mock component injection
     */
    @InjectMocks  // Spring Boot: Inject mocks annotation for service testing
                  // Injects mock dependencies into InvestmentProposalService for testing
    private InvestmentProposalService investmentProposalService;

    /**
     * Setup method for investment service unit testing initialization
     * Spring Boot: Test setup method for investment service testing preparation
     * Initializes mock objects and test data for investment service unit tests
     * Ensures consistent test environment for investment service validation
     */
    @BeforeEach  // Spring Boot: Before each test annotation for setup
                 // Executes before each investment service test method
    void setUp() {
        // Spring Boot: Initialize Mockito annotations for investment service testing
        // Sets up mock objects and dependency injection for investment service tests
        MockitoAnnotations.openMocks(this);
        
        // Spring Boot: Configure mock investment properties for testing
        // Sets up investment configuration for investment service unit tests
        when(investmentProperties.getMaxInvestmentAmount()).thenReturn(new BigDecimal("10000000.00"));
    }

    /**
     * Test investment proposal creation with valid data and business rules
     * Spring Boot: Unit test for investment proposal creation business logic
     * Validates investment proposal creation workflow with proper validation
     * Ensures investment service handles valid investment proposals correctly
     */
    @Test  // Spring Boot: Test method annotation for investment creation testing
           // Registers method as a test case for investment proposal creation validation
    void testCreateInvestmentProposal_ValidProposal_ShouldCreateSuccessfully() {
        // Spring Boot: Create test investment proposal for creation testing
        // Sets up valid investment proposal data for investment service testing
        InvestmentProposal proposal = new InvestmentProposal(
                "INV-001", "John Doe", new BigDecimal("50000.00"),
                new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson");
        
        // Spring Boot: Configure mock repository behavior for investment creation
        // Sets up mock repository to return saved investment proposal for testing
        when(investmentProposalRepository.save(any(InvestmentProposal.class))).thenReturn(proposal);
        
        // Spring Boot: Execute investment proposal creation and verify results
        // Tests investment service creation workflow with valid investment data
        InvestmentProposal result = investmentProposalService.createInvestmentProposal(proposal);
        
        // Spring Boot: Verify investment proposal creation results and mock interactions
        // Validates investment service behavior and repository interactions
        assertNotNull(result);
        assertEquals("INV-001", result.getProposalReference());
        verify(investmentProposalRepository, times(1)).save(proposal);
        verify(eventPublisher, times(1)).publishEvent(any());
    }

    /**
     * Test investment proposal creation with amount exceeding system limits
     * Spring Boot: Unit test for investment proposal creation validation rules
     * Validates investment proposal creation workflow with invalid investment amounts
     * Ensures investment service handles excessive investment proposals correctly
     */
    @Test  // Spring Boot: Test method annotation for investment amount validation
           // Registers method as a test case for investment amount limit validation
    void testCreateInvestmentProposal_AmountExceedsLimit_ShouldThrowException() {
        // Spring Boot: Create test investment proposal with excessive amount
        // Sets up invalid investment proposal data for investment service testing
        InvestmentProposal proposal = new InvestmentProposal(
                "INV-002", "Jane Smith", new BigDecimal("15000000.00"),
                new BigDecimal("12.0"), RiskLevel.HIGH, "REAL_ESTATE", "Carol Davis");
        
        // Spring Boot: Execute investment proposal creation and verify exception
        // Tests investment service validation with excessive investment amounts
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> investmentProposalService.createInvestmentProposal(proposal));
        
        // Spring Boot: Verify investment proposal creation exception message
        // Validates investment service error handling for amount limit violations
        assertTrue(exception.getMessage().contains("exceeds maximum allowed limit"));
        verify(investmentProposalRepository, never()).save(any());
    }

    /**
     * Test get all investment proposals with caching and data retrieval
     * Spring Boot: Unit test for investment proposal retrieval business logic
     * Validates investment proposal retrieval workflow with proper data access
     * Ensures investment service handles portfolio data retrieval correctly
     */
    @Test  // Spring Boot: Test method annotation for investment retrieval testing
           // Registers method as a test case for investment portfolio data retrieval
    void testGetAllInvestmentProposals_ShouldReturnAllProposals() {
        // Spring Boot: Create test investment proposals for retrieval testing
        // Sets up investment proposal data for investment service portfolio testing
        List<InvestmentProposal> proposals = Arrays.asList(
                new InvestmentProposal("INV-001", "John Doe", new BigDecimal("50000.00"),
                        new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson"),
                new InvestmentProposal("INV-002", "Jane Smith", new BigDecimal("100000.00"),
                        new BigDecimal("12.0"), RiskLevel.HIGH, "REAL_ESTATE", "Carol Davis")
        );
        
        // Spring Boot: Configure mock repository behavior for investment retrieval
        // Sets up mock repository to return investment proposals for testing
        when(investmentProposalRepository.findAll()).thenReturn(proposals);
        
        // Spring Boot: Execute investment proposal retrieval and verify results
        // Tests investment service retrieval workflow with portfolio data
        List<InvestmentProposal> result = investmentProposalService.getAllInvestmentProposals();
        
        // Spring Boot: Verify investment proposal retrieval results and mock interactions
        // Validates investment service behavior and repository interactions
        assertEquals(2, result.size());
        verify(investmentProposalRepository, times(1)).findAll();
    }

    /**
     * Test get investment proposal by ID with existing data and validation
     * Spring Boot: Unit test for investment proposal retrieval by ID business logic
     * Validates investment proposal retrieval workflow with specific ID access
     * Ensures investment service handles individual proposal access correctly
     */
    @Test  // Spring Boot: Test method annotation for investment ID retrieval testing
           // Registers method as a test case for investment proposal ID-based access
    void testGetInvestmentProposalById_ExistingId_ShouldReturnProposal() {
        // Spring Boot: Create test investment proposal for ID retrieval testing
        // Sets up investment proposal data for investment service ID-based testing
        InvestmentProposal proposal = new InvestmentProposal(
                "INV-001", "John Doe", new BigDecimal("50000.00"),
                new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson");
        
        // Spring Boot: Configure mock repository behavior for investment ID retrieval
        // Sets up mock repository to return specific investment proposal for testing
        when(investmentProposalRepository.findById(1L)).thenReturn(Optional.of(proposal));
        
        // Spring Boot: Execute investment proposal ID retrieval and verify results
        // Tests investment service ID-based retrieval workflow with valid data
        InvestmentProposal result = investmentProposalService.getInvestmentProposalById(1L);
        
        // Spring Boot: Verify investment proposal ID retrieval results and mock interactions
        // Validates investment service behavior and repository interactions
        assertNotNull(result);
        assertEquals("INV-001", result.getProposalReference());
        verify(investmentProposalRepository, times(1)).findById(1L);
    }

    /**
     * Test get investment proposal by ID with non-existing data and error handling
     * Spring Boot: Unit test for investment proposal retrieval error handling
     * Validates investment proposal retrieval workflow with missing data scenarios
     * Ensures investment service handles missing proposal errors correctly
     */
    @Test  // Spring Boot: Test method annotation for investment ID error testing
           // Registers method as a test case for investment proposal ID-based error handling
    void testGetInvestmentProposalById_NonExistingId_ShouldThrowException() {
        // Spring Boot: Configure mock repository behavior for missing investment proposal
        // Sets up mock repository to return empty result for investment service testing
        when(investmentProposalRepository.findById(999L)).thenReturn(Optional.empty());
        
        // Spring Boot: Execute investment proposal ID retrieval and verify exception
        // Tests investment service error handling with missing investment proposals
        assertThrows(InvestmentProposalNotFoundException.class,
                () -> investmentProposalService.getInvestmentProposalById(999L));
        
        // Spring Boot: Verify investment proposal ID retrieval mock interactions
        // Validates investment service repository interactions for missing data
        verify(investmentProposalRepository, times(1)).findById(999L);
    }

    /**
     * Test update investment proposal approval status with workflow management
     * Spring Boot: Unit test for investment proposal approval status updates
     * Validates investment proposal approval workflow with proper status management
     * Ensures investment service handles approval processing correctly
     */
    @Test  // Spring Boot: Test method annotation for investment approval testing
           // Registers method as a test case for investment proposal approval processing
    void testUpdateApprovalStatus_ValidId_ShouldUpdateStatus() {
        // Spring Boot: Create test investment proposal for approval status testing
        // Sets up investment proposal data for investment service approval testing
        InvestmentProposal proposal = new InvestmentProposal(
                "INV-001", "John Doe", new BigDecimal("50000.00"),
                new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson");
        
        // Spring Boot: Configure mock repository behavior for investment approval
        // Sets up mock repository interactions for investment service approval testing
        when(investmentProposalRepository.findById(1L)).thenReturn(Optional.of(proposal));
        when(investmentProposalRepository.save(any(InvestmentProposal.class))).thenReturn(proposal);
        
        // Spring Boot: Execute investment proposal approval status update and verify results
        // Tests investment service approval workflow with valid investment data
        InvestmentProposal result = investmentProposalService.updateApprovalStatus(1L, true);
        
        // Spring Boot: Verify investment proposal approval results and mock interactions
        // Validates investment service behavior and repository interactions
        assertTrue(result.getApproved());
        verify(investmentProposalRepository, times(1)).findById(1L);
        verify(investmentProposalRepository, times(1)).save(proposal);
        verify(eventPublisher, times(1)).publishEvent(any());
    }

    /**
     * Test delete investment proposal with data removal and audit trail
     * Spring Boot: Unit test for investment proposal deletion business logic
     * Validates investment proposal deletion workflow with proper data cleanup
     * Ensures investment service handles proposal removal correctly
     */
    @Test  // Spring Boot: Test method annotation for investment deletion testing
           // Registers method as a test case for investment proposal deletion processing
    void testDeleteInvestmentProposal_ExistingId_ShouldDeleteSuccessfully() {
        // Spring Boot: Create test investment proposal for deletion testing
        // Sets up investment proposal data for investment service deletion testing
        InvestmentProposal proposal = new InvestmentProposal(
                "INV-001", "John Doe", new BigDecimal("50000.00"),
                new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson");
        
        // Spring Boot: Configure mock repository behavior for investment deletion
        // Sets up mock repository interactions for investment service deletion testing
        when(investmentProposalRepository.findById(1L)).thenReturn(Optional.of(proposal));
        
        // Spring Boot: Execute investment proposal deletion and verify results
        // Tests investment service deletion workflow with valid investment data
        assertDoesNotThrow(() -> investmentProposalService.deleteInvestmentProposal(1L));
        
        // Spring Boot: Verify investment proposal deletion mock interactions
        // Validates investment service behavior and repository interactions
        verify(investmentProposalRepository, times(1)).findById(1L);
        verify(investmentProposalRepository, times(1)).delete(proposal);
        verify(eventPublisher, times(1)).publishEvent(any());
    }

    /**
     * Test get investment proposals by client with search and filtering
     * Spring Boot: Unit test for investment proposal client-based retrieval
     * Validates investment proposal retrieval workflow with client filtering
     * Ensures investment service handles client-specific portfolio access correctly
     */
    @Test  // Spring Boot: Test method annotation for investment client testing
           // Registers method as a test case for investment proposal client-based access
    void testGetInvestmentProposalsByClient_ShouldReturnClientProposals() {
        // Spring Boot: Create test investment proposals for client retrieval testing
        // Sets up client-specific investment proposal data for investment service testing
        List<InvestmentProposal> proposals = Arrays.asList(
                new InvestmentProposal("INV-001", "John Doe", new BigDecimal("50000.00"),
                        new BigDecimal("7.5"), RiskLevel.MEDIUM, "STOCKS", "Alice Johnson")
        );
        
        // Spring Boot: Configure mock repository behavior for client-based retrieval
        // Sets up mock repository interactions for investment service client testing
        when(investmentProposalRepository.findByClientNameContainingIgnoreCase("John"))
                .thenReturn(proposals);
        
        // Spring Boot: Execute investment proposal client retrieval and verify results
        // Tests investment service client-based retrieval workflow with valid data
        List<InvestmentProposal> result = investmentProposalService.getInvestmentProposalsByClient("John");
        
        // Spring Boot: Verify investment proposal client retrieval results and mock interactions
        // Validates investment service behavior and repository interactions
        assertEquals(1, result.size());
        assertEquals("John Doe", result.get(0).getClientName());
        verify(investmentProposalRepository, times(1)).findByClientNameContainingIgnoreCase("John");
    }

    /**
     * Test get portfolio summary by risk level with statistical analysis
     * Spring Boot: Unit test for investment portfolio statistical analysis
     * Validates investment portfolio analysis workflow with risk level statistics
     * Ensures investment service handles portfolio summary generation correctly
     */
    @Test  // Spring Boot: Test method annotation for investment portfolio testing
           // Registers method as a test case for investment portfolio statistical analysis
    void testGetPortfolioSummaryByRiskLevel_ShouldReturnSummary() {
        // Spring Boot: Configure mock repository behavior for portfolio summary testing
        // Sets up mock repository interactions for investment service portfolio testing
        when(investmentProposalRepository.countByRiskLevel(RiskLevel.LOW)).thenReturn(5L);
        when(investmentProposalRepository.countByRiskLevel(RiskLevel.MEDIUM)).thenReturn(10L);
        when(investmentProposalRepository.countByRiskLevel(RiskLevel.HIGH)).thenReturn(3L);
        
        // Spring Boot: Execute investment portfolio summary retrieval and verify results
        // Tests investment service portfolio analysis workflow with statistical data
        var result = investmentProposalService.getPortfolioSummaryByRiskLevel();
        
        // Spring Boot: Verify investment portfolio summary results and mock interactions
        // Validates investment service behavior and repository interactions
        assertEquals(5L, result.get(RiskLevel.LOW));
        assertEquals(10L, result.get(RiskLevel.MEDIUM));
        assertEquals(3L, result.get(RiskLevel.HIGH));
        verify(investmentProposalRepository, times(1)).countByRiskLevel(RiskLevel.LOW);
        verify(investmentProposalRepository, times(1)).countByRiskLevel(RiskLevel.MEDIUM);
        verify(investmentProposalRepository, times(1)).countByRiskLevel(RiskLevel.HIGH);
    }
}
```

This comprehensive Spring Boot demo project demonstrates all major Spring Boot features in the context of investment proposal management:

## Key Features Demonstrated:

### **Core Spring Boot Features:**
- **@SpringBootApplication** - Main application configuration and auto-configuration
- **@ConfigurationProperties** - Type-safe external configuration with validation
- **@Component, @Service, @Repository, @Controller** - Component scanning and dependency injection
- **@Autowired** - Automatic dependency injection for investment components
- **@Value** - Configuration property injection for investment settings

### **Web and REST Features:**
- **@RestController** - REST API endpoints for investment management
- **@RequestMapping, @GetMapping, @PostMapping** - HTTP endpoint mapping
- **@PathVariable, @RequestParam, @RequestBody** - Request parameter binding
- **@Valid** - Request validation for investment data
- **@ExceptionHandler** - Global exception handling for investment errors
- **@ResponseStatus** - HTTP status code management

### **Data Access Features:**
- **JPA/Hibernate** - Investment proposal entity mapping and persistence
- **@Entity, @Table, @Column** - Database schema mapping
- **JpaRepository** - Investment data access with CRUD operations
- **@Query** - Custom JPQL and native SQL queries for investment analysis
- **@Transactional** - Investment transaction management and consistency

### **Security Features:**
- **@EnableWebSecurity** - Web security configuration for investment protection
- **@PreAuthorize** - Method-level security for investment access control
- **SecurityFilterChain** - Investment system authentication and authorization

### **Validation Features:**
- **Bean Validation** - Investment data validation with constraints
- **@NotNull, @NotBlank, @Min, @Max** - Investment field validation rules
- **@Validated** - Class-level validation for investment entities

### **Asynchronous Processing:**
- **@EnableAsync** - Async method execution for investment background processing
- **@Async** - Async investment operations for scalability
- **CompletableFuture** - Investment async result handling

### **Scheduling Features:**
- **@EnableScheduling** - Scheduled task execution for investment maintenance
- **@Scheduled** - Investment portfolio review and data cleanup tasks

### **Caching Features:**
- **@EnableCaching** - Investment data caching for performance optimization
- **@Cacheable** - Investment portfolio data caching

### **Event Handling:**
- **ApplicationEventPublisher** - Investment workflow event publishing
- **@EventListener** - Investment event handling and system integration

### **Testing Features:**
- **@SpringBootTest** - Investment system integration testing
- **@MockBean** - Investment service mocking for unit testing
- **JUnit 5** - Investment service unit testing framework

### **Production Features:**
- **@Profile** - Environment-specific investment configuration
- **Externalized Configuration** - Investment system properties management
- **Actuator** - Investment system monitoring and health checks
- **Thymeleaf** - Investment web interface templating

Each component is thoroughly documented with detailed comments explaining how Spring Boot features enhance investment management workflows, including risk assessment, portfolio analysis, client communication, regulatory compliance, and operational efficiency.