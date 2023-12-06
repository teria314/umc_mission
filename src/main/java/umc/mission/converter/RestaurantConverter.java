package umc.mission.converter;

import umc.mission.domain.Restaurant;
import umc.mission.web.dto.RestaurantRequestDTO;
import umc.mission.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {
    public static RestaurantResponseDTO.createResultDTO toCreateResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.createResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.createDTO request){
        return Restaurant.builder()
                .address(request.getAddress())
                .name(request.getName())
                .build();
    }
}
