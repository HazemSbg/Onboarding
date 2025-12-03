package Tivoli.Onboarding.Exception;

import java.time.LocalDateTime;

public record ErrorMessage(
        LocalDateTime timestamp,
        String message,
        String path

){}
