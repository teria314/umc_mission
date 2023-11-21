package umc.mission.domain;

import lombok.*;
import umc.mission.domain.common.BaseEntity;
import umc.mission.domain.enums.LoginStrategy;
import umc.mission.domain.enums.Role;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Role role;

    @Column(length = 20)
    private String email;

    @Column(length = 20)
    private String name;

    @Column(columnDefinition = "TINYINT(1)")
    private Integer gender;

    private Date birth;

    @Column(length = 50)
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private LoginStrategy loginStrategy;

    private String token;

    @Column(columnDefinition = "TINYINT(1)")
    private boolean phoneNumAuth;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarmList = new ArrayList<>();
}
