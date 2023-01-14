package com.byteslink.product.bytetrack.server.service;

import com.alibaba.fastjson.JSONObject;
import com.byteslink.product.bytetrack.server.reponse.BaseResponse;
import com.byteslink.product.bytetrack.server.res.OpenApiRes;
import com.byteslink.product.bytetrack.server.utils.HttpClientUtil;
import com.byteslink.product.bytetrack.server.utils.SignUtil;

import java.io.IOException;

public class BytetrackService {
    private String defaultUrl = "https://dash.bytetrack.com/public";

    public BaseResponse pushByOpenApi(String baseApiUrl, String secretKey, OpenApiRes openApiRes) throws IOException {
        if (baseApiUrl == null || "".equals(baseApiUrl)) {
            baseApiUrl = defaultUrl;
        }
        baseApiUrl = baseApiUrl + "/outbound/outboundNoticeUser/openApi";
        String timestamp = String.valueOf(System.currentTimeMillis());
        String params = JSONObject.toJSONString(openApiRes);
        String sign = SignUtil.buildTradeSign(params, secretKey, openApiRes.getNonce(), timestamp, openApiRes.getAppKey());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("noticeId", openApiRes.getNoticeId());
        jsonObject.put("nonce", openApiRes.getNonce());
        jsonObject.put("appKey", openApiRes.getAppKey());
        jsonObject.put("userId", openApiRes.getUserId());
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("params", params);
        jsonObject.put("sign", sign);
        String result = HttpClientUtil.post(jsonObject, baseApiUrl);
        return JSONObject.parseObject(result, BaseResponse.class);
    }

}
