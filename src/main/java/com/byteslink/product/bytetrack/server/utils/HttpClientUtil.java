package com.byteslink.product.bytetrack.server.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;

public class HttpClientUtil {

    private static final String CONTENT_TYPE_KEY="Content-Type";
    private static final String CONTENT_TYPE_VALUE="application/json;charset=UTF-8";
    private static final String CHARSET="UTF-8";

    public static String post(JSONObject jsonObject, String url) throws IOException {
        HttpPost httpPost=new HttpPost(url);
        httpPost.setHeader(CONTENT_TYPE_KEY, CONTENT_TYPE_VALUE);
        StringEntity entity = new StringEntity(jsonObject.toString(), UTF_8);
        entity.setContentEncoding(CHARSET);
        // 发送Json格式的数据请求
        entity.setContentType("application/json");
        httpPost.setEntity(entity);
        HttpClient httpClient= HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(httpPost);
        String result="";
        if(response != null){
            HttpEntity resEntity = response.getEntity();
            if(resEntity != null){
                result= EntityUtils.toString(resEntity,CHARSET);
            }
        }
        return result;
    }}