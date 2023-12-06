package umc.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.domain.RestaurantCategory;

public interface RestaurantCategoryRepository extends JpaRepository<RestaurantCategory, Long> {
}
