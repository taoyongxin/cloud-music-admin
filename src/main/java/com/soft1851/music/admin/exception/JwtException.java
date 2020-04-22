package com.soft1851.music.admin.exception;


import com.soft1851.music.admin.common.ResultCode;

/**
 * @author Tao
 * @version 1.0
 * @ClassName JwtException
 * @Description 自定义异常
 * @date 2020-04-15 16:14
 **/
public class JwtException extends RuntimeException {

    protected ResultCode resultCode;

    public JwtException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}