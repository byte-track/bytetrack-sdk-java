import com.alibaba.fastjson.JSONObject;
import com.byteslink.product.bytetrack.server.reponse.BaseResponse;
import com.byteslink.product.bytetrack.server.res.OpenApiRes;
import com.byteslink.product.bytetrack.server.service.BytetrackService;
import org.junit.Test;

import java.io.IOException;

public class BytetrackTest {


    private String BaseApiUrl = "http://192.168.2.44:8877/public";

    private String SecureKey = "946ccf174732ed4a79a5e9963d89ad9274";
    private String ApiKey = "94709";
    @Test
    public void openApiTest() throws IOException {
        BytetrackService bytetrackService = new BytetrackService();
        JSONObject jsonObject = new JSONObject();
        OpenApiRes openApiRes = new OpenApiRes("92229980","10001","123123",jsonObject,ApiKey);
        BaseResponse baseResponse = bytetrackService.pushByOpenApi(BaseApiUrl, SecureKey,openApiRes);
        System.out.println(JSONObject.toJSONString(baseResponse));
    }
}
