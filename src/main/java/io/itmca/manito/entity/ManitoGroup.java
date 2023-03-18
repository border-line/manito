package io.itmca.manito.entity;

import io.itmca.manito.exception.ManitoGroupCapacityException;
import io.itmca.manito.type.ManitoGroupStatus;
import io.itmca.manito.util.ManitoShuffleUtil;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class ManitoGroup {
    @Id
    @GeneratedValue
    private Long id;
    private String adminId;
    private ManitoGroupStatus status;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private int capacity;
    @Getter
    @OneToMany(mappedBy = "manitoGroup")
    private List<Participant> participants;

    public boolean is(ManitoGroupStatus status) {
        return this.status == status;
    }

    /**
     * @throws ManitoGroupCapacityException 마니또 그룹에 설정된 인원이 이미 다 찬 경우 발생
     **/
    public void receive(Participant participant) {
        if (capacity != participants.size()) {
            throw new ManitoGroupCapacityException(capacity, participants.size());
        }

        participants.add(participant);

        if (canReady()) {
            ManitoShuffleUtil.shuffleManito(participants);
            status = ManitoGroupStatus.READY;
        }
    }

    public boolean canReady() {
        return status == ManitoGroupStatus.RECRUIT && capacity == participants.size();
    }
}
