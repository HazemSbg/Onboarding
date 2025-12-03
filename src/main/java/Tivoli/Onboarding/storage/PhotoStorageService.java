package Tivoli.Onboarding.storage;

import org.springframework.web.multipart.MultipartFile;

public interface PhotoStorageService {
    String savePhoto(Integer newHireCode, MultipartFile file);
}
