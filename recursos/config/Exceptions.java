package com.example.recursos.com.example.recursos.config;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class Exceptions {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity exception400(MethodArgumentNotValidException exception) {
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DadosErroValidacao::new).toList());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity exception404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity exception500(NullPointerException exception) {
        String errorMessage = "Erro interno. Tente novamente mais tarde";
        return ResponseEntity.internalServerError().body(errorMessage);
    }

    private record DadosErroValidacao (String campo, String mensagem) {
        public DadosErroValidacao(FieldError erro) {
            this(erro.getField(), erro.getDefaultMessage());
        }
    }
}