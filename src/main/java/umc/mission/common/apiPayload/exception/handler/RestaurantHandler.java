package umc.mission.common.apiPayload.exception.handler;

import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {

    public RestaurantHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
