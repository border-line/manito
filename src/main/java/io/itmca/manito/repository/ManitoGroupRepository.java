package io.itmca.manito.repository;

import io.itmca.manito.entity.ManitoGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManitoGroupRepository extends JpaRepository<ManitoGroup, String> {
}
