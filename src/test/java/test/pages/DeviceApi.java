package test.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test.base.TestBase;

public class DeviceApi extends TestBase {

    public DeviceApi() {
        RestAssured.baseURI = this.apiUrl;
    }

    public Response createDevice(String requestBody) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .post("/api/v2/devicex/" + this.installationId);
    }

    public Response deleteDevice(String deviceId) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .accept("application/json")
                .delete("/api/v2/devicex/" + this.installationId + "/" + deviceId);
    }

    public Response getAllDevices() {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .accept("application/json")
                .get("/api/v2/devicex/" + this.installationId);
    }

    public Response updateDevice(String deviceId, String requestBody) {
        return RestAssured.given()
                .header("X-API-Key", this.token)
                .contentType("application/json")
                .accept("application/json")
                .body(requestBody)
                .put("/api/v2/devicex/" + this.installationId + "/" + deviceId);
    }
}
