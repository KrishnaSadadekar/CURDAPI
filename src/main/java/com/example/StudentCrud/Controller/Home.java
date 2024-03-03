package com.example.StudentCrud.Controller;

import java.util.List;

import com.example.StudentCrud.Models.Address;
import com.example.StudentCrud.Models.Student;
import com.example.StudentCrud.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Home {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/")
    public ResponseEntity<?> allStudents() {
        List<Student> ls = studentRepository.findAll().stream().toList();
        return ResponseEntity.ok(ls);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Integer id) {
        try {
            Student student = studentRepository.findById(id).get();
            studentRepository.delete(student);
            return ResponseEntity.ok("Deleted!");
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addstudent")
    public ResponseEntity<?> addStudents(@RequestBody Student student) {
        try {
            System.out.println(student);
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
        try {
            Student old = studentRepository.findById(id).get();
    //      Get Old address and set new values into that address
            Address address = old.getAddress();
            address.setCity(student.getAddress().getCity());
            address.setStreet(student.getAddress().getStreet());
            address.setZipcode(student.getAddress().getZipcode());

            student.setAddress(address);
            student.setId(id);
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
