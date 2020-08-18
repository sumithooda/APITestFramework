# APITestFramework
APITestFramework is developed to test application on url "https://jsonplaceholder.typicode.com".

#Getting Started
Clone project from Git hub repository, no credential required.
##Prerequisites
Maven,
JDK 1.8 or above

#Running the test locally
Running locally - to run test locally execute command "mvn test" in terminal.
or 
run testng.xml file

##Running the test in CICD
###prerequisites : 
1. Jenkins is up and running locally/centralised
2. Build pipline configured with this git repository url
3. for publish result install "report" plugin

Project root have a jenkins file contains all stages(compile, test, publish result) of pipeline execution.
###Break down into tests 
tests directory have 2 test classes
1. IntegrationTest - it contains 3 tests to fetch user(based on test data), fetch all post of that user, verify comments for all posts.
2. sanityTest - it contains to check response of service for different scenarios.

note: focus wasn't on making it data driven, thats why testng.xml file is used to pass data to tests.

#Authors
Sumit Hooda - Hoodas172@gmail.com