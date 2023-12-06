package umc.mission.validation.validator;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.mission.common.apiPayload.code.status.ErrorStatus;
import umc.mission.repository.RestaurantCategoryRepository;
import umc.mission.repository.RestaurantRepository;
import umc.mission.validation.annotation.ExistRestaurant;
import umc.mission.validation.annotation.ExistRestaurantCategories;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class RestaurantExistValidator implements ConstraintValidator<ExistRestaurant, Long> {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void initialize(ExistRestaurant constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = restaurantRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.RESTAURANT_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }
}