package com.jldata.pgsminiapp.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfinal.json.IJsonFactory;
import com.jfinal.json.Json;
import com.jfinal.plugin.activerecord.CPI;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;
import com.jldata.pgsminiapp.core.context.BaseContextHandler;
import com.jldata.pgsminiapp.core.context.SpringContextUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Json转换
 */
public final class JsonUtils {

    private JsonUtils() {}
    private static String defaultDatePattern = "yyyy-MM-dd HH:mm:ss";


    public static ObjectMapper getObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        return mapper;
    }

    /**
     * 将 Object 转为json字符串
     * @param object 对象
     * @return JsonString
     */
    public static String toJson(Object object) {
        if (jsonFactory == null) {
            return Json.getJson().toJson(object);
        }
        return jsonFactory.getJson().toJson(object);
    }

    /**
     * 将 json字符串 转为Object
     * @param jsonString json字符串
     * @param valueType 结果类型
     * @param <T> 泛型标记
     * @return T 结果
     */
    public static <T> T parse(String jsonString, Class<T> valueType) {
        if (jsonFactory == null) {
            return Json.getJson().parse(jsonString, valueType);
        }
        return jsonFactory.getJson().parse(jsonString, valueType);
    }

}
