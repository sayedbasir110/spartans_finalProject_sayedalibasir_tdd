package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.responses.PlanCodeResponse;
import tek_insurance.tdd.api.models.requests.TokenRequest;
import tek_insurance.tdd.base.ApiTestBase;

import java.util.List;

public class GetPlanCodeTest extends ApiTestBase {
    @Test
    public void validatePlanCodes() {
        TokenRequest tokenRequest = new TokenRequest("supervisor", "tek_supervisor");

        String token = getDefaultRequest()
                .body(tokenRequest)
                .when()
                .post(Endpoints.TOKEN.getValue())
                .then().statusCode(200)
                .extract()
                .response()
                .jsonPath().getString("token");

        Response response = getDefaultRequest()
                .header("Authorization", "Bearer " + token)
                .when()
                .get(Endpoints.GET_ALL_PLAN_CODE.getValue())
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<PlanCodeResponse> planCodes = response.body().jsonPath().getList("", PlanCodeResponse.class);
        Assert.assertNotNull(planCodes);
        Assert.assertEquals(planCodes.size(), 4);
        for (PlanCodeResponse planCode : planCodes) Assert.assertFalse(planCode.isPlanExpired());


    }
}
