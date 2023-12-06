package umc.mission.web.dto;

import lombok.Getter;
import umc.mission.validation.annotation.ExistRegion;
import umc.mission.validation.annotation.ExistRestaurantCategories;

public class RestaurantRequestDTO {

    @Getter
    public static class createDTO{
        String name;
        String address;
        @ExistRegion
        Long region;
        @ExistRestaurantCategories
        Long restaurantCategory;
    }
}
