package com.spring_react.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.spring_react.Criteria;
import com.spring_react.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
public class AppController {

    private final Logger log = LoggerFactory.getLogger(AppController.class);

    private Repository repo;

    @PostMapping("/criteria")
    public Criteria createRecord(@RequestBody Criteria c){
        return repo.save(c);
    }

    @GetMapping("/criteria/{id}")
    public ResponseEntity <Criteria> getCondition(@PathVariable Long  id){
        Criteria c = repo.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException());
        return ResponseEntity.ok(c);
            
            }

    @PutMapping("/criteria/{id}")
    public ResponseEntity <Criteria > updateRecord (@NonNull @PathVariable Long id,
                                                        @RequestBody Criteria criteriaDetails){
        Criteria c= repo.findById(id)
                                 .orElseThrow(()-> new ResourceNotFoundException());
                      
        
        c.setDomain(criteriaDetails.getDomain());
        c.setCloudProvider(criteriaDetails.getCloudProvider());                                      
        c.setExistingComponent(criteriaDetails.getExistingComponent());
        c.setServices(criteriaDetails.getServices());

        Criteria updateRecord = repo.save(c);

        return ResponseEntity.ok(updateRecord);
    }

    @DeleteMapping("/criteria/{id}")
    public ResponseEntity <Map <String, Boolean>> deletedRecord(@NonNull @PathVariable Long id) {
        Criteria c= repo.findById(id)
                                 .orElseThrow(()-> new ResourceNotFoundException());
        
        repo.delete(c);
        Map<String,Boolean> response = new HashMap<>();
    
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }


}
