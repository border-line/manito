package io.itmca.manito.endpoint.request;

import io.itmca.manito.entity.Participant;

public class ParticipantJoinDTO {
    private String name;
    private String nickName;

    public Participant toParticipant() {
        return Participant.builder()
                .name(this.name)
                .nickName(this.nickName)
                .build();
    }
}
