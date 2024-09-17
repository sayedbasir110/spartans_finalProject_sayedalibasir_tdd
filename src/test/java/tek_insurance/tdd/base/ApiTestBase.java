package tek_insurance.tdd.base;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTestBase extends BaseSetup{
    public RequestSpecification getDefaultRequest(){
        return RestAssured.given().contentType(ContentType.JSON);
    }

}
