package umc.mission.converter;

import umc.mission.domain.FoodType;
import umc.mission.domain.Member;
import umc.mission.domain.mapping.MemberFavoriteFoodType;
import umc.mission.web.dto.MemberRequestDTO;
import umc.mission.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberFavoriteFoodTypeConverter {


    public static List<MemberFavoriteFoodType> toMemberFavoriteFoodTypeList(List<FoodType> foodTypeList){
        return foodTypeList.stream()
                        .map(footTypeId -> {
                            return MemberFavoriteFoodType.builder()
                                    .foodType(footTypeId)
                                    .build();
                        }).collect(Collectors.toList());

    }

}
