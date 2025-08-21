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