package testSuite;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.BorrarClienteCase;

import static conexion.DriverContext.setUp;
import static reports.Reports.finalAssert;

public class BorrarCliente {
    @BeforeMethod
    public void iniciarSession() {
        setUp("emulador-5554", "Android", "C:\\Users\\exjvilr\\Downloads\\registroDeUsuarios.apk", "emulador-5554", true);
    }

    @AfterMethod
    public void cerrarSession() {
        DriverContext.quitDriver();
    }

    @Test
    public void borrarCliente() {
       BorrarClienteCase test = new BorrarClienteCase();
        test.flujo();
        finalAssert();
    }
}
