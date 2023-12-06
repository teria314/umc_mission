package umc.mission.common.apiPayload.exception.handler;

import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.exception.GeneralException;

public class RestaurantCategoryHandler extends GeneralException {

    public RestaurantCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
