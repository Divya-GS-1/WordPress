package com.WordPress1.Library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
			
		public static void captureScreenshot(WebDriver driver, String TCname)
		{
			TakesScreenshot ts=(TakesScreenshot)driver;
			File sourse=ts.getScreenshotAs(OutputType.FILE);
			String destination="./Screenshots/"+TCname+".png";
			try {
				FileUtils.copyFile(sourse, new File(destination));
			} catch (Exception e) {
				System.out.println(e.getMessage()+" Exception found.");
			}
			
		}

	}
