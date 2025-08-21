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