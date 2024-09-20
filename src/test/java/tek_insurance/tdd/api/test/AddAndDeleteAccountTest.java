package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.enums.Gender;
import tek_insurance.tdd.api.models.enums.MaritalStatus;
import tek_insurance.tdd.api.models.requests.PrimaryAccountRequest;
import tek_insurance.tdd.api.models.responses.PrimaryAccountResponse;
import tek_insurance.tdd.base.ApiTestBase;
import tek_insurance.tdd.utility.RandomEmail;

public class AddAndDeleteAccountTest extends ApiTestBase {
    public static final Logger LOGGER = LogManager.getLogger(AddAndDeleteAccountTest.class);
    int newAccountId;

    @BeforeClass
    public void createNewAccount(){
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
        PrimaryAccountResponse primaryAccountResponse = response.body().jsonPath().getObject("", PrimaryAccountResponse.class);
        newAccountId = primaryAccountResponse.getId();
        LOGGER.info("New account with id: {} created", newAccountId);
        Assert.assertEquals(primaryAccountResponse.getEmail() , randomEmail);
        Assert.assertEquals(primaryAccountResponse.getFirstName() , "John");
        Assert.assertEquals(primaryAccountResponse.getLastName() , "Doe");
    }

    @Test(dataProvider = "addAndDeleteTestData")
    public void addAndDeleteAccountWithDifferentUsers(String username, String password, int expectedStatusCode){
        String token = getValidToken(username, password);
        getDefaultRequest().header("Authorization", "Bearer " + token)
                .queryParam("primaryPersonId", newAccountId)
                .when().delete(Endpoints.DELETE_ACCOUNT.getValue())
                .then().statusCode(expectedStatusCode);
    }

    @DataProvider()
    public Object[][] addAndDeleteTestData(){
        return new Object[][] {
                {"operator_readonly", "Tek4u2024", 403},
                {"supervisor", "tek_supervisor", 202}
        };
    }
}
