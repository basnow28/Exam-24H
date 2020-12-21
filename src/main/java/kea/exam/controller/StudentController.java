package kea.exam.controller;

import kea.exam.model.Student;
import kea.exam.model.Supervisor;
import kea.exam.repository.StudentRepository;
import kea.exam.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.StubNotFoundException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    SupervisorRepository supervisorRepository;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentRepository.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable int id){
        Student _student = studentRepository.findById(id).get();
        return new ResponseEntity<>(_student, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student _student = studentRepository.save(student);
        Supervisor supervisor = supervisorRepository.findById(student.getSupervisor().getSupervisor_id()).get();
        _student.setSupervisor(supervisor);
        return new ResponseEntity<>(_student, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        studentRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
