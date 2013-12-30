$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri('com/sashimi/login/login.feature');
formatter.feature({
  "id": "login-to-sashimi",
  "tags": [
    {
      "name": "@SashimiLogin",
      "line": 1
    }
  ],
  "description": "",
  "name": "Login to Sashimi",
  "keyword": "Feature",
  "line": 3
});
formatter.scenario({
  "id": "login-to-sashimi;i-am-on-the-sashimi-page-and-i-log-in.",
  "description": "",
  "name": "I am on the Sashimi page and I log in.",
  "keyword": "Scenario",
  "line": 5,
  "type": "scenario"
});
formatter.step({
  "name": "I am on the homepage",
  "keyword": "Given ",
  "line": 6
});
formatter.step({
  "name": "I enter in my login credentials \"selenium001\" and \"password\"",
  "keyword": "And ",
  "line": 7
});
formatter.step({
  "name": "I should be logged in",
  "keyword": "Then ",
  "line": 8
});
formatter.match({
  "location": "ITLoginStepDefs.WhichLogin()"
});
formatter.result({
  "duration": 23126349000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "selenium001",
      "offset": 33
    },
    {
      "val": "password",
      "offset": 51
    }
  ],
  "location": "ITLoginStepDefs.I_enter_in_my_login_credentials_and(String,String)"
});
formatter.result({
  "duration": 140890000,
  "status": "passed"
});
formatter.match({
  "location": "ITLoginStepDefs.I_should_be_logged_in()"
});
formatter.result({
  "duration": 1861689000,
  "status": "passed"
});
});