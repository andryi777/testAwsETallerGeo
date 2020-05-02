package eTaller.appium.screens;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class placaScreen {
	
	
	private By lyoutPlaca = MobileBy.id("pe.com.rimac.geo.procurador:id/rlFCplaca");
	private By letra6 = MobileBy.id("pe.com.rimac.geo.procurador:id/placa6");

	private By btnContactar = MobileBy.id("pe.com.rimac.geo.procurador:id/btnFinalizar");
	
	private AndroidDriver newappdriver = null;

	public placaScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void ingresarLetraPlaca(String placa) {
				
		this.newappdriver.findElement(letra6).sendKeys(placa.substring(5, 6));		
		this.newappdriver.findElement(btnContactar).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newappdriver.findElementByXPath("//*[@text=\""+"ACEPTAR"+"\"]").click();
		
	}
}
