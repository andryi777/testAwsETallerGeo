package eTaller.appium.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class datosdelCasoScreen {
	
	private By btn_VerMapa = MobileBy.id("pe.com.rimac.geo.procurador:id/btnVerMapa");
	private By lblPlaca = MobileBy.id("pe.com.rimac.geo.procurador:id/placa");
	private By lbl_Direccion = MobileBy.id("pe.com.rimac.geo.procurador:id/direccion");
	private By lbl_Referencia = MobileBy.id("pe.com.rimac.geo.procurador:id/referencia");
	
	private AndroidDriver newappdriver = null;

	public datosdelCasoScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void verMapa() {

		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btn_VerMapa));
        
//		System.out.println(this.newappdriver.findElement(btn_VerMapa).getText());
		
		this.newappdriver.findElement(btn_VerMapa).click();
		
		Location location = this.newappdriver.location();
		System.out.println(location);
		
		this.newappdriver.setLocation(new Location(119, 123, 10));
		System.out.println(location);
	}
	
//	public void regresar() {
//		this.newappdriver.findElement(btnBack).click();
//	}
	
}
