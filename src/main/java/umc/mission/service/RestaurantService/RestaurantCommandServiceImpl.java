package umc.mission.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.common.apiPayload.code.status.ErrorStatus;
import umc.mission.common.apiPayload.exception.handler.RegionHandler;
import umc.mission.common.apiPayload.exception.handler.RestaurantCategoryHandler;
import umc.mission.converter.RestaurantConverter;
import umc.mission.domain.Region;
import umc.mission.domain.Restaurant;
import umc.mission.domain.RestaurantCategory;
import umc.mission.repository.RegionRepository;
import umc.mission.repository.RestaurantCategoryRepository;
import umc.mission.repository.RestaurantRepository;
import umc.mission.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    private final RegionRepository regionRepository;

    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @Override
    @Transactional
    public Restaurant CreateRestaurant(RestaurantRequestDTO.createDTO request) {
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        Region region = regionRepository.findById(request.getRegion()).orElseThrow(()-> new RegionHandler(ErrorStatus.REGION_NOT_FOUND));
        RestaurantCategory restaurantCategory = restaurantCategoryRepository.findById(request.getRestaurantCategory()).orElseThrow(()->new RestaurantCategoryHandler(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND));

        newRestaurant.setRegion(region);
        newRestaurant.setRestaurantCategory(restaurantCategory);

        return restaurantRepository.save(newRestaurant);
    }
}
