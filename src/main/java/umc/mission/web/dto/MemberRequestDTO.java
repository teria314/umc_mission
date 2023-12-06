package umc.mission.web.dto;

import lombok.Getter;
import umc.mission.validation.annotation.ExistCategories;

import java.util.Date;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDTO{
        String name;
        Integer gender;
        Date birth;
        String address;
        @ExistCategories
        List<Long> preferCategory;
    }
}
