package Tivoli.Onboarding.newhire;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NewHireRepository extends JpaRepository<NewHires, Long> {
    boolean existsByCode(Integer code);
    boolean existsByEmail(String email);
    Optional<NewHires> findByCode(Integer code);
}
