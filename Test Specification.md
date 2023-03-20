# Test Specification

The purpose of this document is to specify the decisions made regarding testing this application

## Approach

I used my previous work experience to build this framework. Using a POM structure generally makes it a clean and sustainable project for companies and engineers. For my approach, I like to have both the methods and elements in the same page object file and I prefer using FindBy Annotations as I think it makes the code a lot cleaner while also allowing us to expand the framework in future. An example is if we need to test on iOS and we can simply add the iOS element to the same WebElement variable instead of needing separate elements for Android and iOS.

Cucumber is an easy way for both QA and business users to understand the tests, pass data and can also help externally from the framework when it comes to communicating test coverage when new stories are being created and story pointed.

I also like to add as many properties to the POM or system variables so the end user can configure as much dynamically as possible. I've also found this to be a good approach when the framework is implemented in a CI/CD pipeline so we can specify the builds we want to test each run.

Due to the time and local hardware, I only ran the tests on individual session. Obvious improvements would be to add tests in parallel.

## Test Case Description

The assignment was to generate test cases to navigate through the app to a team,player or league and either verify those pages or verify the user can navigate back. Initially I was going to parameterize this to allow the same test cases to do all three things however with time and complexity, I thought that would be too messy.

## Test Data

I have created a production account that is already setup with favorited leagues and teams. This is set in all the test cases in the feature file as I believed this would be the most consistent way to run the tests.

## Expected/Actual Results

The tests should verify a user is able to navigate to their login page and tap a team from their favorites to be navigated to the page they desire. The automation will verify the page by checking the text of elements, an example of this would be a team name or multiple players from that team. This should be sufficient from an end to end pov. For more detailed testing on the data itself, I believe it makes more sense to test the APIs directly.

As for actual results, the majority of times these tests should pass however there is some flakiness unfortunately that I just didn't have enough time to fully resolve. In particular with pop ups after login where they seemed to be random in sequence and would cause issue if they were not tapped correctly. I tried some loops to improve this but it definitely requires more work to be confident the tests will always pass.
