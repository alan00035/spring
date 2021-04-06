package com.reactandspring;


import com.reactandspring.model.Condition;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Condition, Long> {
        Condition findByDomainName(String domainName);
        Condition findByCloudProvider(String cloudProvider);
    
}

