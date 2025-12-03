package Tivoli.Onboarding.newhire.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class NewHireRequestDTO {

    @NotNull(message = "Code is required")
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

    private String manager;

    @NotNull
    @PastOrPresent
    private LocalDate dateOfJoining;

    private String degree;
}
