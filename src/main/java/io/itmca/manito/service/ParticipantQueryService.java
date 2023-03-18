package io.itmca.manito.service;

import io.itmca.manito.entity.Participant;
import io.itmca.manito.exception.ParticipantNotFoundException;
import io.itmca.manito.repository.ParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantQueryService {
    private final ParticipantRepository participantRepository;

    public Participant findById(Long id) {
        return participantRepository.findById(id).orElseThrow(() -> new ParticipantNotFoundException(id));
    }
}
