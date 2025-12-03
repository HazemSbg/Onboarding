package Tivoli.Onboarding.newHires;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NewHireRepository extends JpaRepository {

    boolean existsByCode(Integer code);
    boolean existsByEmail(String email);
    Optional<NewHires> findByCode(Integer code);


    NewHires getByCode(Integer code);
}
