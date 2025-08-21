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