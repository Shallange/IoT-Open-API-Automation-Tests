package test.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test.base.TestBase;

public class FunctionApi extends TestBase {

    public FunctionApi() {
        RestAssured.baseURI = this.apiUrl;
    }

    // Method to create a function
    public Response createFunction(String requestBody) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .post("/api/v2/functionx/" + this.installationId);
    }

    // Method to delete a function by ID
    public Response deleteFunction(String functionId) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .accept("application/json")
                .delete("/api/v2/functionx/" + this.installationId + "/" + functionId);
    }

    // Method to update a function by ID
    public Response updateFunction(String functionId, String requestBody) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .put("/api/v2/functionx/" + this.installationId + "/" + functionId);
    }

    // Method to fetch all functions
    public Response getAllFunctions() {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .accept("application/json")
                .get("/api/v2/functionx/" + this.installationId);
    }
}
