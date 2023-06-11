## Mechanic Advisor tech task
## UI Automation of 'STEER' project

Tools:

- Java 11
- Maven
- Selenide
- JUnit
- Allure
- Tinylog

## How to run

You can run tests in 3 different ways using:

- IDE
- Maven
- GitLab pipelines

### I. Run using IDE

1. Open the project in IDE
2. Resolve dependencies
3. Navigate to a suite/test you want to run:
    - /src/test/java/tests/AppointmentTest.java
4. Click the right button and run selected suite/test

### II. Run using Maven

1. Navigate to root project directory, where `pom.xml` is located
2. Run suite/test using this command:

```
 mvn clean test
```

#### Generate Allure report

1. Navigate to root project directory, where `pom.xml` is located
2. Run command:

```
mvn io.qameta.allure:allure-maven:report
```  

- The Allure report will be generated to target/site/allure-maven-plugin
- Open in browser index.html to observe the report

### III. Run on GitLab CI/CD

1. On GitLab project repository navigate to CI/CD => pipelines
2. Click on 'Run pipeline'
3. Pipeline will be executed according to `.gitlab-ci.yml` configuration file
4. The Allure report can be found by path:

```
https://shubicus.gitlab.io/-/steer/-/jobs/${CI_JOB_ID}/artifacts/target/site/allure-maven-plugin/index.html
```

**NOTE: Replace ${CI_JOB_ID} with the actual value!**
