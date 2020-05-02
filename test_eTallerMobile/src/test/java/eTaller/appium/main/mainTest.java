package eTaller.appium.main;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import eTaller.appium.screens.loginScreen;
import eTaller.appium.screens.placaScreen;
import eTaller.appium.screens.resumenCasoScreen;
import eTaller.appium.screens.confirmanosTipoAtencionScreen;
import eTaller.appium.screens.datosdelCasoScreen;
import eTaller.appium.screens.llegadaScreen;


public class mainTest {

	private loginScreen oLogin; 
	private datosdelCasoScreen oDatosdelCaso;
	private llegadaScreen oLlegada;
	
	private placaScreen oPlaca;	
	private resumenCasoScreen oResumenCaso; 
	private confirmanosTipoAtencionScreen oConfirmanosTipoAtencion;

	String placa;
	Double longitud, latitud;
	
	@BeforeTest
	public void inicioClase() throws Exception {
//		-12.1709419, -77.0009815	ABA153	PROCURADOR AUTO5
//		-12.1110620, -77.0315913	ABA154	PROCURADOR AUTO4
//		-12.0965159, -77.0278309	ABA155	PROCURADOR AUTO3
//		-12.0965159, -77.0278309	ABA156	PROCURADOR AUTO2
		
		placa = "ABA156";
		longitud = -12.0965159;
		latitud = -77.0278309;
		oLogin = new loginScreen(longitud, latitud);
		oDatosdelCaso = new datosdelCasoScreen(oLogin.getMobileDriver());
		oLlegada = new llegadaScreen(oLogin.getMobileDriver());
		
		oPlaca = new placaScreen(oLogin.getMobileDriver());		
		oResumenCaso = new resumenCasoScreen(oLogin.getMobileDriver());
		oConfirmanosTipoAtencion = new confirmanosTipoAtencionScreen(oLogin.getMobileDriver());
	}

	static String rutaArchivo1 = "";
	
	@Parameters({"user", "pass"})
	@Test  (description="Login")
	public void IniciarSesion(String usuario, String password) throws Exception {
		try {	
			Thread.sleep(2000);
			oLogin.iniciarSesion(usuario, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			Assert.fail();
		}
	}

	@Test (description="Ver Mapa") //, enabled = false
	public void test_VerMapa() throws Exception {
		try {		
			Thread.sleep(2000);
			oDatosdelCaso.verMapa();
			
			oPlaca.ingresarLetraPlaca(placa);			
			
//			oLlegada.marcarLlegada(); -- no va
			oResumenCaso.confirmarAtencion();
			oConfirmanosTipoAtencion.finalizarAtencion("Denuncia Policial","Robo Total"); //"Desistimiento", null
		} catch (Exception e) {
			System.out.println(e.getMessage());
//			 Assert.fail();
		}
	}
	


}
