package com.byteslink.product.bytetrack.server.reponse;

/**
 * <p>
 *   返回封装类
 * </p>
 *
 * @author yang
 * @since 2022-05-19
 */
public class BaseResponse<T> {

    private String code;

    private String msg;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

