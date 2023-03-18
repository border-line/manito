package io.itmca.manito.service;

import io.itmca.manito.entity.ManitoGroup;
import io.itmca.manito.exception.ManitoGroupNotFoundException;
import io.itmca.manito.repository.ManitoGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManitoGroupQueryService {
    private final ManitoGroupRepository manitoGroupRepository;

    public ManitoGroup findById(String manitoGroupId) {
        return manitoGroupRepository.findById(manitoGroupId).orElseThrow(() -> new ManitoGroupNotFoundException(manitoGroupId));
    }
}
