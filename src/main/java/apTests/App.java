
/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package apTests;
import java.net.MalformedURLException;
import org.openqa.selenium.TakesScreenshot;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;


public class App {

    public static void logStatus(String type, String message, String status) {

        System.out.println(String.format("%s |  %s  |  %s | %s", String.valueOf(java.time.LocalDateTime.now()), type,
                message, status));
    }


    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {

        File directory = new File("screenshots");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Generate a unique string using the timestamp
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH-mm-ss.SSS");
        String timeStamp = dateFormat.format(new Date());

        // Capture screenshot
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save the screenshot inside the "/screenshots" folder
        String fileName = String.format("screenshot_%s_%s_%s.png", timeStamp, screenshotType, description);
        String filePath = "screenshots/" + fileName;
        try {
            Files.copy(screenshotFile.toPath(), Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("Error saving screenshot: " + e.getMessage());
        }


    }   


    public void getGreeting() throws InterruptedException, MalformedURLException {
        TestCases tests = new TestCases(); // Initialize your test class

        //TODO: call your test case functions one after other here

        System.out.println(" ");

        tests.testCase01();

        System.out.println(" ");

        tests.testCase02();

        System.out.println(" ");

        tests.testCase03();

        System.out.println(" ");

        //END Tests
        tests.endTest(); // End your test by clearning connections and closing browser
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        new App().getGreeting();
    }
}
