package io.itmca.manito.service;

import io.itmca.manito.entity.Participant;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParticipantJoinService {
    private final ManitoGroupQueryService manitoGroupQueryService;

    @Transactional
    public Participant joinManitoGroup(Participant participant, String manitoGroupId) {
        var manitoGroup = manitoGroupQueryService.findById(manitoGroupId);

        participant.join(manitoGroup);

        return participant;
    }
}
