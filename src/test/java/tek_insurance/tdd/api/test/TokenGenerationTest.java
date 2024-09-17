package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek_insurance.tdd.base.ApiTestBase;

import java.util.HashMap;
import java.util.Map;

public class TokenGenerationTest extends ApiTestBase {
    private static final Logger LOGGER = LogManager.getLogger(TokenGenerationTest.class);
    @Test(dataProvider = "testData")
    public void GetValidToken(String username, String password){
        RequestSpecification request = getDefaultRequest();
        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);
        request.body(body);
        Response response = request.when().post("/api/token");
        response.then().statusCode(200);
        LOGGER.info("Response is {}", response.asPrettyString());
    }
    @DataProvider(name = "testData")
    public String[][] testData(){
        return new String[][] {
                {"supervisor","tek_supervisor"},
                {"operator_readonly", "Tek4u2024"}
        };
    }
}
