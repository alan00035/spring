package com.reactandspring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.reactandspring.*;
import com.reactandspring.model.Condition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class AppController {

    private final Logger log = LoggerFactory.getLogger(AppController.class);

    private Repository repo;

    @GetMapping("/all")
    public List <Condition> getAllConditions(){
        return (List<Condition>) repo.findAll();
    }

    @PostMapping("/conditions")
    public Condition createRecord(@RequestBody Condition condition){
        return repo.save(condition);
    }

    @GetMapping("/conditions/{id}")
    public ResponseEntity <Condition> getCondition(@PathVariable Long  id){
        Condition condition = repo.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException());
        return ResponseEntity.ok(condition);
            
            }

    @PutMapping("/conditions/{id}")
    public ResponseEntity <Condition > updateRecord (@NonNull @PathVariable Long id,
                                                        @RequestBody Condition conditionDetails){
        Condition condition= repo.findById(id)
                                 .orElseThrow(()-> new ResourceNotFoundException());
                      
        
        condition.setCloudProvider(conditionDetails.getCloudProvider());
        condition.setCondition1(conditionDetails.getCondition1());
        condition.setCondition2(conditionDetails.getCondition2()); 
        condition.setDomainName(conditionDetails.getDomainName());
        condition.setCondition3(conditionDetails.getCondition3());                                              
  
        Condition updateRecord = repo.save(condition);

        return ResponseEntity.ok(updateRecord);
    }

    @DeleteMapping("/condition/{id}")
    public ResponseEntity <Map <String, Boolean>> deletedRecord(@NonNull @PathVariable Long id) {
        Condition condition= repo.findById(id)
                                 .orElseThrow(()-> new ResourceNotFoundException());
        
        repo.delete(condition);
        Map<String,Boolean> response = new HashMap<>();
    
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }



}
