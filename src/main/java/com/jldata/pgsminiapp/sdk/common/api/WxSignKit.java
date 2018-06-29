package com.jldata.pgsminiapp.sdk.common.api;

import com.jldata.pgsminiapp.core.kit.HashKit;
import com.jldata.pgsminiapp.core.util.Charsets;
import com.jldata.pgsminiapp.core.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.TreeMap;

public class WxSignKit {

    /**
     * 组装签名的字段
     * @param params 参数
     * @param urlEncoder 是否urlEncoder
     * @return String
     */
    public static String packageSign(Map<String, String> params, boolean urlEncoder) {
        // 先将参数以其参数名的字典序升序进行排序
        TreeMap<String, String> sortedParams = new TreeMap<String, String>(params);
        // 遍历排序后的字典，将所有参数按"key=value"格式拼接在一起
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> param : sortedParams.entrySet()) {
            String value = param.getValue();
            if (StringUtils.isBlank(value)) {
                continue;
            }
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(param.getKey()).append("=");
            if (urlEncoder) {
                try { value = urlEncode(value); } catch (UnsupportedEncodingException e) {}
            }
            sb.append(value);
        }
        return sb.toString();
    }

    /**
     * urlEncode
     * @param src 微信参数
     * @return String
     * @throws UnsupportedEncodingException 编码错误
     */
    public static String urlEncode(String src) throws UnsupportedEncodingException {
        return URLEncoder.encode(src, Charsets.UTF_8.name()).replace("+", "%20");
    }

    /**
     * 生成签名
     * @param params 参数
     * @param paternerKey 支付密钥
     * @return sign
     */
    public static String createSign(Map<String, String> params, String paternerKey) {
        // 生成签名前先去除sign
        params.remove("sign");
        String stringA = packageSign(params, false);
        String stringSignTemp = stringA + "&key=" + paternerKey;
        return HashKit.md5(stringSignTemp).toUpperCase();
    }

    /**
     * 支付异步通知时校验sign
     * @param params 参数
     * @param paternerKey 支付密钥
     * @return {boolean}
     */
    public static boolean verifyNotify(Map<String, String> params, String paternerKey){
        String sign = params.get("sign");
        String localSign = WxSignKit.createSign(params, paternerKey);
        return sign.equals(localSign);
    }
}
