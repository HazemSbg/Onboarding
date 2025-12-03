package Tivoli.Onboarding.newHires;

import org.springframework.web.multipart.MultipartFile;

public interface NewHiresPhotoStorage {
    String savePhoto(Integer newHireCode, MultipartFile photo);
}
