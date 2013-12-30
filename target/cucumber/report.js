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
  "duration": 137904000,
  "status": "failed",
  "error_message": "cucumber.runtime.CucumberException: Failed to instantiate class com.sashimi.login.ITLoginStepDefs\n\tat cucumber.fallback.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:45)\n\tat cucumber.fallback.runtime.java.DefaultJavaObjectFactory.getInstance(DefaultJavaObjectFactory.java:31)\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:35)\n\tat cucumber.runtime.StepDefinitionMatch.runStep(StepDefinitionMatch.java:44)\n\tat cucumber.runtime.Runtime.runStep(Runtime.java:256)\n\tat cucumber.runtime.model.StepContainer.runStep(StepContainer.java:44)\n\tat cucumber.runtime.model.StepContainer.runSteps(StepContainer.java:39)\n\tat cucumber.runtime.model.CucumberScenario.run(CucumberScenario.java:36)\n\tat cucumber.junit.ExecutionUnitRunner.run(ExecutionUnitRunner.java:76)\n\tat cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:65)\n\tat cucumber.junit.FeatureRunner.runChild(FeatureRunner.java:20)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:300)\n\tat cucumber.junit.FeatureRunner.run(FeatureRunner.java:72)\n\tat cucumber.junit.Cucumber.runChild(Cucumber.java:76)\n\tat cucumber.junit.Cucumber.runChild(Cucumber.java:36)\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:231)\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:60)\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:229)\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:50)\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:222)\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:300)\n\tat cucumber.junit.Cucumber.run(Cucumber.java:81)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:236)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:134)\n\tat org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:113)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.lang.reflect.Method.invoke(Method.java:606)\n\tat org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)\n\tat org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)\n\tat org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)\n\tat org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:103)\n\tat org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:74)\nCaused by: java.lang.reflect.InvocationTargetException\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)\n\tat sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:57)\n\tat sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)\n\tat java.lang.reflect.Constructor.newInstance(Constructor.java:526)\n\tat cucumber.fallback.runtime.java.DefaultJavaObjectFactory.cacheNewInstance(DefaultJavaObjectFactory.java:39)\n\t... 38 more\nCaused by: org.openqa.selenium.WebDriverException: Specified firefox binary location does not exist or is not a real file: /usr/bin/firefox\nBuild info: version: \u00272.37.0\u0027, revision: \u0027a7c61cbd68657e133ae96672cf995890bad2ee42\u0027, time: \u00272013-10-18 09:51:02\u0027\nSystem info: host: \u0027localhost\u0027, ip: \u0027127.0.0.1\u0027, os.name: \u0027Mac OS X\u0027, os.arch: \u0027x86_64\u0027, os.version: \u002710.8.5\u0027, java.version: \u00271.7.0_25\u0027\nDriver info: driver.version: unknown\n\tat org.openqa.selenium.firefox.internal.Executable.\u003cinit\u003e(Executable.java:57)\n\tat org.openqa.selenium.firefox.FirefoxBinary.\u003cinit\u003e(FirefoxBinary.java:59)\n\tat WhichWebdriver.WhichWebDriverFactory.createDriver(WhichWebDriverFactory.java:209)\n\tat WhichWebdriver.WhichWebDriverFactory.getInstance(WhichWebDriverFactory.java:175)\n\tat com.sashimi.login.ITLoginStepDefs.\u003cinit\u003e(ITLoginStepDefs.java:26)\n\t... 43 more\n"
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
  "status": "skipped"
});
formatter.match({
  "location": "ITLoginStepDefs.I_should_be_logged_in()"
});
formatter.result({
  "status": "skipped"
});
});