package by.bsuir.fanficsbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponseDTO handleValidationException(ValidationException exception) {
        return new ErrorResponseDTO(parseErrorCodes(exception.getBindingResult()));
    }

    @ExceptionHandler(JwtAuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponseDTO handleAuthenticationException(JwtAuthenticationException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleResourceNotFoundException(ResourceNotFoundException exception) {
        return new ErrorResponseDTO(exception.getMessage());
    }

    private String parseErrorCodes(BindingResult bindingResult) {
        String errorCode = bindingResult.getAllErrors().get(0).getCodes()[0];
        int endOfErrorMessage = errorCode.indexOf(".");
        return errorCode.substring(0, endOfErrorMessage+1);
    }
}
