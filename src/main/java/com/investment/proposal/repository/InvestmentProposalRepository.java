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