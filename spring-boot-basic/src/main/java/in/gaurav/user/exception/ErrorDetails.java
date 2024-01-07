package in.gaurav.user.exception;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class ErrorDetails {
    private LocalDateTime timeStamp = LocalDateTime.now();
    @NonNull
    private String message;
    @NonNull
    private String details;
}
