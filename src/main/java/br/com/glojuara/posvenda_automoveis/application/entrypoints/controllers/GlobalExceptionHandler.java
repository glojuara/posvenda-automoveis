package br.com.glojuara.posvenda_automoveis.application.entrypoints.controllers;

import br.com.glojuara.posvenda_automoveis.domain.excepctions.ContratoAjuizadoException;
import br.com.glojuara.posvenda_automoveis.domain.excepctions.ContratoEncerradoException;
import br.com.glojuara.posvenda_automoveis.domain.excepctions.NumeroContratoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        // Personalize a mensagem de erro ou log aqui, se necessário
        return new ResponseEntity<>(new ErrorResponse("Erro interno do servidor", ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({ContratoAjuizadoException.class, ContratoEncerradoException.class, NumeroContratoInvalidoException.class })
    public ResponseEntity<Object> handleDomainExceptions(Exception ex) {
        // Personalize a mensagem de erro ou log aqui, se necessário
        return new ResponseEntity<>(new ErrorResponse("Requisição inválida", ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(new ErrorResponse("Erro de validação", errors), HttpStatus.BAD_REQUEST);
    }

    // Classe interna para estrutura de resposta de erro
    public static class ErrorResponse {
        private String message;
        private Object details;

        public ErrorResponse(String message, Object details) {
            this.message = message;
            this.details = details;
        }

        // Getters e setters

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Object getDetails() {
            return details;
        }

        public void setDetails(Object details) {
            this.details = details;
        }
    }
}

