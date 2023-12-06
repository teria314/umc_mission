package umc.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.domain.Mission;
import umc.mission.domain.Review;

public interface MissionRepository extends JpaRepository<Mission,Long> {
}
