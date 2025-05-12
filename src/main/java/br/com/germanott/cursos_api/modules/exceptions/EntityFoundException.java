package br.com.germanott.cursos_api.modules.exceptions;

public class EntityFoundException extends RuntimeException {

    public EntityFoundException(String message) {
        super(message);
    }

}
