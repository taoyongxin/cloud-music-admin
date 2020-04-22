package com.soft1851.music.admin.exception;

import com.soft1851.music.admin.common.ResultCode;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CustomException
 * @Description  用户自定义异常
 * @date 2020-04-21 16:11
 **/
public class CustomException extends RuntimeException {
    protected ResultCode resultCode;

    public CustomException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}