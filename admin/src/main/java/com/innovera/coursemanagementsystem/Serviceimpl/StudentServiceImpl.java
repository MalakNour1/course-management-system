package com.innovera.coursemanagementsystem.Serviceimpl;

import com.innovera.coursemanagementsystem.entity.Student;
import com.innovera.coursemanagementsystem.exception.StudentNotFoundException;
import com.innovera.coursemanagementsystem.mapper.StudentMapper;
import com.innovera.coursemanagementsystem.repository.StudentRepository;
import com.innovera.coursemanagementsystem.service.StudentService;
import org.springframework.stereotype.Service;
import com.innovera.coursemanagementsystem.dto.StudentRequestDTO;
import com.innovera.coursemanagementsystem.dto.StudentResponseDTO;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepository studentRepository,
                              StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) {

        Student student = studentMapper.toEntity(dto);

        Student savedStudent = studentRepository.save(student);

        return studentMapper.toResponseDTO(savedStudent);
    }

    @Override
    public StudentResponseDTO getStudentById(Long id) {
        return studentMapper.toResponseDTO(getStudentEntity(id));
    }


    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentMapper.toResponseDTOList(studentRepository.findAll());
    }

    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = getStudentEntity(id);
        studentMapper.updateEntityFromDto(dto, student);
        Student updated = studentRepository.save(student);
        return studentMapper.toResponseDTO(updated);
    }

    @Override
    public Student getStudentEntity(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public void deleteStudent(Long id) {
        Student student = getStudentEntity(id);
        studentRepository.delete(student);
    }
}
