# The Score Test Application

This project is designed to complete a basic framework that will perform some tests on The Score Android application

## Prerequisites

To run this project, you'll need to have the following installed:

- Java JDK 11 or higher
- Maven 3 or higher
- Internet connection
- Local Emulated Android Device

## Installation

To install and run the project, follow these steps:

1. Clone the repository to your local machine using Git.
2. Open a command prompt or terminal window and navigate to the root directory of the project.
3. Run the following command to download the dependencies and build the project: ```mvn clean install```

## Configuration

Before running the tests, make sure to configure the `config.properties` file with the following information:

- `local`: a boolean flag which indicates whether you are running the tests locally or remotely.
- `local.appium.server`: the Appium server endpoint for local testing.
- `driver.wait.timeout`: the maximum amount of time to wait for a WebDriver action to complete.

Before running the tests on saucelabs, you'll need to set the following environment variables:

- `SAUCE_USERNAME`: the username to use for authentication (if required).
- `SAUCE_ACCESS_KEY`: the access key to use for authentication (if required).

## Running the Tests

To run the tests, follow these steps:

1. Open a command prompt or terminal window and navigate to the root directory of the project.
2. Run the following command to execute the tests with the predefined properties already set in the pom: ```mvn test```

If you wish to run a specific configuration and tags, you can pass system properties in the mvn command. Here is an example to run on pixel_6, Android 12 with a specific app and the test tag:
```
mvn clean test -Dapp.file.name=theScore_23.3.0_apkcombo.com.apk -Ddevice.name=pixel_6 -Dandroid.version=12.0 -Dcucumber.filter.tags=@backNavigation
```
The test results will be displayed in the console.

## Contact

If you have any questions or feedback about this project, please contact  `tokeeffe9@gmail.com`.