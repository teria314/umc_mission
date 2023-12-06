package umc.mission.common.apiPayload.exception.handler;

import umc.mission.common.apiPayload.code.BaseErrorCode;
import umc.mission.common.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {

    public RegionHandler(BaseErrorCode errorCode){
        super(errorCode);
    }
}
