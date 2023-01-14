package com.byteslink.product.bytetrack.server.res;

import com.alibaba.fastjson.JSONObject;


/**
 * openApi的接收参数
 *
 * @author chuhaodong
 * @date 2022年12月15日 14:32
 */
public class OpenApiRes {
    private String noticeId;
    private String userId;
    private String nonce;
    private JSONObject params;
    private String timestamp;
    private String appKey;

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public JSONObject getParams() {
        return params;
    }

    public void setParams(JSONObject params) {
        this.params = params;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }


    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public OpenApiRes(String noticeId, String userId, String nonce, JSONObject params, String appKey) {
        this.noticeId = noticeId;
        this.userId = userId;
        this.nonce = nonce;
        this.params = params;
        this.appKey = appKey;
    }

    @Override
    public String toString() {
        return "OpenApiRes{" +
                "noticeId='" + noticeId + '\'' +
                ", userId='" + userId + '\'' +
                ", nonce='" + nonce + '\'' +
                ", params=" + params +
                ", appKey='" + appKey + '\'' +
                '}';
    }
}
