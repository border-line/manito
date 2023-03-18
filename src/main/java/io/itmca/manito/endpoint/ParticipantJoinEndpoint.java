package io.itmca.manito.endpoint;

import io.itmca.manito.endpoint.request.ParticipantJoinDTO;
import io.itmca.manito.endpoint.response.ParticipantJoinResponse;
import io.itmca.manito.service.ParticipantJoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ParticipantJoinEndpoint {
    private final ParticipantJoinService participantJoinService;

    @PostMapping
    public String createParticipant(ParticipantJoinDTO participantJoinDTO, String manitoGroupId) {
        var justJoinedParticipant = participantJoinService.joinManitoGroup(participantJoinDTO.toParticipant(), manitoGroupId);

        return ParticipantJoinResponse.from(justJoinedParticipant);
    }
}
