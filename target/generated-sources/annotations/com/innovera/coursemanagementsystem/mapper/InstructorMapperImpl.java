package com.innovera.coursemanagementsystem.mapper;

import com.innovera.coursemanagementsystem.dto.InstructorRequestDTO;
import com.innovera.coursemanagementsystem.dto.InstructorResponseDTO;
import com.innovera.coursemanagementsystem.entity.Instructor;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-07-25T03:07:30+0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class InstructorMapperImpl implements InstructorMapper {

    @Override
    public Instructor toEntity(InstructorRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Instructor instructor = new Instructor();

        instructor.setName( dto.getName() );
        instructor.setEmail( dto.getEmail() );

        return instructor;
    }

    @Override
    public InstructorResponseDTO toResponseDTO(Instructor instructor) {
        if ( instructor == null ) {
            return null;
        }

        InstructorResponseDTO instructorResponseDTO = new InstructorResponseDTO();

        instructorResponseDTO.setId( instructor.getId() );
        instructorResponseDTO.setName( instructor.getName() );
        instructorResponseDTO.setEmail( instructor.getEmail() );

        return instructorResponseDTO;
    }

    @Override
    public List<InstructorResponseDTO> toResponseDTOList(List<Instructor> instructors) {
        if ( instructors == null ) {
            return null;
        }

        List<InstructorResponseDTO> list = new ArrayList<InstructorResponseDTO>( instructors.size() );
        for ( Instructor instructor : instructors ) {
            list.add( toResponseDTO( instructor ) );
        }

        return list;
    }

    @Override
    public void updateEntityFromDto(InstructorRequestDTO dto, Instructor instructor) {
        if ( dto == null ) {
            return;
        }

        instructor.setName( dto.getName() );
        instructor.setEmail( dto.getEmail() );
    }
}
