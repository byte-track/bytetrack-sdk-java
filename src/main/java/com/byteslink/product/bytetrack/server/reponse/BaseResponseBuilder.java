package com.byteslink.product.bytetrack.server.reponse;


/**
 * web接口响应快速构造工具
 *
 * @author: fanqin
 * @Date: 2019/6/1 15:01
 */
public class BaseResponseBuilder {

    public static BaseResponse createResponse() {
        return createResponse(DefaultErrorCode.SUCCESS);
    }

    public static <T> BaseResponse<T> createResponse(T data) {
        BaseResponse<T> response = createResponse(DefaultErrorCode.SUCCESS);
        response.setData(data);
        return response;
    }

    /**
     * 根据IErrorCode构造响应
     *
     * @param errorCode
     * @return
     */
    public static BaseResponse createResponse(IErrorCode errorCode) {
        BaseResponse response = new BaseResponse();
        String code = errorCode.getCode();
        response.setCode(code);
        response.setMsg(null);
        return response;
    }

    public static BaseResponse createResponse(IErrorCode errorCode, String msgKey, Object... params) {
        return createResponse(errorCode.getCode(), msgKey, params);
    }

    public static <T> BaseResponse<T> createResponse(String code, String msg, Object... params) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setCode(code);
        response.setMsg("");
        return response;
    }


}