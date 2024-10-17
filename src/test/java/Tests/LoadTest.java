package Tests;

import org.testng.annotations.Test;

public class LoadTest extends TestBase {  // Extend TestBase to inherit WebDriver and report setup

    @Test(threadPoolSize = 5, invocationCount = 20)  // Simulate 20 users with 5 threads
    public void testHomePage() {
        test = extent.createTest("Load Test", "Simulate load testing with multiple users");

        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");

        // Additional actions or assertions can be added here
        // Example: Verify page title
        String pageTitle = driver.getTitle();
        test.info("Page title is: " + pageTitle);

        // Add any necessary validations here
        test.pass("Page loaded successfully under load.");
    }
}
