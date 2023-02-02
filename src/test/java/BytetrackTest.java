
import com.alibaba.fastjson.JSONObject;
import com.byteslink.product.bytesTrack.server.reponse.BaseResponse;
import com.byteslink.product.bytesTrack.server.res.OpenApiRes;
import com.byteslink.product.bytesTrack.server.service.BytetrackService;
import org.junit.Test;

import java.io.IOException;

public class BytetrackTest {


    private String BaseApiUrl = "http://192.168.2.44:8877/public";

    private String SecureKey = "946ccf174732ed4a79a5e9963d89ad9274";
    private String ApiKey = "94709";

    /**
     * 消息通知-定向推送到用户 openApi推送测试
     * 具体参数参议，请参考接口发开文档
     * @throws IOException
     */
    @Test
    public void openApiTest() throws IOException {
        BytetrackService bytetrackService = new BytetrackService();
        //自定义参数
        JSONObject jsonObject = new JSONObject();
        OpenApiRes openApiRes = new OpenApiRes("92229980","10001","123123",jsonObject,ApiKey);
        BaseResponse baseResponse = bytetrackService.pushByOpenApi(BaseApiUrl, SecureKey,openApiRes);
        System.out.println(JSONObject.toJSONString(baseResponse));
    }
}

