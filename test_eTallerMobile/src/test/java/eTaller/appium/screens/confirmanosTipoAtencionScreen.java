package eTaller.appium.screens;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class confirmanosTipoAtencionScreen {

	private By cboTipoAtencion = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Spinner/android.view.ViewGroup");
	private By lstTipoAtencion = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView");
	private By btnFinalizarAtencion = MobileBy.id("pe.com.rimac.geo.procurador:id/btnVerMapa"); 
	private By lstOpcCasoFinalizar = MobileBy.id("pe.com.rimac.geo.procurador:id/opcion_caso_finalizar");

//	pe.com.rimac.geo.procurador:id/check1
//	pe.com.rimac.geo.procurador:id/opcion_caso_finalizar
	
	private By btnAceptar = MobileBy.id("android:id/button1");
	
	private AndroidDriver newappdriver = null;

	public confirmanosTipoAtencionScreen(AndroidDriver appDriver) {
		this.newappdriver = appDriver;
	}
	
	public void finalizarAtencion(String tipoAtencion, String tipoSiniestro) {

		WebDriverWait wait = new WebDriverWait(this.newappdriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnFinalizarAtencion));
        
		this.newappdriver.findElement(cboTipoAtencion).click();		
						
		List<MobileElement> lst_tipoAtencion = this.newappdriver.findElements(lstTipoAtencion.className("android.widget.TextView"));
		
		for(int i=0; i<lst_tipoAtencion.size() ; i++) {
//			System.out.println(String.valueOf(i) + " - " + sociasList.get(i).getText());
			if(lst_tipoAtencion.get(i).getText().toString().trim().compareTo(tipoAtencion)==0) {
				lst_tipoAtencion.get(i).click();
				break;
			}
		}
		
		if(tipoSiniestro.length()>1) {			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(lstOpcCasoFinalizar));   
			List<MobileElement> lst_OpcCasoFinalizar = this.newappdriver.findElements(lstOpcCasoFinalizar.className("android.widget.RadioButton"));

			for(int i=0; i<lst_OpcCasoFinalizar.size() ; i++) {
				if(lst_OpcCasoFinalizar.get(i).getText().toString().trim().compareToIgnoreCase(tipoSiniestro)==0) {
					lst_OpcCasoFinalizar.get(i).click();
					break;
				}
			}
		}
		
		this.newappdriver.findElement(btnFinalizarAtencion).click();		
		
		this.newappdriver.findElement(btnAceptar).click();
	}
}
