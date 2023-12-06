package umc.mission.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.mission.common.apiPayload.ApiResponse;
import umc.mission.converter.RestaurantConverter;
import umc.mission.domain.Restaurant;
import umc.mission.service.RestaurantService.RestaurantCommandService;
import umc.mission.web.dto.RestaurantRequestDTO;
import umc.mission.web.dto.RestaurantResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.createResultDTO> create(@RequestBody @Valid RestaurantRequestDTO.createDTO request){
        Restaurant restaurant =restaurantCommandService.CreateRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateResultDTO(restaurant));
    }
}
