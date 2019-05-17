package com.gouqi.util;

import com.alibaba.fastjson.JSONObject;
import com.gouqi.entity.InterfaceBean;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @ClassName HttpClientUtil
 * @Description 用于发送请求的工具类
 * @Auther Wangjy
 * @Data 2019/5/14 9:49
 **/
public class HttpClientUtil {
    public static void doGet(InterfaceBean itf) {
        String strResult = "";
        JSONObject jsonResult = null;
        Long startTime = TimeUtil.getTimeMs();
        CloseableHttpClient client = HttpClients.createDefault();
        String time = TimeUtil.getTime("yyyy-MM-dd hh:mm:ss");
        itf.setStartTime(time);
        // 发送get请求
        HttpGet request = new HttpGet(itf.getUrl());
        try {
            CloseableHttpResponse response = client.execute(request);

            // 请求发送成功，并得到响应
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                // 读取服务器返回过来的json字符串数据
                HttpEntity entity = response.getEntity();
                strResult = EntityUtils.toString(entity, "utf-8");
                // 把json字符串转换成json对象
                jsonResult = JSONObject.parseObject(strResult);
                Long endTime = TimeUtil.getTimeMs();
                Long actTime = endTime - startTime;
                itf.setActualMs(actTime.toString());
                itf.setJsonResult(jsonResult);
                LogUtil.out.write(time + "\r\n");
                LogUtil.out.write("url : " + itf.getUrl() + "\r\n");
                LogUtil.out.write("返回值： " +jsonResult.toString() + "\r\n");
            } else {
                LogUtil.out.write("get请求提交失败:" + itf.getUrl() + "\r\n");
            }
        } catch (IOException e) {
        } finally {
            request.releaseConnection();
        }
    }
}
