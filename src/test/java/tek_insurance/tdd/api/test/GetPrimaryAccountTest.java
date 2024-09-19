package tek_insurance.tdd.api.test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek_insurance.tdd.api.models.enums.Endpoints;
import tek_insurance.tdd.api.models.responses.PrimaryAccountResponse;
import tek_insurance.tdd.base.ApiTestBase;
import tek_insurance.tdd.utility.DataBaseUtility;

import java.sql.*;

public class GetPrimaryAccountTest extends ApiTestBase {
    @Test
    public void getAccountAndValidate(){
        RequestSpecification request = getDefaultRequest();
        request.queryParam("primaryPersonId", 1006);
        Response response = request.when().get(Endpoints.GET_PRIMARY_ACCOUNT.getValue());
        response.then().statusCode(200);
        response.prettyPrint();
        getTestResponse(response.asPrettyString());
    }
    @Test
    public void validateGetAccountNotExist(){
        String response = getDefaultRequest().queryParam("primaryPersonId", 252525)
                .when().get(Endpoints.GET_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(404).extract().response().jsonPath().getString("errorMessage");
        Assert.assertEquals(response,"Account with id 252525 not exist");
    }
    @Test
    public void getLatestAccountAndValidateWithDB() throws SQLException {
        DataBaseUtility dataBaseUtility = new DataBaseUtility();
        String query = "select * from primary_person where id = (select MAX(id) from primary_person);";
        ResultSet result = dataBaseUtility.executeQuery(query);
            result.next();
            int idFromDB = result.getInt("id");
            String firstNameFromDB = result.getString("first_name");
            String lastNameFromDB = result.getString("last_name");

        Response response = getDefaultRequest().queryParam("primaryPersonId", idFromDB)
                .when().get(Endpoints.GET_PRIMARY_ACCOUNT.getValue())
                .then().statusCode(200).extract().response();
        PrimaryAccountResponse primaryAccountResponse = response.body().jsonPath().getObject("", PrimaryAccountResponse.class);
        Assert.assertEquals(idFromDB, primaryAccountResponse.getId());
        Assert.assertEquals(firstNameFromDB, primaryAccountResponse.getFirstName());
        Assert.assertEquals(lastNameFromDB, primaryAccountResponse.getLastName());

    }


}
