package ru.atom.hachaton.advisors;

import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.atom.hachaton.utils.ApiError;

import java.util.Collections;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> illegalArgumentExceptionHandler(IllegalArgumentException exception) {
        log.error(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ApiError(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getLocalizedMessage(),
                        Collections.emptyList()
                )
        );
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ApiError> nullPointExceptionHandler(NullPointerException e) {
        log.error(e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                new ApiError(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Ошибка на стороне сервера.",
                        Collections.emptyList()
                )
        );
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ApiError> feignException(FeignException ex) {
        if (ex.status() == HttpStatus.UNAUTHORIZED.value()) {
            return new ResponseEntity<>((HttpStatus.UNAUTHORIZED));
        }
        return ResponseEntity.ok(
                new ApiError(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Ошибка на стороне сервера.",
                        Collections.emptyList()
                )
        );
    }
}

