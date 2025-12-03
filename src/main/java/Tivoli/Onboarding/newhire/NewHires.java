package Tivoli.Onboarding.newhire;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "new_hires")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class NewHires {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private Integer code;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String position;

    @Column(nullable = false)
    private String department;

    private String manager;

    @Column(nullable = false, name = "date_of_joining")
    private LocalDate dateOfJoining;

    private String degree;

    @Column(name = "photo_path")
    private String photoPath;
}
