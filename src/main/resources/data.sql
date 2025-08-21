-- Spring Boot: Initial data script for investment proposal management system
-- Sample investment proposals for demonstration and testing purposes

-- Spring Boot: Insert sample investment advisors for investment management
-- Pre-populate investment advisor data for system initialization
INSERT INTO investment_advisors (id, name, email, specialization, created_at) VALUES
                                                                                  (1, 'Alice Johnson', 'alice.johnson@investment.com', 'STOCKS', CURRENT_TIMESTAMP),
                                                                                  (2, 'Bob Smith', 'bob.smith@investment.com', 'BONDS', CURRENT_TIMESTAMP),
                                                                                  (3, 'Carol Davis', 'carol.davis@investment.com', 'REAL_ESTATE', CURRENT_TIMESTAMP);

-- Spring Boot: Insert sample investment proposals for investment portfolio demonstration
-- Pre-populate investment proposal data for system testing and showcase
INSERT INTO investment_proposals (
    proposal_reference, client_name, investment_amount,
    expected_return, risk_level, investment_type,
    assigned_advisor, created_at, approved
) VALUES
      ('INV-001', 'John Doe', 50000.00, 7.5, 'MEDIUM', 'STOCKS', 'Alice Johnson', CURRENT_TIMESTAMP, false),
      ('INV-002', 'Jane Smith', 100000.00, 12.0, 'HIGH', 'REAL_ESTATE', 'Carol Davis', CURRENT_TIMESTAMP, true),
      ('INV-003', 'Bob Johnson', 25000.00, 5.8, 'LOW', 'BONDS', 'Bob Smith', CURRENT_TIMESTAMP, false),
      ('INV-004', 'Alice Brown', 75000.00, 9.2, 'MEDIUM', 'MUTUAL_FUNDS', 'Alice Johnson', CURRENT_TIMESTAMP, true),
      ('INV-005', 'Charlie Wilson', 150000.00, 15.5, 'HIGH', 'STOCKS', 'Carol Davis', CURRENT_TIMESTAMP, false);

-- Spring Boot: Insert investment portfolio categories for investment management
-- Pre-populate investment category data for portfolio analysis
INSERT INTO investment_categories (id, name, description, minimum_investment, risk_level) VALUES
                                                                                              (1, 'Conservative Portfolio', 'Low-risk investment strategy', 10000.00, 'LOW'),
                                                                                              (2, 'Balanced Portfolio', 'Moderate-risk diversified approach', 25000.00, 'MEDIUM'),
                                                                                              (3, 'Aggressive Portfolio', 'High-risk growth-oriented strategy', 50000.00, 'HIGH');