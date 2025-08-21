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