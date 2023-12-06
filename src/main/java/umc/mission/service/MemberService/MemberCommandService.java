package umc.mission.service.MemberService;

import umc.mission.domain.Member;
import umc.mission.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    Member joinMember(MemberRequestDTO.JoinDTO request);
}
