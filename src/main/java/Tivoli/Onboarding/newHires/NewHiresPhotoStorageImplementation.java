package Tivoli.Onboarding.newHires;

import Tivoli.Onboarding.Exception.InvalidFileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class NewHiresPhotoStorageImplementation implements NewHiresPhotoStorage {

    private final String photoDirectory =
            "C:/Users/IT User/OneDrive - TIVOLI GROUP/Desktop/Hazem/NewHiresPhotoDirectory";

    @Override
    public String savePhoto(Integer newHireCode, MultipartFile photo) {

        if (photo == null || photo.isEmpty()) {
            throw new InvalidFileException("Photo is invalid");
        }

        File directory = new File(photoDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // safe filename to avoid collisions
        String filename = newHireCode + "-" + UUID.randomUUID() + "-" + photo.getOriginalFilename();

        File pic = new File(directory, filename);

        try {
            photo.transferTo(pic);
        } catch (IOException e) {
            throw new RuntimeException("Photo save failed: " + e.getMessage());
        }

        return filename; // store only the filename
    }
}
