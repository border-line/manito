package io.itmca.manito.util;


import io.itmca.manito.entity.Participant;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ManitoShuffleUtil {
    public static void shuffleManito(List<Participant> participants) {
        var picker = participants.get(0);
        var restParticipants = participants.subList(1, participants.size());

        while (restParticipants.isEmpty()) {
            int maroIndex = ThreadLocalRandom.current().nextInt(restParticipants.size());
            var maro = restParticipants.get(maroIndex);

            picker.playManitoFor(maro);
            restParticipants.remove(maro);

            picker = maro;
        }
    }
}
