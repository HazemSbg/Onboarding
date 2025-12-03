package Tivoli.Onboarding.NewHires;

import Tivoli.Onboarding.Exception.DuplicateResourceFoundException;
import Tivoli.Onboarding.Exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewHiresServiceImplementation implements NewHiresService {

    private final NewHireRepository newHireRepo;


    // Create new Hire
    @Override
    public NewHires createNewHires(NewHires newHires) {
        if (newHireRepo.existsByCode(newHires.getCode())) {
            throw new DuplicateResourceFoundException("An employee with this code already exists");
        }
        if (newHireRepo.existsByEmail(newHires.getEmail())) {
            throw new DuplicateResourceFoundException("An employee with this email already exists");
        }

        newHireRepo.save(newHires);
        return  newHires;
    }

    // Update
    @Override
    public NewHires updateNewHires(Integer code, NewHires newHires) {
        if (!newHireRepo.existsByCode(code)) {
            throw new ResourceNotFoundException("An employee with this code does not exist");
        }

        NewHires existingHire = newHireRepo.getByCode(code);

        existingHire.setFirstName(newHires.getFirstName());
        existingHire.setMiddleName(newHires.getMiddleName());
        existingHire.setLastName(newHires.getLastName());
        existingHire.setEmail(newHires.getEmail());
        existingHire.setPhoto(newHires.getPhoto());
        existingHire.setDegree(newHires.getDegree());
        existingHire.setPosition(newHires.getPosition());

        return newHireRepo.save(existingHire);

    }

    // Delete
    @Override
    public void deleteNewHires(Integer code) {
        if (!newHireRepo.existsByCode(code)) {
            throw new ResourceNotFoundException("An employee with this code does not exist");
        }

        newHireRepo.delete(code);

    }

    // Get
    @Override
    public NewHires getNewHires(Integer code) {
        if  (!newHireRepo.existsByCode(code)) {
            throw new ResourceNotFoundException("An employee with this code does not exist");
        }

        NewHires newHires = newHireRepo.getByCode(code);

        return newHires;
    }

    // Get All
    @Override
    public List<NewHires> getAllNewHires() {
        List<NewHires> allNewHires = newHireRepo.findAll();
        return allNewHires;
    }
}
