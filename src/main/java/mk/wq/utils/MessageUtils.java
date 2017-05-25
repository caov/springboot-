package mk.wq.utils;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

/**
 * 
* @ClassName: MessageUtils
* @Description: 消息发送工具类，阿里大于官网：http://www.alidayu.com/
* @author Van
* @date 2017年5月25日 上午9:44:42
 */
public class MessageUtils {
    
    /**
    * @MethodName:  sendMessage
    * @Description: 下面代码参考的是阿里大于的官方文档
    * @author Van
    * @date 2017年5月25日 上午9:19:59
     */
    public static void sendMessage(String content){
        //阿里大于URL
        String url = "http://gw.api.taobao.com/router/rest";
        //以下三个参数，第一个参数是url阿里大鱼的服务地址，第二个参数是你设置的阿里大于APP Key，第三个参数是App Secret
        TaobaoClient client = new DefaultTaobaoClient(url, "xxxx","xxxxxxxxx");
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        //必须填写normal
        req.setSmsType("normal");
        //短信签名，根据自己在阿里大于设置的而定
        req.setSmsFreeSignName("XXXX");
        //接收短信电话号码
        req.setRecNum("187XXXXXXXX");
        //模板，根据自己在阿里大于设置的而定
        req.setSmsTemplateCode("SMS_XXXX");
        //模板中的参数，根据自己在阿里大于设置的而定
        req.setSmsParamString("{content:'" + content + "'}");
        AlibabaAliqinFcSmsNumSendResponse rsp;
        try {
            rsp = client.execute(req);
            System.out.println(rsp.getBody());//输出发送结果情况
        } catch (ApiException e) {
            System.out.println("发送失败");
        }
    }
    
}
