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