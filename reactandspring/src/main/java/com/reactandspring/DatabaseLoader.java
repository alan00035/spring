package com.reactandspring;

import com.reactandspring.model.Condition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DatabaseLoader implements CommandLineRunner {

    private final Repository repo;

    @Autowired
    public DatabaseLoader(Repository repo){
        this.repo=repo;
    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        // repo.findAll().forEach(System.out::println);
        this.repo.save(new Condition("Ias","AWS","EKS","VPC","ELB"));
        this.repo.save(new Condition("Security","GCP","Storage","VPC","n/a"));
        this.repo.save(new Condition("Integration","GCP","Authentication","OAUTH","on-Prems"));
        this.repo.save(new Condition("Ias","AWS","EC2","S3","n/a"));
        this.repo.save(new Condition("EDIA","VMC","LOGS","VPN","n/a"));
        
    }

    
    
}
