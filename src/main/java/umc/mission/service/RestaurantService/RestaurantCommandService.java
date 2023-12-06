package umc.mission.service.RestaurantService;

import umc.mission.domain.Mission;
import umc.mission.domain.Restaurant;
import umc.mission.domain.Review;
import umc.mission.web.dto.MissionRequestDTO;
import umc.mission.web.dto.RestaurantRequestDTO;
import umc.mission.web.dto.ReviewRequestDTO;

public interface RestaurantCommandService {

    Restaurant CreateRestaurant(RestaurantRequestDTO.createDTO request);
    Review createReview(ReviewRequestDTO.createDTO request, Long restaurantId);
    Mission createMission(MissionRequestDTO.createDTO request, Long restaurantId);
}
