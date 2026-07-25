package com.innovera.coursemanagementsystem.Serviceimpl;

import com.innovera.coursemanagementsystem.dto.InstructorRequestDTO;
import com.innovera.coursemanagementsystem.dto.InstructorResponseDTO;
import com.innovera.coursemanagementsystem.entity.Instructor;
import com.innovera.coursemanagementsystem.exception.InstructorNotFoundException;
import com.innovera.coursemanagementsystem.mapper.InstructorMapper;
import com.innovera.coursemanagementsystem.repository.InstructorRepository;
import com.innovera.coursemanagementsystem.service.InstructorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorMapper instructorMapper;

    public InstructorServiceImpl(InstructorRepository instructorRepository, InstructorMapper instructorMapper) {
        this.instructorRepository = instructorRepository;
        this.instructorMapper = instructorMapper;
    }

    private Instructor getInstructorEntity(Long id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new InstructorNotFoundException(id));
    }

    @Override
    public InstructorResponseDTO createInstructor(InstructorRequestDTO dto) {
        Instructor instructor = instructorMapper.toEntity(dto);
        Instructor saved = instructorRepository.save(instructor);
        return instructorMapper.toResponseDTO(saved);
    }

    @Override
    public InstructorResponseDTO getInstructorById(Long id) {
        return instructorMapper.toResponseDTO(getInstructorEntity(id));
    }

    @Override
    public List<InstructorResponseDTO> getAllInstructors() {
        return instructorMapper.toResponseDTOList(instructorRepository.findAll());
    }

    @Override
    public InstructorResponseDTO updateInstructor(Long id, InstructorRequestDTO dto) {

        Instructor instructor = getInstructorEntity(id);
        instructorMapper.updateEntityFromDto(dto , instructor);
        Instructor updated = instructorRepository.save(instructor);
        return instructorMapper.toResponseDTO(updated);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepository.delete(getInstructorEntity(id));
    }
}