package test.tests.devices;

import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import test.pages.DeviceApi;

public class DeviceTest extends DeviceApi {

    private String deviceId;

    @BeforeMethod
    public void createDevice() {
        String requestBody = """
    {
        "installation_id": %d,
        "type": "tempHumidityAdc",
        "meta": {
            "name": "%s",
            "roomId": "%s",
            "roomName": "%s"
        }
    }
    """.formatted(this.installationId, "Temperature_Sensor", "20130", "Office Room 20130");


        Response response = createDevice(requestBody);
        this.deviceId = response.jsonPath().getString("id");

        System.out.println("Device created with ID: " + deviceId);
    }

    @AfterMethod
    public void deleteDevice() {
        if (deviceId != null) {
            Response response = deleteDevice(deviceId);
            System.out.println("Device with ID " + deviceId + " deleted.");
        }
    }

    @Test
    public void testGetAllDevices() {
        Response response = getAllDevices();

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }

    @Test
    public void testUpdateDevice() {
        String requestBody = """
    {
        "id": %s,
        "installation_id": %d,
        "type": "tempHumidityAdc",
        "meta": {
            "name": "%s",
            "roomId": "%s",
            "roomName": "%s"
        }
    }
    """.formatted(deviceId, this.installationId, "Updated_Temperature_Sensor", "30130", "Updated Office Room");

        Response response = updateDevice(deviceId, requestBody);

        System.out.println("Response Status Code: " + response.statusCode());
        System.out.println("Response Body: " + response.getBody().asString());

        response.then().statusCode(200);
    }
}
