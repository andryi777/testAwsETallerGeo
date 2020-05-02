package eTaller.appium.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class llegadaScreen {
	
	private By btnLlegadaLugar = MobileBy.id("pe.com.rimac.geo.procurador:id/btnConfirmar"); 

	
	private AndroidDriver newappdriver = null;

	public llegadaScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void marcarLlegada() {

		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnLlegadaLugar));
        
//		System.out.println(this.newappdriver.findElement(btn_VerMapa).getText());
		
		this.newappdriver.findElement(btnLlegadaLugar).click();

	}
}



