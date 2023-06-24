package airline;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import jsonUtils.JSONUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import payloads.Payloads;
import restUtils.RestUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AirlineCreationTest extends AirlineAPIs{
    //@Test
    public void createAirline(){
        Response response =
                RestAssured.given().log().all()
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 12211223,\n" +
                        "    \"name\": \"Sri Lankan Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                        "    \"website\": \"www.srilankaairways.com\",\n" +
                        "    \"established\": \"1990\"\n" +
                        "}")
                .post()
                        .then().log().all().extract().response();
        Assert.assertEquals(response.getStatusCode(), 200, "Mismatch in status codes");

    }

    //@Test
    public void createAirlineWithReusablePOSTMethod(){

        String endpoint = "https://api.instantwebtools.net/v1/airlines";
        String body = "{\n" +
                "    \"id\": 12211224,\n" +
                "    \"name\": \"Sri Lankan Airways\",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        Response response =
                RestUtils.doPost(endpoint, body, new HashMap<>());
        Assert.assertEquals(response.getStatusCode(), 200, "Mismatch in status codes");

    }

    //@Test
    public void createAirlineWithReusablePOSTMethodAndReusablePayloadCreationAsString(){

        String endpoint = "https://api.instantwebtools.net/v1/airlines";
        String body = Payloads.getCreateAirlinePayloadAsString("12211225","name","country",
                "logo","slogan", "head_quarters","website", "established");
        Response response =
                RestUtils.doPost(endpoint, body, new HashMap<>());
        Assert.assertEquals(response.getStatusCode(), 200, "Mismatch in status codes");

    }

    //@Test
    public void createAirlineWithReusablePOSTMethodAndReusablePayloadCreationAsMapDEPRECATED() throws IOException {
        String env = System.getProperty("env")== null ? "qa" : System.getProperty("env");
        Map<String, Object> dataFromJson = JSONUtils.getJSONDataAsMap("/env/" + env + "/target_env_config.json");
        String endpoint = (String)dataFromJson.get("createAirlineEndpoint");
        Map<String, Object> body = Payloads.getCreateAirlinePayloadAsMap("12211225","name","country",
                "logo","slogan", "head_quarters","website", "established");
        Response response =
                RestUtils.doPost(endpoint, body, new HashMap<>());
        Assert.assertEquals(response.getStatusCode(), 200, "Mismatch in status codes");
    }

    @Test
    public void createAirlineWithReusablePOSTMethodAndReusablePayloadCreationAsMap() throws IOException {
        Map<String, Object> body = Payloads.getCreateAirlinePayloadAsMap("12211227","name","country",
                "logo","slogan", "head_quarters","website", "established");
        Response response = createAirlines(body);
        Assert.assertEquals(response.getStatusCode(), 200, "Mismatch in status codes");
    }
}
