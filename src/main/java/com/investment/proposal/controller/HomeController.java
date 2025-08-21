package com.investment.proposal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Home Controller for Investment Management Web Interface
 * Spring Boot: Controller for investment management web pages and templates
 * This class provides investment management UI endpoints for web interface
 * and supports investment portfolio management and user interaction
 */
@Controller  // Spring Boot: Controller annotation for investment web interface
// Registers this class as a managed Spring MVC controller component
public class HomeController {

    /**
     * Home page endpoint for investment management web interface
     * Spring Boot: GET endpoint for investment management home page display
     * Provides investment management dashboard and navigation interface
     * Supports investment user interaction and portfolio management workflows
     *
     * @param model Model object for view data binding and template rendering
     *              Provides data binding capabilities for investment web interface
     * @return View name for investment management home page template
     *         Provides investment management dashboard for user interaction
     */
    @GetMapping("/")  // Spring Boot: HTTP GET mapping for investment home page
    // Defines endpoint for investment management dashboard access
    public String home(Model model) {
        // Spring Boot: Add attributes to model for home page template rendering
        // Provides data binding for investment management dashboard display
        model.addAttribute("title", "Investment Proposal Management System");
        model.addAttribute("description", "Manage investment proposals and portfolio analysis");

        // Spring Boot: Return view name for investment management home page
        // Provides investment management dashboard template for user interaction
        return "index";
    }

    /**
     * Investment proposals page endpoint for investment portfolio management
     * Spring Boot: GET endpoint for investment proposals management interface
     * Provides investment portfolio management and proposal listing interface
     * Supports investment user interaction and portfolio analysis workflows
     *
     * @param model Model object for view data binding and template rendering
     *              Provides data binding capabilities for investment proposals interface
     * @return View name for investment proposals management page template
     *         Provides investment portfolio management interface for user interaction
     */
    @GetMapping("/proposals")  // Spring Boot: HTTP GET mapping for investment proposals page
    // Defines endpoint for investment portfolio management access
    public String proposals(Model model) {
        // Spring Boot: Add attributes to model for proposals page template rendering
        // Provides data binding for investment portfolio management display
        model.addAttribute("title", "Investment Proposals");
        model.addAttribute("description", "View and manage investment proposals");

        // Spring Boot: Return view name for investment proposals management page
        // Provides investment portfolio management template for user interaction
        return "proposals";
    }
}