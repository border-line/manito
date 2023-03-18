package io.itmca.manito.exception;

import io.itmca.manito.exception.handler.NotFoundException;

public class ParticipantNotFoundException extends NotFoundException {

    public ParticipantNotFoundException(Long participantId) {
        super(String.format("Participant: %s is not found", participantId));
    }
}
