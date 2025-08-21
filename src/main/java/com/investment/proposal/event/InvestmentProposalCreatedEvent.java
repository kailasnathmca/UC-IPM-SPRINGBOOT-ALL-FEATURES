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