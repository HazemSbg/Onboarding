package Tivoli.Onboarding.newHires;

public class NewHiresMapper {

    // converts request dto to newhires entity
    public static NewHires toEntity(NewHiresRequestDto dto) {
        NewHires newHires = new NewHires();

        newHires.setCode(dto.getCode());
        newHires.setFirstName(dto.getFirstName());
        newHires.setLastName(dto.getLastName());
        newHires.setManager(dto.getManager());
        newHires.setDateOfJoining(dto.getDateOfJoining());
        newHires.setDegree(dto.getDegree());
        newHires.setPosition(dto.getPosition());
        newHires.setDepartment(dto.getDepartment());
        newHires.setEmail(dto.getEmail());

        return newHires;

    }

    // converts Employee Entity to a response dto
    public static NewHiresResponseDto toResponse(NewHires hire) {
        NewHiresResponseDto dto = new NewHiresResponseDto();
        dto.setCode(hire.getCode());
        dto.setFirstName(hire.getFirstName());
        dto.setLastName(hire.getLastName());
        dto.setEmail(hire.getEmail());
        dto.setPosition(hire.getPosition());
        dto.setDepartment(hire.getDepartment());
        dto.setManager(hire.getManager());
        dto.setDateOfJoining(hire.getDateOfJoining());
        dto.setDegree(hire.getDegree());

        if (hire.getPhotoFilename() != null) {
            dto.setPhotoUrl("http://localhost:8080/photos/" + hire.getPhotoFilename());
        }

        return dto;
    }

}
