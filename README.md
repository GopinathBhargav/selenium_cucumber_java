# selenium_cucumber_java
This repository is created to automate the test scenarios using selenium

Tools and technologies used:

1. Browser UI automation: Selenium
2. Programming language: Java
3. Testing Framework: Cucumber BDD
4. Design pattern: Page object model
5. Build tool: Maven


Reports used:

1. Cucumber reports
2. Spark extent HTML and PDF reports


How to execute tests:

clone the repository to a local machine

1.  Go to project location and please use command line interface to run tests using command: mvn test
2.  Open the project to an IDE and run maven test ife cycle
3.  Open the project to an IDE and run cucumber runner file 

Once the execution is completed cucumber reports and extent HTML reports will be generated. 

1. In order to view cucumber reports, once execution is completed, we will be able to see a link generatd to view the reports on any browser, all the scenario steps and failures will be generated.

2. In order to view Spark extent HTML reports, once execution is completed, there will be a folder named test-output directory under project directory
Inside test-output directory, there will be 2 sub folders and a screenshot of a failed test case will be stores as a png extension

 a. Folder1: Pdfreport --> There will be a pdf report that will be generated
 b. Folder2: SparkReport --> There will be a .html file report that will be generated.

Note: Knowingly failed a test case in scenario 1 in order to verify the screnshot in test report.
