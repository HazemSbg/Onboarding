package Tivoli.Onboarding.newHires;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "New_Hires")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewHires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(nullable = true)
    private String middleName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false, length = 6)
    private Integer code;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String manager;

    @Column(name = "date_of_join", nullable = false)
    private LocalDate dateOfJoining;

    @Column(nullable = false)
    private String degree;

    @Column(name = "photo_path", nullable = true)
    private String photoFilename;
}
