package umc.mission.domain.mapping;

import lombok.*;
import umc.mission.domain.Member;
import umc.mission.domain.Term;
import umc.mission.domain.common.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberAgreeTerm extends BaseEntity implements Serializable {

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Id()
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private Term terms;

}
