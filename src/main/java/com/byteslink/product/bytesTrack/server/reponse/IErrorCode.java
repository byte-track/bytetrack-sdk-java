package com.byteslink.product.bytesTrack.server.reponse;

/**
 * 系统错误码的抽象定义
 * <p>
 * Created by qin on 20/3/19.
 */
public interface IErrorCode {

    /**
     * 获取错误码
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMessage();
}