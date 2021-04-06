package com.spring_react;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Loader implements CommandLineRunner {
    
    private final Repository repo;

    @Autowired
    public Loader(Repository repo){
        this.repo=repo;
    }

    @Override
    public void run(String... args) throws Exception {
        Criteria c1 = new Criteria("IAAS", "AWS", "EC2", "S3");
        Criteria c2 = new Criteria("IAAS", "GCP", "Compute Storage", "VPN");
        Criteria c3 = new Criteria("Security", "GCP", "Bigquery", "splunk");
        Criteria c4 = new Criteria("Data", "AWS", "Kenisis", "EC2");
        Criteria c5 = new Criteria("Integration", "AWS", "VPN", "on-prems component");

        this.repo.save(c1);
        this.repo.save(c2);
        this.repo.save(c3);
        this.repo.save(c4);
        this.repo.save(c5);
    }
    
}
