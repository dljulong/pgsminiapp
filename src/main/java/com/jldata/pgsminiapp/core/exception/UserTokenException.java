package com.jldata.pgsminiapp.core.exception;


import com.jldata.pgsminiapp.core.constant.CommonConstants;

/**
 * Created by ace on 2017/9/8.
 */
public class UserTokenException extends BaseException {
    public UserTokenException(String message) {
        super(message, CommonConstants.EX_USER_INVALID_TOKEN);
    }
}
