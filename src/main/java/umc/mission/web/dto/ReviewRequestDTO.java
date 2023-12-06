package umc.mission.web.dto;

import lombok.Getter;
import umc.mission.validation.annotation.ExistRegion;
import umc.mission.validation.annotation.ExistRestaurantCategories;

public class ReviewRequestDTO {

    @Getter
    public static class createDTO{
        String description;
        Integer star;
    }
}
