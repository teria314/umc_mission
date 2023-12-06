package umc.mission.common.apiPayload.exception.handler;

import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
