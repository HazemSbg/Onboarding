package Tivoli.Onboarding.newhire.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class NewHireResponseDTO {

    private Long id;
    private Integer code;
    private String fullName;
    private String email;
    private String position;
    private String department;
    private String manager;
    private LocalDate dateOfJoining;
    private String degree;
    private String photoUrl;
}
