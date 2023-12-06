package umc.mission.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.mission.common.apiPayload.ApiResponse;
import umc.mission.converter.RestaurantConverter;
import umc.mission.converter.ReviewConverter;
import umc.mission.domain.Restaurant;
import umc.mission.domain.Review;
import umc.mission.service.RestaurantService.RestaurantCommandService;
import umc.mission.validation.annotation.ExistRestaurant;
import umc.mission.web.dto.RestaurantRequestDTO;
import umc.mission.web.dto.RestaurantResponseDTO;
import umc.mission.web.dto.ReviewRequestDTO;
import umc.mission.web.dto.ReviewResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantRestController {

    private final RestaurantCommandService restaurantCommandService;

    @PostMapping("/")
    public ApiResponse<RestaurantResponseDTO.createResultDTO> create(@RequestBody @Valid RestaurantRequestDTO.createDTO request){
        Restaurant restaurant =restaurantCommandService.CreateRestaurant(request);
        return ApiResponse.onSuccess(RestaurantConverter.toCreateResultDTO(restaurant));
    }

    @PostMapping("/{id}/reviews")
    public ApiResponse<ReviewResponseDTO.createResultDTO> createReview(@RequestBody @Valid ReviewRequestDTO.createDTO request, @ExistRestaurant @PathVariable Long id){
        Review review = restaurantCommandService.createReview(request, id);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDTO(review));
    }
}
