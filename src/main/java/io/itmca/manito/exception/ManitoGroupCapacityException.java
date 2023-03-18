package io.itmca.manito.exception;

import io.itmca.manito.exception.handler.ManitoGroupStateException;

public class ManitoGroupCapacityException extends ManitoGroupStateException {
    public ManitoGroupCapacityException(int capacity, int current) {
        super(String.format("Current participants: %d is not equal to capacity of manito group: %d", current, capacity));
    }
}
