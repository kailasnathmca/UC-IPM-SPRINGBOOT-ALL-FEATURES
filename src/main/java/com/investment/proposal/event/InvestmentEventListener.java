package com.investment.proposal.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Investment Event Listener for System Integration and Monitoring
 * Spring Boot: Event listener for investment workflow notifications and processing
 * This class implements investment system integration and monitoring capabilities
 * and supports investment audit trails and real-time processing workflows
 */
@Component  // Spring Boot: Component registration for event listening and processing
// Registers this class as a managed Spring event listener component
public class InvestmentEventListener {

    /**
     * Handle investment proposal creation events for system integration
     * Spring Boot: Event listener for investment workflow notifications and processing
     * Implements investment system integration and monitoring capabilities
     * Supports investment audit trails and real-time processing workflows
     *
     * @param event InvestmentProposalCreatedEvent for processing and notification
     *              Contains investment proposal creation information for system integration
     */
    @EventListener  // Spring Boot: Event listener annotation for investment creation events
    // Registers method as listener for investment proposal creation notifications
    public void handleInvestmentProposalCreated(InvestmentProposalCreatedEvent event) {
        // Spring Boot: Log investment proposal creation event for system monitoring
        // Provides investment system integration and audit trail maintenance
        System.out.println("Investment proposal created: " + event.getProposal().getProposalReference() +
                " for client: " + event.getProposal().getClientName());

        // Spring Boot: Integration logic for investment creation notifications and processing
        // Enables investment system integration with external services and workflows
        // Additional integration logic can be implemented here for investment processing
    }

    /**
     * Handle investment proposal status change events for system integration
     * Spring Boot: Event listener for investment workflow updates and monitoring
     * Implements investment system integration and real-time monitoring capabilities
     * Supports investment audit trails and compliance workflows
     *
     * @param event InvestmentProposalStatusChangedEvent for processing and notification
     *              Contains investment proposal status change information for system integration
     */
    @EventListener  // Spring Boot: Event listener for investment status change events
    // Registers method as listener for investment proposal status notifications
    public void handleInvestmentProposalStatusChanged(InvestmentProposalStatusChangedEvent event) {
        // Spring Boot: Log investment proposal status change event for system monitoring
        // Provides investment system integration and real-time monitoring capabilities
        System.out.println("Investment proposal status changed: " + event.getProposal().getProposalReference() +
                " - Approved: " + event.getProposal().getApproved() +
                " for client: " + event.getProposal().getClientName());

        // Spring Boot: Integration logic for investment approval notifications and processing
        // Enables investment system integration with approval workflows and client communication
        // Additional integration logic can be implemented here for investment status updates
    }

    /**
     * Handle investment proposal deletion events for system integration
     * Spring Boot: Event listener for investment data removal and audit trail maintenance
     * Implements investment system integration and audit trail maintenance capabilities
     * Supports investment compliance and data governance requirements
     *
     * @param event InvestmentProposalDeletedEvent for processing and notification
     *              Contains investment proposal deletion information for system integration
     */
    @EventListener  // Spring Boot: Event listener for investment deletion events
    // Registers method as listener for investment proposal deletion notifications
    public void handleInvestmentProposalDeleted(InvestmentProposalDeletedEvent event) {
        // Spring Boot: Log investment proposal deletion event for system monitoring
        // Provides investment system integration and audit trail maintenance
        System.out.println("Investment proposal deleted: " + event.getProposal().getProposalReference() +
                " for client: " + event.getProposal().getClientName());

        // Spring Boot: Integration logic for investment deletion notifications and cleanup
        // Enables investment system integration with data governance and compliance workflows
        // Additional integration logic can be implemented here for investment data removal
    }
}