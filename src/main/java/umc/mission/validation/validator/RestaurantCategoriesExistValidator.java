package umc.mission.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.mission.common.apiPayload.code.status.ErrorStatus;
import umc.mission.domain.RestaurantCategory;
import umc.mission.repository.FoodTypeRepository;
import umc.mission.repository.RestaurantCategoryRepository;
import umc.mission.validation.annotation.ExistCategories;
import umc.mission.validation.annotation.ExistRestaurantCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
@RequiredArgsConstructor
public class RestaurantCategoriesExistValidator implements ConstraintValidator<ExistRestaurantCategories, Long> {

    private final RestaurantCategoryRepository restaurantCategoryRepository;

    @Override
    public void initialize(ExistRestaurantCategories constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantCategoryRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_CATEGORY_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}