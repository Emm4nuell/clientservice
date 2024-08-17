package br.com.clientservice.adapters.output.exception;

import br.com.clientservice.application.domain.exception.BusinessExceptoin;
import br.com.clientservice.application.domain.exception.CpfAlreadyExistsException;
import br.com.clientservice.application.domain.exception.UserNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLNonTransientConnectionException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptonHandler {

    @ExceptionHandler(BusinessExceptoin.class)
    public ResponseEntity<Map<String, Object>> handleBusinessExceptoin(BusinessExceptoin exception, HttpServletRequest http){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createError(
                HttpStatus.NOT_FOUND,
                "O recurso solicitado não foi encontrado",
                exception.getMessage(),
                http.getServletPath()
        ));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleUserNotFoundException(UserNotFoundException exception, HttpServletRequest http){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createError(
                HttpStatus.NOT_FOUND,
                "O recurso solicitado não foi encontrado",
                exception.getMessage(),
                http.getServletPath()
        ));
    }

    @ExceptionHandler(CpfAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleCpfAlreadyExistsException(CpfAlreadyExistsException exception, HttpServletRequest http){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createError(
                HttpStatus.NOT_FOUND,
                "O recurso solicitado não foi encontrado",
                exception.getMessage(),
                http.getServletPath()
        ));
    }

    @ExceptionHandler(DataAccessException.class)
    public ResponseEntity<Map<String, Object>> handleDataAccessException(DataAccessException exception, HttpServletRequest http){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Internal Server Error",
                exception.getMessage(),
                http.getServletPath()
        ));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFoundException(EntityNotFoundException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(createError(
                HttpStatus.NOT_FOUND,
                "Resource Not Found",
                exception.getMessage(),
                request.getServletPath()
        ));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, Object>> handleConstraintViolationException(org.hibernate.exception.ConstraintViolationException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createError(
                HttpStatus.BAD_REQUEST,
                "Constraint Violation",
                exception.getConstraintName(),
                request.getServletPath()
        ));
    }

    @ExceptionHandler(SQLNonTransientConnectionException.class)
    public ResponseEntity<Map<String, Object>> handleSQLNonTransientConnectionException(SQLNonTransientConnectionException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(createError(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Database Connection Error",
                exception.getMessage(),
                request.getServletPath()
        ));
    }

    @ExceptionHandler(CannotCreateTransactionException.class)
    public ResponseEntity<Map<String, Object>> handleCannotCreateTransactionException(CannotCreateTransactionException exception, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(createError(
                HttpStatus.SERVICE_UNAVAILABLE,
                "Transaction Error",
                exception.getMessage(),
                request.getServletPath()
        ));
    }

    public Map<String, Object> createError(HttpStatus status, String mserror, String message, String path){
        Map<String, Object> error = new HashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", status);
        error.put("error", mserror);
        error.put("message", message);
        error.put("path", path);
        return error;
    }
}
