package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.responses.UserProfileResponse;
import tek_insurance.tdd.base.ApiTestBase;

public class UserProfileTest extends ApiTestBase {

    @Test(dataProvider = "userProfileTestData")
    public void getUserProfileAndValidate(String username, String password, String expectedResponse) {
        String token = getValidToken(username, password);
        UserProfileResponse userProfileResponse = fetchUserProfile(token);
        extentResponse(userProfileResponse.toString());
        Assert.assertEquals(userProfileResponse.getFullName(), expectedResponse, "FullName should match");
    }
    private UserProfileResponse fetchUserProfile(String token) {
        Response response = getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                .when().get(Endpoints.USER_PROFILE.getValue())
                .then().statusCode(200)
                .extract().response();
        return response.body().jsonPath().getObject("", UserProfileResponse.class);
    }
    @DataProvider(name = "userProfileTestData")
    public Object[][] userProfileTestData() {
        return new Object[][]{
                {"supervisor", "tek_supervisor", "Supervisor"},
                {"operator_readonly", "Tek4u2024", "operator_readonly"}
        };
    }
}
