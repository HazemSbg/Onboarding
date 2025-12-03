package Tivoli.Onboarding.NewHires;

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
    public static NewHiresResponseDto toResponse(NewHires newHires) {

        NewHiresResponseDto dto = new NewHiresResponseDto();

        dto.setFirstName(newHires.getFirstName());
        dto.setMiddleName(newHires.getMiddleName());
        dto.setLastName(newHires.getLastName());
        dto.setEmail(newHires.getEmail());
        dto.setPosition(newHires.getPosition());
        dto.setDepartment(newHires.getDepartment());
        dto.setManager(newHires.getManager());
        dto.setDateOfJoining(newHires.getDateOfJoining());
        dto.setPhotoPath(newHires.getPhoto());
        dto.setDegree(newHires.getDegree());

        return dto;
    }
}
