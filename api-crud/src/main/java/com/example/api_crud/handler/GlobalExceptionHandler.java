package com.example.api_crud.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice  // Define que esta classe será usada para tratar exceções globalmente
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)  // Captura exceções de falha na validação
    @ResponseStatus(HttpStatus.BAD_REQUEST)  // Retorna status 400 (Bad Request) em caso de falha na validação
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Erro de validação");

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            response.put("errors", new Object[]{new ErrorDetails(fieldName, message)});
        });

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);  // Retorna os detalhes do erro
    }

    public static class ErrorDetails {
        private String campo;
        private String mensagem;

        public ErrorDetails(String campo, String mensagem) {
            this.campo = campo;
            this.mensagem = mensagem;
        }

        public String getCampo() {
            return campo;
        }

        public void setCampo(String campo) {
            this.campo = campo;
        }

        public String getMensagem() {
            return mensagem;
        }

        public void setMensagem(String mensagem) {
            this.mensagem = mensagem;
        }
    }
}
