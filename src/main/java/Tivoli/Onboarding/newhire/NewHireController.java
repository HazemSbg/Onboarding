package Tivoli.Onboarding.newhire;

import Tivoli.Onboarding.newhire.dto.NewHireMapper;
import Tivoli.Onboarding.newhire.dto.NewHireRequestDTO;
import Tivoli.Onboarding.newhire.dto.NewHireResponseDTO;
import Tivoli.Onboarding.storage.PhotoStorageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/new-hires")
@RequiredArgsConstructor
public class NewHireController {

    private final NewHireService service;
    private final PhotoStorageService photoStorage;
    private final NewHireMapper mapper;

    // Create
    @PostMapping
    public ResponseEntity<NewHireResponseDTO> create(
            @Valid @ModelAttribute NewHireRequestDTO requestDTO,
            @RequestPart(required = false) MultipartFile photo) {

        NewHires hire = mapper.toEntity(requestDTO);
        NewHires saved = service.create(hire);

        if (photo != null && !photo.isEmpty()) {
            String path = photoStorage.savePhoto(saved.getCode(), photo);
            saved.setPhotoPath(path);
            service.update(saved.getCode(), saved);
        }

        return ResponseEntity.ok(mapper.toResponse(saved));
    }

    // Get all
    @GetMapping
    public ResponseEntity<List<NewHireResponseDTO>> getAll() {
        return ResponseEntity.ok(
                service.getAll().stream().map(mapper::toResponse).toList()
        );
    }

    // Get by code
    @GetMapping("/{code}")
    public ResponseEntity<NewHireResponseDTO> getByCode(@PathVariable Integer code) {
        return ResponseEntity.ok(mapper.toResponse(service.getByCode(code)));
    }

    // Update
    @PutMapping("/{code}")
    public ResponseEntity<NewHireResponseDTO> update(
            @PathVariable Integer code,
            @Valid @RequestBody NewHireRequestDTO requestDTO) {

        NewHires existing = service.getByCode(code);
        mapper.updateEntity(existing, requestDTO);
        NewHires updated = service.update(code, existing);
        return ResponseEntity.ok(mapper.toResponse(updated));
    }

    // Delete
    @DeleteMapping("/{code}")
    public ResponseEntity<String> delete(@PathVariable Integer code) {
        service.delete(code);
        return ResponseEntity.ok("New hire deleted with code: " + code);
    }
}
