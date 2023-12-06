package umc.mission.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String description;

    private Integer star;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Picture> pictureList = new ArrayList<>();

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Reply> replyList = new ArrayList<>();
}