package com.bytecodevelocity.controller;

import com.bytecodevelocity.model.Book;
import com.bytecodevelocity.model.Student;
import com.bytecodevelocity.service.StudentDao;
import com.bytecodevelocity.service.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentDao dao;
    @Autowired
    StudentRepository repo;
    @PostMapping("saveStudent")
    public void saveStudent(@RequestBody Student student){
        dao.insertStudent(student);
    }

    @PostMapping("persistStudent")
    public void persistStudent(@RequestBody Student student){
        repo.save(student);
    }

    @GetMapping("allStudent")
    public List<Student> getAllStudent(){
        return repo.findAll();
    }

    @GetMapping("getStudentById/{id}")
    public Student getAllStudent(@PathVariable long id){
        Optional<Student> byId = repo.findById(id);
        return byId.get();
    }
    @GetMapping("getBooksById/{id}")
    public List<Book> getBooksById(@PathVariable Long id){
        Student byId = repo.getById(id);
        return byId.getAllBooks();
    }
    @GetMapping("getAllBooks")
    public List<Student> getAllBooks(){
        return repo.findAll();
    }
}
