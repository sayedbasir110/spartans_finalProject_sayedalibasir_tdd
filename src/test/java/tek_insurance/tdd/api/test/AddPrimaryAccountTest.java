package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.enums.Gender;
import tek_insurance.tdd.api.models.enums.MaritalStatus;
import tek_insurance.tdd.api.models.requests.PrimaryAccountRequest;
import tek_insurance.tdd.api.models.responses.PrimaryAccountResponse;
import tek_insurance.tdd.base.ApiTestBase;
import tek_insurance.tdd.utility.RandomEmail;

public class AddPrimaryAccountTest extends ApiTestBase {
    @Test
    public void addPrimaryAccountAndValidate(){
        String randomEmail = RandomEmail.generateRandomEmail();
        PrimaryAccountRequest primaryAccountRequest = PrimaryAccountRequest.builder().
                email(randomEmail)
                .title("Mr.")
                .firstName("John")
                .lastName("Doe")
                .gender(Gender.MALE)
                .maritalStatus(MaritalStatus.SINGLE)
                .employmentStatus("Software Developer")
                .dateOfBirth("1996-01-01")
                .build();

        Response response = getDefaultRequest().body(primaryAccountRequest)
                .when().post(Endpoints.ADD_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(201)
                .extract().response();
        response.prettyPrint();
        extentResponse(response.asPrettyString());
        PrimaryAccountResponse primaryAccountResponse = response.body().jsonPath().getObject("", PrimaryAccountResponse.class);
        Assert.assertEquals(primaryAccountResponse.getFirstName(), "John");
    }
}
