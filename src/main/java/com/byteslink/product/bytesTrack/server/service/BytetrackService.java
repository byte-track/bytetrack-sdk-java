package com.byteslink.product.bytesTrack.server.service;

import com.alibaba.fastjson.JSONObject;
import com.byteslink.product.bytesTrack.server.reponse.BaseResponse;
import com.byteslink.product.bytesTrack.server.res.OpenApiRes;
import com.byteslink.product.bytesTrack.server.utils.HttpClientUtil;
import com.byteslink.product.bytesTrack.server.utils.SignUtil;

import java.io.IOException;

public class BytetrackService {
    private String defaultUrl = "https://dash.bytetrack.com/public";

    public BaseResponse pushByOpenApi(String baseApiUrl, String secretKey, OpenApiRes openApiRes) throws IOException {
        if (baseApiUrl == null || "".equals(baseApiUrl)) {
            baseApiUrl = defaultUrl;
        }
        baseApiUrl = baseApiUrl + "/outbound/outboundNoticeUser/openApi";
        String timestamp = String.valueOf(System.currentTimeMillis());
        JSONObject jsonObjectParams = new JSONObject();
        jsonObjectParams.put("noticeId", openApiRes.getNoticeId());
        jsonObjectParams.put("userId", openApiRes.getUserId());
        jsonObjectParams.put("params", openApiRes.getParams());
        String body = jsonObjectParams.toJSONString();
        String sign = SignUtil.buildTradeSign(body, secretKey, openApiRes.getNonce(), timestamp);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nonce", openApiRes.getNonce());
        jsonObject.put("apiKey", openApiRes.getApiKey());
        jsonObject.put("timestamp", timestamp);
        jsonObject.put("body", body);
        jsonObject.put("sign", sign);
        String result = HttpClientUtil.post(jsonObject, baseApiUrl);
        return JSONObject.parseObject(result, BaseResponse.class);
    }

}
