package Tivoli.Onboarding.newhire.dto;

import Tivoli.Onboarding.newhire.NewHires;
import org.springframework.stereotype.Component;

@Component
public class NewHireMapper {

    public NewHires toEntity(NewHireRequestDTO dto) {
        return NewHires.builder()
                .code(dto.getCode())
                .firstName(dto.getFirstName())
                .middleName(dto.getMiddleName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .position(dto.getPosition())
                .department(dto.getDepartment())
                .manager(dto.getManager())
                .dateOfJoining(dto.getDateOfJoining())
                .degree(dto.getDegree())
                .build();
    }

    public NewHireResponseDTO toResponse(NewHires hire) {
        String fullName = hire.getFirstName() +
                (hire.getMiddleName() != null ? " " + hire.getMiddleName() : "") +
                " " + hire.getLastName();

        return NewHireResponseDTO.builder()
                .id(hire.getId())
                .code(hire.getCode())
                .fullName(fullName)
                .email(hire.getEmail())
                .position(hire.getPosition())
                .department(hire.getDepartment())
                .manager(hire.getManager())
                .dateOfJoining(hire.getDateOfJoining())
                .degree(hire.getDegree())
                .photoUrl(hire.getPhotoPath())
                .build();
    }

    public void updateEntity(NewHires existing, NewHireRequestDTO dto) {
        existing.setFirstName(dto.getFirstName());
        existing.setMiddleName(dto.getMiddleName());
        existing.setLastName(dto.getLastName());
        existing.setEmail(dto.getEmail());
        existing.setPosition(dto.getPosition());
        existing.setDepartment(dto.getDepartment());
        existing.setManager(dto.getManager());
        existing.setDateOfJoining(dto.getDateOfJoining());
        existing.setDegree(dto.getDegree());
    }
}
