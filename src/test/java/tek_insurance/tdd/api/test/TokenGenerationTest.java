package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.base.ApiTestBase;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTest extends ApiTestBase {
    private static final Logger LOGGER = LogManager.getLogger(TokenGenerationTest.class);

    public Map<String, String> getRequestBody(String username, String password){
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("username", username);
        requestBody.put("password", password);
        return requestBody;
    }
    @Test(dataProvider = "testData")
    public void GetValidToken(String username, String password){
        RequestSpecification request = getDefaultRequest();
        request.body(getRequestBody(username, password));
        Response response = request.when().post(Endpoints.TOKEN.getValue());
        response.then().statusCode(200);
        LOGGER.info("Response is {}", response.asPrettyString());
    }
    @DataProvider(name = "testData")
    public String[][] testData(){
        return new String[][] {
                {"supervisor","tek_supervisor"},
                {"operator_readonly", "Tek4u2024"},

        };
    }
    @Test(dataProvider = "negativeTestData")
    public void negativeTest(String username, String password, int statusCode, String expectedErrorMessage){
        RequestSpecification request = getDefaultRequest();
        request.body(getRequestBody(username, password));
        Response response = request.when().post(Endpoints.GET_ACCOUNT.getValue());
        response.then().statusCode(statusCode);
        String actualErrorMessage = response.body().jsonPath().getString("errorMessage");
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message should match");

    }
    @DataProvider(name = "negativeTestData")
    public Object[][] negativeTestData(){
        return new Object[][] {
                {"invalid","tek_supervisor", 404 , "User invalid not found"},
                {"operator_readonly", "wrong password", 400, "Password not matched"},
        };
    }

}
