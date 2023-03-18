package io.itmca.manito.exception;

import io.itmca.manito.exception.handler.NotFoundException;

public class ManitoGroupNotFoundException extends NotFoundException {

    public ManitoGroupNotFoundException(String manitoGroupId) {
        super(String.format("ManitoGroup: %s is not found", manitoGroupId));
    }
}
