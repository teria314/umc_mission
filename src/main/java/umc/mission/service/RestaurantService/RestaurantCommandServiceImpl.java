package umc.mission.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.mission.common.apiPayload.code.status.ErrorStatus;
import umc.mission.common.apiPayload.exception.handler.RegionHandler;
import umc.mission.common.apiPayload.exception.handler.RestaurantCategoryHandler;
import umc.mission.common.apiPayload.exception.handler.RestaurantHandler;
import umc.mission.converter.MissionConverter;
import umc.mission.converter.RestaurantConverter;
import umc.mission.converter.ReviewConverter;
import umc.mission.domain.*;
import umc.mission.repository.*;
import umc.mission.web.dto.MissionRequestDTO;
import umc.mission.web.dto.RestaurantRequestDTO;
import umc.mission.web.dto.ReviewRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService {

    private final RestaurantRepository restaurantRepository;

    private final RegionRepository regionRepository;

    private final RestaurantCategoryRepository restaurantCategoryRepository;

    private final ReviewRepository reviewRepository;

    private final MissionRepository missionRepository;

    private final MemberRepository memberRepository;

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

    @Override
    @Transactional
    public Review createReview(ReviewRequestDTO.createDTO request, Long restaurantId) {
        Review newReview = ReviewConverter.toReview(request);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));
        Optional<Member> member = memberRepository.findById(Long.valueOf(1));

        newReview.setRestaurant(restaurant);
        newReview.setMember(member.get());

        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public Mission createMission(MissionRequestDTO.createDTO request, Long restaurantId) {
        Mission newMission = MissionConverter.toMission(request);

        Restaurant restaurant = restaurantRepository.findById(restaurantId).orElseThrow(() -> new RestaurantHandler(ErrorStatus.RESTAURANT_NOT_FOUND));

        newMission.setRestaurant(restaurant);

        return missionRepository.save(newMission);
    }
}
