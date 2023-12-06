package umc.mission.converter;


import umc.mission.domain.Mission;
import umc.mission.domain.Review;
import umc.mission.web.dto.MissionRequestDTO;
import umc.mission.web.dto.MissionResponseDTO;
import umc.mission.web.dto.ReviewRequestDTO;
import umc.mission.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.createResultDTO toCreateResultDTO(Mission mission){
        return MissionResponseDTO.createResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.createDTO request){
        return Mission.builder()
                .description(request.getDescription())
                .point(request.getPoint())
                .build();
    }
}
