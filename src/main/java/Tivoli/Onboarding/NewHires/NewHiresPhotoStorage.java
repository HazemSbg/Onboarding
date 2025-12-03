package Tivoli.Onboarding.NewHires;

import org.springframework.web.multipart.MultipartFile;

public interface NewHiresPhotoStorage {
    String savePhoto(String newHireCode, MultipartFile photo);
}
