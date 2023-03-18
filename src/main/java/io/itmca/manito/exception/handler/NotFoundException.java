package io.itmca.manito.exception.handler;

public abstract class NotFoundException extends RuntimeException {
    protected NotFoundException(String msg) {
        super(msg);
    }
}
