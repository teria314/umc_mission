package umc.mission.domain.mapping;

import lombok.*;
import umc.mission.domain.Member;
import umc.mission.domain.Mission;
import umc.mission.domain.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity implements Serializable {

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    private Boolean challenge;

    private Boolean success;

    private LocalDateTime deadline;
}
