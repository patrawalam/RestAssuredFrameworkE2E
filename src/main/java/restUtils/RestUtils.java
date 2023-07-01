package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import reporting.ExtentReportManager;

import java.util.Map;

public class RestUtils {
    private static RequestSpecification getRequestSpecification(String endpoint, Object requestPayload, Map<String, String> headers) {
        return RestAssured.given().log().all()
                .baseUri(endpoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    public static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Request Base URI :: " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Request HTTP Method  :: " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request Headers :: ");
        ExtentReportManager.logHeaders(queryableRequestSpecification.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Request body :: ");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    public static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status :: " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response Headers  :: ");
        ExtentReportManager.logHeaders(response.getHeaders().asList());
        ExtentReportManager.logInfoDetails("Response body :: ");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }

    public static Response doPost(String endpoint, String requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        printRequestLogInReport(requestSpecification);
        Response response = requestSpecification.post();
        printResponseLogInReport(response);
        return response;
    }

    public static Response doPost(String endpoint, Map<String, Object> requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        printRequestLogInReport(requestSpecification);
        Response response = requestSpecification.post();
        printResponseLogInReport(response);
        return response;
    }

    public static Response doPost(String endpoint, Object requestPayload, Map<String, String> headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endpoint, requestPayload, headers);
        printRequestLogInReport(requestSpecification);
        Response response = requestSpecification.post();
        printResponseLogInReport(response);
        return response;
    }
}
