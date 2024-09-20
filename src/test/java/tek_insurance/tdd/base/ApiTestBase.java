package tek_insurance.tdd.base;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.requests.TokenRequest;

@Listeners({ExtentITestListenerClassAdapter.class})
public class ApiTestBase extends BaseSetup{
    public RequestSpecification getDefaultRequest(){
        return RestAssured.given().contentType(ContentType.JSON);
    }
    public void extentResponse(String testResponse){
        ExtentTestManager.getTest().info(testResponse);
    }
    public String getValidToken(String username, String password) {
        TokenRequest tokenRequest = new TokenRequest(username, password);
        Response response = getDefaultRequest().body(tokenRequest)
                .when().post(Endpoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract().response();
        return response.jsonPath().getString("token");
    }

}
