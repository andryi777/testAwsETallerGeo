package eTaller.appium.screens;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import eTaller.appium.driver.mobileAppDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class loginScreen {

	//("pe.com.rimac.geo.procurador:id/email");
	
	private By btnAllow = MobileBy.id("com.android.packageinstaller:id/permission_allow_button");
	
	private By txtlblMensaje =MobileBy.id("android:id/message");
	
	private By txtUser = MobileBy.id("pe.com.rimac.geo.procurador:id/email");
	private By txtPassword = MobileBy.id("pe.com.rimac.geo.procurador:id/password");
	private By btnLogIn = MobileBy.id("pe.com.rimac.geo.procurador:id/email_sign_in_button");
	
	private AndroidDriver newappdriver = null;

	public loginScreen(Double longitud, Double latitud) throws Exception {
		this.newappdriver = mobileAppDriver.inicializarDriver(longitud, latitud);
	}
	
	public void iniciarSesion(String user, String pass) {
	
		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(txtUser));
        
		this.newappdriver.findElement(txtUser).clear();
		this.newappdriver.findElement(txtUser).sendKeys(user);
		
		this.newappdriver.findElement(txtPassword).clear();
		this.newappdriver.findElement(txtPassword).sendKeys(pass);
		
		if(this.newappdriver.isKeyboardShown()) { this.newappdriver.hideKeyboard(); }
		
		this.newappdriver.findElement(btnLogIn).click();
	}
	
	public AndroidDriver getMobileDriver() {
		return newappdriver;
	}
}
