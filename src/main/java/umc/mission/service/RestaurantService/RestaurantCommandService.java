package umc.mission.service.RestaurantService;

import umc.mission.domain.Restaurant;
import umc.mission.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {

    Restaurant CreateRestaurant(RestaurantRequestDTO.createDTO request);
}
