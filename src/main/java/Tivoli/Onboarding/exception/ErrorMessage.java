package Tivoli.Onboarding.exception;

import java.time.LocalDateTime;

public record ErrorMessage(
        LocalDateTime timestamp,
        String message,
        String path

){}
