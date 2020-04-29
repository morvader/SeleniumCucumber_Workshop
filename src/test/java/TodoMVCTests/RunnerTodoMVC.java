package TodoMVCTests;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/features/TodoMVC",
        monochrome = true,
        plugin = {
                "pretty",
                "html:target/cucumber",
                "json:target/cucumber.json",
                "junit:target/cucumber.xml"
        },
        glue = {"TodoMVCTests"}
)
public class RunnerTodoMVC extends AbstractTestNGCucumberTests {
}
