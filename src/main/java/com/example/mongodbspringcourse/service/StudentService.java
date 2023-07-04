package com.example.mongodbspringcourse.service;

import com.example.mongodbspringcourse.model.Student;
import com.example.mongodbspringcourse.repository.DepartmentRepository;
import com.example.mongodbspringcourse.repository.StudentRepository;
import com.example.mongodbspringcourse.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final DepartmentRepository departmentRepository;
    private final SubjectRepository subjectRepository;

    public Student createStudent(Student student) {
        if(student.getDepartment() != null){
            departmentRepository.save(student.getDepartment());
        }
        if(student.getSubjects() != null && student.getSubjects().size() > 0){
            subjectRepository.saveAll(student.getSubjects());
        }
        return studentRepository.save(student);
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    public String deleteStudent(String id) {
        studentRepository.deleteById(id);
        return "Student has been deleted.";
    }

    public List<Student> getStudentsByName(String name) {
        return studentRepository.getByName(name);
    }

    public List<Student> studentsByNameAndEmail(String name, String email) {
        return studentRepository.findByNameAndEmail(name, email);
    }

    public List<Student> studentsByNameOrEmail(String name, String email) {
        return studentRepository.findByNameOrEmail(name, email);
    }

    public List<Student> getAllWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    public List<Student> getAllWithSorting() {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");

        return studentRepository.findAll(sort);
    }

    public List<Student> byDepartmentName(String deptName) {
        return studentRepository.findByDepartmentDepartmentName(deptName);
    }

    public List<Student> bySubjectName(String subName) {
        return studentRepository.findBySubjectsSubjectName(subName);
    }

    public List<Student> emailLike(String email) {
        return studentRepository.findByEmailLike(email);
    }

    public List<Student> nameStartsWith(String name) {
        return studentRepository.findByNameStartsWith(name);
    }

    public List<Student> byDepartmentId(String deptId) {
        return studentRepository.findByDepartmentId(deptId);
    }
}
