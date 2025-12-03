package Tivoli.Onboarding.NewHires;

import Tivoli.Onboarding.Exception.InvalidFileException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class NewHiresPhotoStorageImplementation implements NewHiresPhotoStorage {

    private final String photoDirectory = "C://Users//IT User//OneDrive - TIVOLI GROUP//Desktop//Hazem//NewHiresPhotoDirectory";

    @Override
    public String savePhoto(String newHireCode, MultipartFile photo) {

        if (photo == null || photo.isEmpty()) {
            throw new InvalidFileException("Photo is invalid");
        }

        // Create a reference to the directory
        File directory = new File(photoDirectory);

        // If the directory doesnt exist create it
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Unique photo name
        String filename = newHireCode + "-" + photo.getOriginalFilename();

        // Final save location
        File pic =  new File(photoDirectory + filename);
        try {
            photo.transferTo(pic);
        } catch (IOException e) {
            throw new RuntimeException("Photo save failed " + e.getMessage());
        }

        return pic.getAbsolutePath();

    }
}
