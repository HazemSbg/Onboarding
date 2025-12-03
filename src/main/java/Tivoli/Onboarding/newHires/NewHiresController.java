package Tivoli.Onboarding.newHires;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("Onboarding")
@RequiredArgsConstructor
public class NewHiresController {

    private final NewHiresService newHiresService;
    private final NewHiresPhotoStorage newHiresPhotoStorage;


    // Create
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<NewHiresResponseDto> create(
            @RequestPart("dto") @Valid NewHiresRequestDto dto,
            @RequestPart(value = "photo", required = false) MultipartFile photo) {

        NewHires newHires = NewHiresMapper.toEntity(dto);
        NewHires saved = newHiresService.createNewHires(newHires);

        if (photo != null && !photo.isEmpty()) {
            String filename = newHiresPhotoStorage.savePhoto(saved.getCode(), photo);
            saved.setPhotoFilename(filename);
            saved = newHiresService.save(saved); // update DB with filename
        }

        return ResponseEntity.ok(NewHiresMapper.toResponse(saved));
    }

    // Get
    @GetMapping
    public ResponseEntity<List<NewHiresResponseDto>> getAll() {
        List<NewHires> hires = newHiresService.getAllNewHires();
        List<NewHiresResponseDto> dtos = hires.stream()
                .map(NewHiresMapper::toResponse)
                .toList();

        return ResponseEntity.ok(dtos);
    }

}
