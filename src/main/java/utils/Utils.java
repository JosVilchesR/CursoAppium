package utils;

import conexion.DriverContext;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static boolean esperarObjeto(MobileElement elemento, int segundos) {
        try {
            System.out.println("Buscamos elemento : " + elemento + ", esperamos " + segundos + " segundos, hasta que aparezca");
            WebDriverWait wait = new WebDriverWait(DriverContext.getDriver(), segundos);
            wait.until(ExpectedConditions.visibilityOf(elemento));
            System.out.println("Se encontró el elemento (" + elemento + "), se retorna true");
            return  true;
        } catch (Exception e) {
            System.out.println("No se encontró el elemento (" + elemento + "), se retorna false");
            return false;
        }
    }

    public static void espera(long segundos) {
        try {
            System.out.println("Esperamos " + segundos + " segundos");
            Thread.sleep(segundos * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Error en la espera: " + e.getMessage());
        }
    }

    public static void swipeAbajo() {
        int ancho = (int) (DriverContext.getDriver().manage().window().getSize().width * 0.08D);
        int startPoint = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.9D);
        // Si necesitaramos un swipe mas largo: usar 0.69D por ejemplo.
        int endPoint = (int) (DriverContext.getDriver().manage().window().getSize().height * 0.65D);

        TouchAction touchAction = new TouchAction(DriverContext.getDriver());
        touchAction.press(PointOption.point(ancho,startPoint)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500L))).moveTo(PointOption.point(ancho, endPoint)).release().perform();
        System.out.println("[Utils] Swipe hacia Abajo");
    }

}
