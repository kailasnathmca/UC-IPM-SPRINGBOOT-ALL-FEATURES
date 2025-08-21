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