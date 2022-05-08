package by.bsuir.fanficsbackend.exception;

import org.springframework.validation.BindingResult;

public class ValidationException extends RuntimeException {
    private final BindingResult bindingResult;

    public ValidationException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    ////////////////////////////////
    //
    // Getter & setter
    //
    //////////////////////////////


    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
