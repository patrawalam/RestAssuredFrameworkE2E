package airline;

import common.TestBase;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class AirlineAPIs {

    public Response createAirlines(Map<String, Object> body){
        String endpoint = (String) TestBase.dataFromJson.get("createAirlineEndpoint");
        Response response = RestUtils.doPost(endpoint, body, new HashMap<>());
        return response;
    }
}
