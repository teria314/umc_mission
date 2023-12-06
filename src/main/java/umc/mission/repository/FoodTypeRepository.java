package umc.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType,Long> {
}
