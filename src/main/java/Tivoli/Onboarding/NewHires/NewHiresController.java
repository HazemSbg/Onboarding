package Tivoli.Onboarding.NewHires;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("Onboarding")
@RequiredArgsConstructor
public class NewHiresController {

    private final NewHiresService newHiresService;
    private final NewHiresPhotoStorage newHiresPhotoStorage;


    // Create
    @PostMapping
    ResponseEntity<NewHiresResponseDto> create(@RequestPart("dto") @Valid NewHiresRequestDto dto,
                                               @RequestPart(value = "photo", required = false) MultipartFile photo) {
        NewHires newHires = NewHiresMapper.toEntity(dto);
        NewHires saved = newHiresService.createNewHires(newHires);

        if (photo != null && !photo.isEmpty()) {
            String path = newHiresPhotoStorage.savePhoto(saved.getCode(), photo);
        }

        return ResponseEntity.ok(NewHiresMapper.toResponse((saved)));
    }








}
