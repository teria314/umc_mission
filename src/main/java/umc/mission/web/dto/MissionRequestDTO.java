package umc.mission.web.dto;

import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class createDTO{
        String description;
        Integer point;
    }
}
