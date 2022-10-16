package com.til.autocommit.controller;

import com.til.autocommit.dto.StudentReqDto;
import com.til.autocommit.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class StudentController {
    //TODO Custom Exception 및 Exception Handler 구현 필요!


    private final StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<?> saveStudents(@RequestBody StudentReqDto studentReqDto) {

        return studentService.saveStudents(studentReqDto);
    }

    //TODO Put VS POST 의 차이
    @PutMapping("/students/{studentId}")
    public ResponseEntity<?> updateStudents(@PathVariable Long studentId, @RequestBody StudentReqDto studentReqDto) {

        return studentService.updateStudents(studentId, studentReqDto);
    }

    /*TODO PathVariable 과 RequestParam의 차이
    JPA Sort
     */
    @GetMapping("/students")
    public ResponseEntity<?> searchStudents(@RequestParam(value = "name", required = false) String name,
                                            @RequestParam(value = "grade", required = false) Integer grade,
                                            @RequestParam(value = "sort", required = false, defaultValue = "name") String sort,
                                            @RequestParam(value = "method", required = false, defaultValue = "ASC") String method) {

        return studentService.searchStudents(name, grade, sort, method);
    }
}
