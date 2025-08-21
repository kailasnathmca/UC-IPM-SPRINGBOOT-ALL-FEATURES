package com.investment.proposal.event;

import com.investment.proposal.entity.InvestmentProposal;

/**
 * Investment Proposal Status Changed Event for Workflow Updates
 * Spring Boot: Application event for investment workflow updates and notifications
 * This class enables investment system integration and real-time monitoring capabilities
 * and supports investment audit trails and compliance workflows
 */
public class InvestmentProposalStatusChangedEvent {
    /**
     * Investment proposal associated with status change event for system integration
     * Spring Boot: Event data for investment proposal status change notification
     * Enables investment workflow updates and audit trail maintenance
     */
    private final InvestmentProposal proposal;

    /**
     * Constructor for investment proposal status changed event with proposal data
     * Spring Boot: Event constructor with investment proposal information
     * Initializes investment event with specific proposal data for notification
     *
     * @param proposal Investment proposal for status change event notification
     *                 Contains investment proposal information for system integration
     */
    public InvestmentProposalStatusChangedEvent(InvestmentProposal proposal) {
        // Spring Boot: Initialize investment proposal status changed event with proposal data
        // Sets investment proposal for event notification and system integration
        this.proposal = proposal;
    }

    /**
     * Getter for investment proposal associated with status change event
     * Spring Boot: Event data accessor for investment proposal information
     * Provides investment proposal data for event processing and notification
     *
     * @return Investment proposal associated with status change event
     *         Provides investment proposal data for system integration
     */
    public InvestmentProposal getProposal() {
        // Spring Boot: Return investment proposal for event processing
        // Provides investment proposal data for workflow notifications
        return proposal;
    }
}