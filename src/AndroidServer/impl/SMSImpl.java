package AndroidServer.impl;

import com.baidubce.auth.DefaultBceCredentials;
import com.baidubce.services.sms.SmsClient;
import com.baidubce.services.sms.SmsClientConfiguration;
import com.baidubce.services.sms.model.SendMessageV2Request;
import com.baidubce.services.sms.model.SendMessageV2Response;

import java.util.HashMap;
import java.util.Map;

public class SMSImpl
{
    // 相关参数定义
    private static final String endPoint = "http://sms.bj.baidubce.com"; // SMS服务域名，可根据环境选择具体域名
    private static final String accessKeyId = "ddc606e5635a4e5ba90aa7ed9d8515c9";  // 发送账号安全认证的Access Key ID
    private static final String secretAccessKy = "c6353a3ef34a4d8d9f4b6d17bcdac19e"; // 发送账号安全认证的Secret Access Key
//    private static SmsClientConfiguration config;

    public static boolean sendCode(String phoneNum, String code)
    {
        SmsClientConfiguration config = new SmsClientConfiguration();
        config.setCredentials(new DefaultBceCredentials(accessKeyId, secretAccessKy));
        config.setEndpoint(endPoint);
        // 实例化发送客户端
        SmsClient smsClient = new SmsClient(config);
        // 定义请求参数
        String invokeId = "JKDeM2TM-QVA0-bf47"; // 发送使用签名的调用ID
        String phoneNumber = phoneNum; // 要发送的手机号码(只能填写一个手机号)
        String templateCode = "smsTpl:e7476122a1c24e37b3b0de19d04ae901"; // 本次发送使用的模板Code
        Map<String, String> vars =
                new HashMap<String, String>(); // 若模板内容为：您的验证码是${code},在${time}分钟内输入有效
        vars.put("code", code);
//        vars.put("time", "30");

        //实例化请求对象
        SendMessageV2Request request = new SendMessageV2Request();
        request.withInvokeId(invokeId)
                .withPhoneNumber(phoneNumber)
                .withTemplateCode(templateCode)
                .withContentVar(vars);

        // 发送请求
        SendMessageV2Response response = smsClient.sendMessage(request);

        // 解析请求响应 response.isSuccess()为true 表示成功
        if (response != null && response.isSuccess())
        {
            //  submit success
            return true;
        }
        else
        {
            // fail
            return false;
        }
    }

    public static void main(String[] args)
    {
        System.out.println(sendCode("15253233761", "888888"));
    }

}
