package Tivoli.Onboarding.newhire;

import Tivoli.Onboarding.exception.DuplicateResourceException;
import Tivoli.Onboarding.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewHireServiceImpl implements NewHireService {

    private final NewHireRepository repo;

    @Override
    public NewHires create(NewHires newHire) {
        if (repo.existsByCode(newHire.getCode())) {
            throw new DuplicateResourceException("New hire code already exists: " + newHire.getCode());
        }
        if (repo.existsByEmail(newHire.getEmail())) {
            throw new DuplicateResourceException("New hire email already exists: " + newHire.getEmail());
        }
        return repo.save(newHire);
    }

    @Override
    public NewHires getByCode(Integer code) {
        return repo.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("New hire not found with code: " + code));
    }

    @Override
    public List<NewHires> getAll() {
        return repo.findAll();
    }

    @Override
    public NewHires update(Integer code, NewHires updated) {
        NewHires existing = getByCode(code);
        updated.setId(existing.getId());
        updated.setCode(code);
        return repo.save(updated);
    }

    @Override
    public void delete(Integer code) {
        NewHires existing = getByCode(code);
        repo.delete(existing);
    }
}
