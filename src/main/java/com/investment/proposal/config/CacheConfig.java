package com.investment.proposal.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Investment Cache Configuration Class
 * Spring Boot: Cache configuration for investment data access optimization
 * This class manages investment system caching to improve performance
 * and reduce database load for investment portfolio analysis operations
 */
@Configuration  // Spring Boot: Configuration class annotation for investment caching
// Registers this class as a source of cache configuration beans
@EnableCaching  // Spring Boot: Enable caching mechanisms for investment performance
// Activates Spring caching features for investment data access optimization
public class CacheConfig {

    /**
     * Cache Manager Bean for Investment System
     * Spring Boot: Cache manager configuration for investment performance optimization
     * Provides caching capabilities for investment portfolio analysis and data retrieval
     * Implements investment system caching strategy for improved response times
     *
     * @return CacheManager instance for investment system caching
     *         Provides caching infrastructure for investment data access optimization
     */
    @Bean  // Spring Boot: Bean definition for investment cache manager
    // Registers CacheManager as a managed Spring caching component
    public CacheManager cacheManager() {
        // Spring Boot: Create concurrent map cache manager for investment system
        // Initializes simple in-memory caching for investment portfolio data
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();

        // Spring Boot: Configure cache names for investment system components
        // Defines specific caches for different investment data types and operations
        cacheManager.setCacheNames(java.util.Arrays.asList(
                "investmentProposals",  // Spring Boot: Cache for investment proposal data
                "investmentPortfolio",  // Spring Boot: Cache for investment portfolio analysis
                "investmentAdvisors"    // Spring Boot: Cache for investment advisor information
        ));

        // Spring Boot: Return configured cache manager for investment system
        // Provides caching infrastructure for investment performance optimization
        return cacheManager;
    }
}