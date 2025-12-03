package Tivoli.Onboarding.storage;

import Tivoli.Onboarding.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;

@Service
public class PhotoStorageServiceImpl implements PhotoStorageService {

    private final String PHOTO_DIR = System.getProperty("user.home") + "/Pictures/NewHirePhoto/";

    @Override
    public String savePhoto(Integer newHireCode, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new ResourceNotFoundException("Photo file missing");
        }

        File dir = new File(PHOTO_DIR);
        if (!dir.exists()) dir.mkdirs();

        String filename = newHireCode + "-" + file.getOriginalFilename();
        File photo = new File(dir, filename);

        try {
            file.transferTo(photo);
        } catch (IOException e) {
            throw new RuntimeException("Photo save failed: " + e.getMessage());
        }

        return photo.getAbsolutePath();
    }
}
