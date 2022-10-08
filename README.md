# selenium_cucumber_java
This repository is created to automate the test scenarios using selenium

Tools and technologies used:

Browser UI automation: Selenium
Programming language: Java
Testing Framework: Cucumber BDD
Design pattern: Page object model
Build tool: Maven


Reports used:

Cucumber reports
Spark extent HTML and PDF reports


How to execute tests:
clone the repository to a local machine

1.  Go to project location and please use command line interface to run tests using command: mvn test
2.  Open the project to an IDE and run maven test ife cycle
3.  Open the project to an IDE and run cucumber runner file 

Once the execution is completed cucumber reports and extent HTML reports will be generated. 

In order to view cucumber reports, once execution is completed, we will be able to see a link generatd to view the reports on any browser, all the scenario steps and failures will be generated.

In order to view Spark extent HTML reports, once execution is completed, there will be a folder named test-output directory under project directory
Inside test-output directory, there will be 2 sub folders and a screenshot of a failed test case will be stores as a png extension
Folder1: Pdfreport --> There will be a pdf report that will be generated
Folder2: SparkReport --> There will be a .html file report that will be generated.

Note: Knowingly failed a test case in scenario 1 in order to verify teh screnshot in test report.
