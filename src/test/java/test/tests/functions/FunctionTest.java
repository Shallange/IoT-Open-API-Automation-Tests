package test.tests.functions;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import test.pages.FunctionApi;

public class FunctionTest extends FunctionApi {

    private String functionId;

    @BeforeMethod
    public void createFunction() {
        String requestBody = """
        {
            "installation_id": %d,
            "type": "temperatureControl",
            "meta": {
                "key1": "%s",
                "key2": "%s"
            }
        }
        """.formatted(this.installationId, "Temperature_Control", "Cooling_Mode");

        Response response = createFunction(requestBody);
        this.functionId = response.jsonPath().getString("id");

        System.out.println("Function created with ID: " + functionId);
    }

    @AfterMethod
    public void deleteFunction() {
        if (functionId != null) {
            Response response = deleteFunction(functionId);
            System.out.println("Function with ID " + functionId + " deleted.");
        }
    }

    @Test
    public void testGetAllFunctions() {
        Response response = getAllFunctions();

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }

    @Test
    public void testUpdateFunction() {
        String requestBody = """
        {
            "id": %s,
            "installation_id": %d,
            "type": "temperatureControl",
            "meta": {
                "key1": "%s",
                "key2": "%s"
            }
        }
        """.formatted(functionId, this.installationId, "Updated_Temperature_Control", "Cooling_Mode");

        Response response = updateFunction(functionId, requestBody);

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }
}
