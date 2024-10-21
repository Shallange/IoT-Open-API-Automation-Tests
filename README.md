# IoT-Open-API-Automation-Tests

This project provides an automated test suite for the IoT Open API, covering endpoints for devices and functions. It uses **RestAssured** and **TestNG** to automate creating, updating, retrieving, and deleting IoT devices and functions.

---

## Table of Contents

- [About IoT Open](#about-iot-open)
- [Getting Started](#getting-started)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Running the Tests](#running-the-tests)
- [API Endpoints Covered](#api-endpoints-covered)
- [Troubleshooting](#troubleshooting)

---

## About IoT Open

**IoT Open** is a platform that allows users to integrate and manage IoT devices in various installations, such as homes, offices, or industrial environments. The platform provides an API to manage these devices, along with their associated functions, like reading sensor data (e.g., temperature or humidity) or controlling actuators (e.g., turning on lights or adjusting HVAC systems).

### Key Concepts:
- **Device**: A physical entity (e.g., temperature sensor, CO2 sensor, or an actuator) that can provide or control data in an IoT installation.
- **Function**: Represents a measurement (e.g., temperature) or a control mechanism (e.g., a switch) provided by a device.
- **Installation**: A logical grouping of devices and functions. Installations can represent homes, buildings, or any environment where IoT devices are deployed.

This testing suite covers API requests for creating, updating, retrieving, and deleting these devices and their functions within an IoT Open installation.

---

## Getting Started

Follow these instructions to set up the project and run the tests.

---

## Prerequisites

- Java 17 (or higher)
- Maven
- IoT Open API Token
- Installation ID (IoT Open)

---

## Installation

1. Clone the repository:

```bash
git clone <repository-url>
cd <repository-directory>
mvn clean install
```
---

## Configuration

Before running the tests, configure your API token and installation ID in the `config.properties` file located in the `src/test/resources` directory.

Example `config.properties`:

```bash
# config.properties
api.url=https://lynx.iotopen.se
installation.id=YOUR_INSTALLATION_ID
api.token=YOUR_API_TOKEN
```
---

## Running the Tests

You can run the tests using Maven or an IDE like IntelliJ IDEA or Eclipse.

### Using Maven

To run the entire test suite, use the following command:

```bash
mvn clean test
```

### Using TestNG in an IDE

You can also run the tests using TestNG in an IDE by executing the `testng.xml` file. Simply right-click on the file and select "Run".

---

## API Endpoints Covered

The following endpoints from the IoT Open API are covered in this test suite:

### Devices

- **Create Device**: Adds a new device to the installation.
- **Update Device**: Updates an existing device with new details.
- **Get All Devices**: Retrieves a list of all devices in the installation.
- **Delete Device**: Removes a specific device from the installation.

### Functions

- **Create Function**: Adds a new function (e.g., temperature control) to a device.
- **Update Function**: Modifies an existing function for a device.
- **Get All Functions**: Retrieves a list of all functions associated with a device or installation.
- **Delete Function**: Removes a specific function from a device.

---

## Troubleshooting

- **404 Not Found**: Make sure the correct `installation.id` and `api.token` are provided in the `config.properties` file.
- **401 Unauthorized**: Ensure that your API token is valid by checking the `config.properties` file.
- **500 Internal Server Error**: Verify that the payload structure for the requests is correct.

---

### Additional Notes

- **IoT Open API Documentation**: For more detailed information about the API and its functionalities, refer to the official [IoT Open API documentation](https://lynx.iotopen.se).
- This project focuses on testing CRUD operations (Create, Read, Update, Delete) for both devices and their functions in the IoT Open platform.

---

