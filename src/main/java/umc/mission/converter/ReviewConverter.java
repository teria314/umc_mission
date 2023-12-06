package umc.mission.converter;


import umc.mission.domain.Review;
import umc.mission.web.dto.ReviewRequestDTO;
import umc.mission.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.createResultDTO toCreateResultDTO(Review review){
        return ReviewResponseDTO.createResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.createDTO request){
        return Review.builder()
                .description(request.getDescription())
                .star(request.getStar())
                .build();
    }
}
