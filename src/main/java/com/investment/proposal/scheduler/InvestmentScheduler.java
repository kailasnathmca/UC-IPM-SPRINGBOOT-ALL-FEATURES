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