package umc.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.mission.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Long> {
}
