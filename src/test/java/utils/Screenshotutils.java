package utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

public class Screenshotutils {
	public static String captureScreenshot(WebDriver driver, String testName) {
		// TODO Auto-generated method stub
		String folderPath = System.getProperty("user.dir") + "/target/screenshots/";
	    File folder = new File(folderPath);

	    // Create folder if not exists
	    if (!folder.exists()) {
	        folder.mkdirs();
	    }

TakesScreenshot ts = (TakesScreenshot) driver;
File source = ts.getScreenshotAs(OutputType.FILE);
String path = folderPath + testName + ".png";
File destination = new File(path);
{
try {
    FileUtils.copyFile(source, destination);
} catch (IOException e) {
    e.printStackTrace();
}
return path;
}}}


