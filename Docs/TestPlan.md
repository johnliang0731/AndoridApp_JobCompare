# Test Plan

This is a test plan document for our group project in course CS6300.

**Author**: \<Team025\>

## 1 Testing Strategy

### 1.1 Overall Strategy

This group project will be built on the platform of Android Studio by using Java as primary language. Therefore, all the tests will be developed with Java and JUnit. First of all, the tests will be developed to cover all the functionality required in the design document/description to ensure the delivery of the application that meet clients' requirement. Specifically, the tests will be divided into two parts. One part is to test the user interface (UI). The tests are to verify that UIs can be rendered properly by clicking the corresponding buttons. The other part of the tests is focused on the backend logic. The tests will mainly confirm the backend part functions as design.

### 1.2 Test Selection

For the test selection, the white-box testing method will be used in our project and the developers will perform the tests for the app. Integration testing and regression testing will be utilized. The integration testing will be performed to ensure the all units of functionality are integrated and regression testing are performed after every change we make in the app, to guarantee the change does not break functionality. Moreover, the state/transition of the UIs and the logic of the backend codes will be carefully examed during the testing to achieve high quality of the program.

### 1.3 Adequacy Criterion

The testcases are aimed to cover the code as much as possible. The testcases are also aimed to cover the corner cases to void potential crash due to the extreme conditions. Moreover, the testcases are targeted to cross the UIs and backend logic. The testcases coverage will be measured and analyzed to make sure to obtain high value.

### 1.4 Bug Tracking

To track the bugs that can be shown during the use of the app, we will use the issue tab in the github to achieve so. Each time a bug is found, a new issue will be create under the issue tab with date, description and code associated with the bug. Weekly meeting will be scheduled to discuss the potential bugs and fix them one by one.

### 1.5 Technology

JUnit will be used to test our program.

## 2 Test Cases
|      Purpose     |    Steps     |   Expected Results  |    Actual Results     |     Pass/Fail     |  UI/function/DB  |
| ---------------- | ------------ | ------------------- | --------------------- | ----------------- | ---------------- |
|UI layout creation|create layout|return UI layouts| Return UI layouts | PASS | UI |
|button click|click buttons|call onClick function| button correctly call onClick function | PASS | UI and function|
|enter/edit current job|input current job info, click save|job info saved in currentJob attribute in SystemController| job info saved in SystemController | PASS | function |
|current job input data validation - out of range|input invalid data and click save|return data validation result and stop save job offer | stop save, show out of range alarm | PASS | function |
|current job input data validation - type error|input invalid data and click save|return data validation result and stop save job offer | stop save, show type error alarm | PASS | function |
|current job input data validation - empty entry|input invalid data and click save|return data validation result and stop save job offer| stop save, show empty entry alarm | PASS | function |
|add job offer|input job offer info, click save|job offer saved and then jump to main menu| job offer saved, then jump to main menu | PASS | function |
|add job offer and enter new one|input job offer info, click save and enter new job|job offer saved and then show an empty input chart | job offer saved and then show and all input fields are clear| PASS | function |
|add job offer and compare to current job|input job offer info, click compare to current job|job offer saved and shows job comparison with current job| job offer saved and then shows job comparison with current job| PASS | function |
|cancel job offer |input job offer info, click cancel |jump to main menu without save | jump to main menu without save | PASS | function |
|add job offer and compare jobs without current job|call comparison function|comparison blocked| comparison blocked | PASS | function |
|job offer input data validation - out of range|input invalid data and click save|return data validation result and stop save job offer | stop save, show out of range alarm | PASS | function |
|job offer input data validation - type error|input invalid data and click save|return data validation result and stop save job offer | stop save, show type error alarm | PASS | function |
|job offer input data validation - empty entry|input invalid data and click save|return data validation result and stop save job offer| stop save, show empty entry alarm | PASS | function |
|create ComparisonSettings with default values|create a ComparisonSettings instance|values are in default state| comparison setting are in default value 1 | PASS | function |
|add ComparisonSettings|call editComparisionSettings() function|a ComparisonSettings instance added to ControllerSystem| a ComparisonSettings instance added to ControllerSystem | PASS | function |
|ComparisonSettings input data validation - out of range|input invalid data and click save|return data validation result and stop save job offer | stop save, show out of range alarm | PASS | function |
|ComparisonSettings input data validation - type error|input invalid data and click save|not allowed input error type data| input not allowed | PASS | function |
|ComparisonSettings input data validation - empty entry|input invalid data and click save|return data validation result and stop save job offer| stop save, show empty entry alarm | PASS | function |
|get all job offers|call showJobOffers() function|return the sorted job offers in list| return the sorted job offers in list | PASS | function |
|calculate job rank score|call calculateJobScore() function|get the job score based on the formula|get the job score based on the formula | PASS | function |
|compare jobs without job offers|call comparison function|comparison blocked| shows alarm and comparison blocked | PASS | function |
|compare jobs with less than 2 jobs selected|call comparison function|comparison blocked| shows alarm and comparison blocked | PASS | function |
|compare jobs with more than 2 jobs selected|call comparison function|comparison blocked| shows alarm and comparison blocked | PASS | function |
|save job offers in DB|enter job offer details and save|a job offer record saved in DB| job offer record saved in DB | PASS | DB |
|save current job in DB|enter current job details and save|a current record saved in DB| current job record saved in DB | PASS | DB |
|edit current job and update DB|edit current job details and save|current record updated in DB| current record update in DB | PASS | DB |
|edit/save comparison setting in DB|edit comparison setting details and save it|a comparison setting record saved in DB| comparison setting record saved in DB | PASS | DB |
