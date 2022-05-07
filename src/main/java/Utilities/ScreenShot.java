package Utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void TakesShot(WebDriver driver,String name) throws IOException {
		String amit=ScreenShot.Savedate();
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination=new File("C:\\Users\\Asus\\eclipse-workspace\\KiteZerodha\\src\\ScreenShot"+name+""+amit+".jpg");
		FileHandler.copy(source, destination);
	}
	public static String Savedate() {
		DateTimeFormatter dft= DateTimeFormatter.ofPattern("(dd-MMM-yyyy)(HH-mm-ss)");//date and time formate as we required
		LocalDateTime now=LocalDateTime.now();// to take local time of system
		String d=dft.format(now);
		return d;
	}

}
