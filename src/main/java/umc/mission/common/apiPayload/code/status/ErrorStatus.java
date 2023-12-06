package umc.mission.common.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다"),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다"),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다"),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 예시,,,
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "테스트용"),

    //FOOD TYPE 에러
    FOOD_TYPE_NOT_FOUND(HttpStatus.BAD_REQUEST, "FOODTYPE4001", "해당되는 FOODTYPE이 없습니다"),

    //REGION 에러
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST, "REGION4001", "해당되는 지역이 없습니다"),

    RESTAURANT_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT_CATEGORY4001", "해당되는 음식점카테고리가 없습니다"),

    RESTAURANT_NOT_FOUND(HttpStatus.NOT_FOUND, "RESTAURANT4001", "해당되는 음식점이 없습니다")
    ;




    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
