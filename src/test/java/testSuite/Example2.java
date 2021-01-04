package testSuite;


import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.qameta.allure.model.Status;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reports.Reports;
import testClases.TestCarrusel;

import static conexion.DriverContext.setUp;
import static reports.Reports.addStep;
import static reports.Reports.finalAssert;

public class Example2 {
    @BeforeMethod
    public void iniciarSession() {
        setUp("emulador-5554", "Android", "C:\\Users\\exjvilr\\Downloads\\registroDeUsuarios.apk", "emulador-5554", true);
    }

    public void cerrarSesion() {
        Reports.finalAssert();
        DriverContext.quitDriver();
    }

    @Test()
    public void test1() {
        MobileElement botonNext = (MobileElement) DriverContext.getDriver().findElementById("com.rodrigo.registro:id/next");
        botonNext.click();
        botonNext.click();
        addStep("Validar tercera vista Carrusel", true, Status.FAILED, false);
    }

    @Test( description = "Carrusel")
    public void testCarrusel() {
        TestCarrusel test = new TestCarrusel();
        test.validaciones();
        finalAssert();
    }
}
