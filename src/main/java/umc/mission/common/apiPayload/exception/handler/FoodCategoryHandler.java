package umc.mission.common.apiPayload.exception.handler;

import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
