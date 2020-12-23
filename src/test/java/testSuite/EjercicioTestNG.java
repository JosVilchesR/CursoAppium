package testSuite;

import org.testng.annotations.*;

public class EjercicioTestNG {

    @BeforeSuite
    public void metodo1() {
        System.out.println("Inicio de suite");
    }

    @AfterSuite
    public void metodo2() {
        System.out.println("Termino de suite");
    }

    @Test(priority=1)
    public void metodo3() {
        System.out.println("Test 1");
    }

    @Test(priority=2)
    public void metodo4() {
        System.out.println("Test 2");
    }

    @AfterMethod
    public void metodo5() {
        System.out.println("Termino test");
    }
}
