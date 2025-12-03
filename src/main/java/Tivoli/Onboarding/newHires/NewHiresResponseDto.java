package Tivoli.Onboarding.newHires;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewHiresResponseDto {

    private Long id;
    private Integer code;
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
    private String photoUrl;


}
