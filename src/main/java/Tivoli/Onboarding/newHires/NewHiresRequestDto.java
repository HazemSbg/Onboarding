package Tivoli.Onboarding.newHires;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewHiresRequestDto {

    @NotBlank
    @Min(6)
    @Max(6)
    private Integer code;

    @NotBlank
    private String firstName;

    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String position;

    @NotBlank
    private String department;

    @NotBlank
    @PastOrPresent
    private LocalDate dateOfJoining;

    @NotBlank
    private String degree;

    @NotBlank private String manager;


}
