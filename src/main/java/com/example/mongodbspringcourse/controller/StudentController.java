package com.example.mongodbspringcourse.controller;

import com.example.mongodbspringcourse.model.Student;
import com.example.mongodbspringcourse.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/getById/{id}")
    public Student getStudentById(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable String id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping("/studentsByName/{name}")
    public List<Student> studentsByName(@PathVariable String name) {
        return studentService.getStudentsByName(name);
    }

    @GetMapping("/studentsByNameAndEmail")
    public List<Student> studentsByNameAndEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.studentsByNameAndEmail(name, email);
    }

    @GetMapping("/studentsByNameOrEmail")
    public List<Student> studentsByNameOrEmail(@RequestParam String name, @RequestParam String email) {
        return studentService.studentsByNameOrEmail(name, email);
    }

    @GetMapping("/allWithPagination")
    public List<Student> getAllWithPagination(@RequestParam int pageNo, @RequestParam int pageSize){
        return studentService.getAllWithPagination(pageNo, pageSize);
    }
    @GetMapping("/allWithSorting")
    public List<Student> getAllWithSorting(){
        return studentService.getAllWithSorting();
    }

    @GetMapping("/byDepartmentName")
    public List<Student> byDepartmentName(@RequestParam String deptName){
        return studentService.byDepartmentName(deptName);
    }

    @GetMapping("/bySubjectName")
    public List<Student> bySubjectName(@RequestParam String subName){
        return studentService.bySubjectName(subName);
    }

    @GetMapping("/emailLike")
    public List<Student> emailLike(@RequestParam String email){
        return studentService.emailLike(email);
    }

    @GetMapping("/nameStartsWith")
    public List<Student> nameStartsWith(@RequestParam String name){
        return studentService.nameStartsWith(name);
    }

}
