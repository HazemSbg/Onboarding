package Tivoli.Onboarding.NewHires;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewHiresResponseDto {

    private Long id;
    private String code;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String position;
    private String department;
    private String manager;
    private LocalDate dateOfJoining;
    private String photoPath;
    private String degree;

}
