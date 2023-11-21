package umc.mission.domain.mapping;

import lombok.*;
import umc.mission.domain.FoodType;
import umc.mission.domain.Member;
import umc.mission.domain.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFavoriteFoodType extends BaseEntity implements Serializable {

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_type_id")
    private FoodType foodType;
}