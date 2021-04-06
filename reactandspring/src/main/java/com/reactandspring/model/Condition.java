package com.reactandspring.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.NonNull;


@Entity
public class Condition{
    @Id
    @GeneratedValue
    @NonNull
    private Long id;
    private String cloudProvider;  //aws, gcp/azure
    private String domainName;   //iaas; security; integration; etc
    private String condition1;   //authentication
    private String condition2;   //on prems to cloud
    private String condition3;   //cloud to cloud


    private Condition(){};
 
    public Condition ( String domainName, String cloudProvider, String condition1, String condition2, String condition3){
 
        this.domainName = domainName;
        this.cloudProvider = cloudProvider;
        this.condition1 = condition1;
        this.condition2=condition2;
        this.condition3=condition3;
    }


    public Long getID(){
        return this.id;
    }

    public void setID (Long id){
        this.id = id;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getCloudProvider() {
        return this.cloudProvider;
    }

    public void setCloudProvider(String cloudProvider) {
        this.cloudProvider = cloudProvider;
    }

    public String getCondition1() {
        return this.condition1;
    }

    public void setCondition1(String condition1) {
        this.condition1 = condition1;
    }

    public String getCondition2() {
        return this.condition2;
    }

    public void setCondition2(String condition2) {
        this.condition2 = condition2;
    }

    public String getCondition3() {
        return this.condition3;
    }

    public void setCondition3(String condition3) {
        this.condition3 = condition3;
    }



    
}
