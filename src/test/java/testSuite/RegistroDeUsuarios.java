package testSuite;

import conexion.DriverContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testClases.AgregarClienteCase;

import static conexion.DriverContext.setUp;

public class RegistroDeUsuarios {
    @BeforeMethod
    public void iniciarSession() {
        setUp("emulador-5554", "Android", "C:\\Users\\exjvilr\\Downloads\\registroDeUsuarios.apk", "emulador-5554", true);
    }

    @AfterMethod
    public void cerrarSession() {
        DriverContext.quitDriver();
    }

    @Test
    public void agregarCliente() {
        AgregarClienteCase test = new AgregarClienteCase();
        test.flujo();
    }
}

