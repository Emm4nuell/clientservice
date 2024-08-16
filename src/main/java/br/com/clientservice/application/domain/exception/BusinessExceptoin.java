package br.com.clientservice.application.domain.exception;

public class BusinessExceptoin extends RuntimeException {
    public BusinessExceptoin(String message) {
        super(message);
    }
}
