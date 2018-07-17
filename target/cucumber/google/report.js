$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("LoginTMAWebmail.feature");
formatter.feature({
  "line": 2,
  "name": "Login Webmail",
  "description": "Login TMA Webmail",
  "id": "login-webmail",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@webmail"
    }
  ]
});
formatter.before({
  "duration": 7341760484,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Valid Login",
  "description": "",
  "id": "login-webmail;valid-login",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 6,
  "name": "I open browser to \"https://webmail.tma.com.vn/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "login with user and password are \"dmhuy123\" and \"123456\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "I should login successfully",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "https://webmail.tma.com.vn/",
      "offset": 19
    }
  ],
  "location": "stepDefination4webmail.i_open_browser_to(String)"
});
formatter.result({
  "duration": 1263981421,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "dmhuy123",
      "offset": 34
    },
    {
      "val": "123456",
      "offset": 49
    }
  ],
  "location": "stepDefination4webmail.login_with_user_and_password_are_and(String,String)"
});
formatter.result({
  "duration": 637498169,
  "status": "passed"
});
formatter.match({
  "location": "stepDefination4webmail.i_should_login_successfully()"
});
formatter.result({
  "duration": 32652759,
  "error_message": "java.lang.AssertionError: expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertTrue(Assert.java:44)\r\n\tat org.testng.Assert.assertTrue(Assert.java:54)\r\n\tat bdd.steps.webmail.stepDefination4webmail.i_should_login_successfully(stepDefination4webmail.java:47)\r\n\tat ✽.Then I should login successfully(LoginTMAWebmail.feature:8)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 1027414722,
  "status": "passed"
});
});