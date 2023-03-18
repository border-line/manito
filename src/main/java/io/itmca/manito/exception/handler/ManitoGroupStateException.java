package io.itmca.manito.exception.handler;

public abstract class ManitoGroupStateException extends RuntimeException {
    protected ManitoGroupStateException(String msg) {
        super(msg);
    }
}
