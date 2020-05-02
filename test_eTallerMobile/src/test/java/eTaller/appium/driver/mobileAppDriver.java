package eTaller.appium.driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class mobileAppDriver {

//	-12.1110620, -77.0315913	ABA159	PROCURADOR AUTO3
//	-12.1709419, -77.0009815	ABA158	PROCURADOR AUTO4
//	-12.0965159, -77.0278309	ABA157	PROCURADOR AUTO5
	
//	static Double longitud= -12.1110620; //-18.5333 
//	static Double latitud = -77.0315913; //65.9667  -- 15.04444408

	// To Run = mvn clean test -Ddevice="ce05171510edb72801" -DappiumON="N"
	
    public static AppiumDriverLocalService service;
    public static AndroidDriver<AndroidElement> driver;
	
	public final static AndroidDriver<?> inicializarDriver(Double longitud, Double latitud) throws Exception {
//		PropertyLoader loadproperty = new PropertyLoader();
		
//		AndroidDriver<AndroidElement> driver = null;

		String appiumON2 = System.getProperty("appiumON");
        String udidDevice = System.getProperty("device");
        
//		File appDir = new File("src/test/resources/apk");
//		File app = new File(appDir, "app-release.apk"); //app-release.apk
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "Samsung Galaxy SXXX");
//		capabilities.setCapability(MobileCapabilityType.UDID, udidDevice);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
//		capabilities.setCapability("noReset", true);
//		capabilities.setCapability("fullReset", false);
//		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("appPackage", "pe.com.rimac.geo.procurador");
		capabilities.setCapability("appActivity", "pe.com.rimac.geo.procurador.Action.LoginActivity");
		// capabilities.setCapability("unicodeKeyboard", "true");
		// capabilities.setCapability("resetKeyboard", "true");
		capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

//		driver.resetApp();
		
//		capabilities.setCapability("app", app.getAbsolutePath());
		driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), capabilities); //127.0.0.1
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		Location location = new Location(longitud, latitud, 0);
		driver.setLocation(location);
		Thread.sleep(10000);
		System.out.println();
		
		
		
//		allowAppPermission();
		
//		try {
//            if (appiumON.equals("S")) {
//                URL url_appium = new URL("http://0.0.0.0:4723/wd/hub");
//                driver = new AndroidDriver(url_appium, capabilities); //clientCapabilities
//            } else {
////                app = new File(loadproperty.loadProperties().getProperty("apkDir"), loadproperty.loadProperties().getProperty("apkName"));
//                capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath()); //desiredCapabilities
//                // Appium service
//                AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(capabilities) //desiredCapabilities
//                        .withIPAddress("0.0.0.0")
//                        .usingPort(Integer.valueOf("4723"));
//                service = builder.build();
//                service.start();
//                driver = new AndroidDriver(service.getUrl(), capabilities); //clientCapabilities
//            }
//        } catch (Exception e) {
//            throw new Exception ("Error connecting to Appium service : " + e.getMessage());
//        }
		
		return driver;
	}

	public static void waitForPageLoaded(WebDriver driver) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState==\"complete\";"));
	}

	public static MobileElement mobileElement;
	public static boolean isElementPresent;

//	public static boolean waitForPresence(AndroidDriver driver, int timeLimitInSeconds, String targetResourceId) {
//
//		try {
//			mobileElement = (MobileElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"" + targetResourceId + "\")");
//			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
//			wait.until(ExpectedConditions.visibilityOf(mobileElement));
//			isElementPresent = mobileElement.isDisplayed();
//			return isElementPresent;
//		} catch (Exception e) {
//			isElementPresent = false;
//			System.out.println(e.getMessage());
//			return isElementPresent;
//		}
//	}
	
}
