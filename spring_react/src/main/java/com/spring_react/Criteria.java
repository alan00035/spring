package com.spring_react;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Criteria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "cannot be blank")
    private String domain;
    private String cloudProvider;
    private String services;
    
    private String existingComponent;

    
    private Criteria(){};

    public Criteria (String domain, String cloudProvider, String services, String existingCOmponent){
        this.domain = domain;
        this.cloudProvider=cloudProvider;
        this.services=services;
        this.existingComponent =existingCOmponent;
    };

    @Override
    public String toString(){
        return "Criteria{"+
        "domain=" + domain +
        ", cloudProvider='" + cloudProvider + '\'' +
        ", service='" + services + '\'' +
        ", existingComponent='" + existingComponent + '\'' +
        '}';
    }

    public String getDomain() {
        return this.domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCloudProvider() {
        return this.cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getServices() {
        return this.services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getExistingComponent() {
        return this.existingComponent;
    }

    public void setExistingComponent(String existingComponent) {
        this.existingComponent = existingComponent;
    }




}
