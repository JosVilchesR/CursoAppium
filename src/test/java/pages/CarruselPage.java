package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;
import static reports.Reports.addStep;
import static utils.Utils.*;

public class CarruselPage {
    //TITULO

    //VALIDA TITULO
    private AppiumDriver driver;

    public CarruselPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    /**
     * Objetos
     */

    @AndroidFindBy(id = "com.rodrigo.registro:id/imageView2")
    private MobileElement iconoVista1;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.support.v4.view.ViewPager/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
    private  MobileElement tituloVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/textView")
    private MobileElement descripcionVista;

    @AndroidFindBy(id = "com.rodrigo.registro:id/next")
    private MobileElement btnFlecha;

    public void validarVistaDesplegada() {
        if (iconoVista1.isDisplayed()) {
            addStep("Validar vista 1 de carrusel", true, Status.PASSED, false);
        } else {
            addStep("Validar vista 1 de carrusel", true, Status.FAILED, false);
        }
    }

    public void validarTextoVistaCarrusel() {
        String textoDescripcionVista1 = descripcionVista.getText();
        if (textoDescripcionVista1.equals("Con Registro podrás guardar de forma fácil y segura todo lo relacionado a la venta de productos o servicios.")) {
            addStep("Validar vista 1 de carrusel", true, Status.PASSED, false);
        } else {
            addStep("Validar vista 1 de carrusel", true, Status.FAILED, false);
        }
    }

    public void validarTextoVista1Carrusel() {
        if (esperarObjeto(descripcionVista, 5)) {
            String textoDescripcionVista1 = descripcionVista.getText();
        }
    }












}
