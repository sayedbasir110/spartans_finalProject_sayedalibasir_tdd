package tek_insurance.tdd.base;

import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerClassAdapter.class})
public class ApiTestBase extends BaseSetup{
    public RequestSpecification getDefaultRequest(){
        return RestAssured.given().contentType(ContentType.JSON);
    }
    public void getTestResponse(String testResponse){
        ExtentTestManager.getTest().info(testResponse);
    }

}
