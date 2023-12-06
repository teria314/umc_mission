package umc.mission.converter;

import umc.mission.domain.Member;
import umc.mission.web.dto.MemberRequestDTO;
import umc.mission.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDTO request){
        return Member.builder()
                .address(request.getAddress())
                .gender(request.getGender())
                .name(request.getName())
                .memberFavoriteFoodTypeList(new ArrayList<>())
                .build();
    }

}
