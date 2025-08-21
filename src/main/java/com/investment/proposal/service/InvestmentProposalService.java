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