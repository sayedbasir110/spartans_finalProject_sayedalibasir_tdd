package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.Endpoints;
import tek_insurance.tdd.base.ApiTestBase;

public class GetPrimaryAccountTest extends ApiTestBase {
    @Test(dataProvider = "testData")
    public void getAccountAndValidate(int Id, int statusCode){
        RequestSpecification request = getDefaultRequest();
        request.queryParam("primaryPersonId", Id);
        Response response = request.when().get(Endpoints.GET_PRIMARY_ACCOUNT.getValue());
        response.then().statusCode(statusCode);
        response.prettyPrint();
        getTestResponse(response.asPrettyString());
    }
    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][] {
                {10040, 200},
                {1000005, 404}
        };
    }
}
