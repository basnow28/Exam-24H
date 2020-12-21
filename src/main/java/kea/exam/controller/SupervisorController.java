package kea.exam.controller;

import kea.exam.model.Supervisor;
import kea.exam.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supervisors")
public class SupervisorController {
    @Autowired
    SupervisorRepository supervisorRepository;
    
    @GetMapping
    public ResponseEntity<List<Supervisor>> getAllSupervisors(){
        List<Supervisor> supervisorList = supervisorRepository.findAll();
        return new ResponseEntity<List<Supervisor>>(supervisorList, HttpStatus.OK);
    }
}
