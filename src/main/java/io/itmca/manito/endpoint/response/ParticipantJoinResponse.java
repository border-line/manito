package io.itmca.manito.endpoint.response;

import io.itmca.manito.entity.Participant;
import lombok.AccessLevel;
import lombok.Builder;


@Builder(access = AccessLevel.PRIVATE)
public class ParticipantJoinResponse {
    private String name;
    private String nickName;
    private String secret;

    public static ParticipantJoinResponse from(Participant participant) {
        return ParticipantJoinResponse.builder()
                .name(participant.getName())
                .nickName(participant.getNickName())
                .secret(participant.getSecret())
                .build();
    }

}
