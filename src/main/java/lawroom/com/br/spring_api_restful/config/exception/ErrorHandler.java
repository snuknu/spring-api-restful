package lawroom.com.br.spring_api_restful.config.exception;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.auth0.jwt.exceptions.JWTCreationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.validation.FieldError;

@RestControllerAdvice
public class ErrorHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity<?> handleError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleError400(MethodArgumentNotValidException ex) {

    var errors = ex.getFieldErrors();

    return ResponseEntity.badRequest()
        .body(errors.stream().map(ArgumentNotValidError::new).toList());
  }

  @ExceptionHandler(JWTCreationException.class)
  public ResponseEntity<?> handleError400(JWTCreationException ex) {
    return ResponseEntity.badRequest().body(new ErrorDto("125", "..."));
  }


  private record ArgumentNotValidError(String field, String message) {
    public ArgumentNotValidError(FieldError field) {
      this(field.getField(), field.getDefaultMessage());
    }
  }

  private record ErrorDto(String code, String message) {

  }

}
