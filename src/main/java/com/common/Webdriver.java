package com.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Webdriver {

	public static Properties CONFIG = null;
	public static Properties OR = null;
	public static WebDriver driver = null;

	public static boolean isLoggedIn = false;

	public static WebDriver getDriver() throws IOException {

		if (driver == null) {

			CONFIG = new Properties();

			FileInputStream fn = new FileInputStream(System.getProperty("user.dir") + "//TestData//Config.properties");
			CONFIG.load(fn);

			if (CONFIG.getProperty("browser").equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "//src//test//resources//chromedriver.exe");

				driver = new ChromeDriver(chromeCapabilities());

			} else if (CONFIG.getProperty("browser").equals("FireFox")) {
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		return driver;

	}

	private static DesiredCapabilities chromeCapabilities() {

		DesiredCapabilities cap = DesiredCapabilities.chrome();

		ChromeOptions options = new ChromeOptions();

		Map<String, Object> prefs = new HashMap<>();
		Map<String, Object> content_setting = new HashMap<>();

		options.addArguments("start-maximized");

		content_setting.put("multiple-automatic-downloads", 1);
		content_setting.put("popups", 0);

		prefs.put("download.prompt_for_download", "false");
		String defaultDirectory = System.getProperty("user.dir") + "//Downloads";

		prefs.put("download.default_directory", defaultDirectory);
		System.out.println("Storing downloaded files in: " + defaultDirectory);
		prefs.put("profile.default_content_settings", content_setting);

		System.out.println("Prefs: " + prefs);

		options.setExperimentalOption("prefs", prefs);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return cap;
	}

	public static void killWebDriversAndRelatedBrowsers() {
		kill("chromedriver.exe");
		// kill("IEDriverServer.exe");
	}

	public static void kill(String process) {
		try {
			Runtime.getRuntime().exec("taskkill /im " + process + " /f /t");
		} catch (Exception e) {
			//
		}
	}

}
