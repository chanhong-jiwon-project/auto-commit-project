package com.til.autocommit.service;

import com.til.autocommit.domain.Student;
import com.til.autocommit.dto.StudentReqDto;
import com.til.autocommit.dto.StudentResDto;
import com.til.autocommit.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public ResponseEntity<?> saveStudents(StudentReqDto studentReqDto) {
        Student student = Student.builder()
                .name(studentReqDto.getName())
                .grade(studentReqDto.getGrade())
                .build();

        return ResponseEntity.ok(studentRepository.save(student));
    }

    /* TODO update 하는 2가지 방법
    1. 더티체킹 ( 변경감지 )
    2. save ( insert + update = upsert )
     */
    @Transactional
    public ResponseEntity<?> updateStudents(Long studentId, StudentReqDto studentReqDto) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new NullPointerException("해당 학생이 존재하지 않습니다.")
        );

        //더티체킹
        student.update(studentReqDto);

        //save
//        studentRepository.save(student);

        return ResponseEntity.ok(student);
    }

    //TODO resDto에 넣어서 return 해주는 이유
    public ResponseEntity<?> searchStudents(String name, Integer grade, String sort, String method) {
        List<StudentResDto> studentDtos = new ArrayList<>();
        List<Student> students = studentRepository.findByNameContainingAndGrade(name, grade, Sort.by(Sort.Direction.fromString(method), sort));

        for (Student student : students) {
            studentDtos.add(StudentResDto.builder()
                    .name(student.getName())
                    .grade(student.getGrade())
                    .build());
        }

        return ResponseEntity.ok(studentDtos);
    }

}
