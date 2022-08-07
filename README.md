

##  Automation Framework



*Maven Framework made with using Selenium, Cucumber on Java.*

 - [x] Jenkins Implementation with testng and surefire.
 - [x] Paralel testing
 - [x] Cucumber Reports with screenshots on failed steps
 - [x] Page Object Model
 - [x] Utils with Global Variables such as url and default timeout

# Setup

Chrome (ver.104) and Gecko(ver.95) drivers are inside the project.
Using Java ver.11
Selenium ver. 4.0.0
Cucumber ver. 7.0.0
Maven ver.14

Parallel testing max threadCount is set to 5 by default, if you encounter any problems you can change it from testng.xml.
CucumberOptions tag is empty by default, you can add a tag at MainRunner.java and start running your features.

***Happy Testing!***
