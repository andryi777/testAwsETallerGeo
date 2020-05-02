package eTaller.appium.screens;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class resumenCasoScreen {
	
	private By btnConfirmarTipoAtencion = MobileBy.id("pe.com.rimac.geo.procurador:id/btnVerMapa"); 

	private AndroidDriver newappdriver = null;

	public resumenCasoScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void confirmarAtencion() {

		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnConfirmarTipoAtencion));
        
//		System.out.println(this.newappdriver.findElement(btn_VerMapa).getText());
		
		this.newappdriver.findElement(btnConfirmarTipoAtencion).click();

	}
}
