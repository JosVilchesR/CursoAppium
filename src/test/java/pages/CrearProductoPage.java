package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.esperarObjeto;

public class CrearProductoPage {
    private AppiumDriver driver;
    public CrearProductoPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Elementos
    @AndroidFindBy(id = "//android.widget.TextView[contains(@text, 'Crear Producto')]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement txtNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private  MobileElement txtPrecioProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    //Métodos
    public void validarVistaDesplegada() {
        if (esperarObjeto(tituloVistaCrearProducto, 5)) {
            addStep("Validar Vista Crear Producto Desplegada", true, Status.PASSED, false);
        } else {
            addStep("Error, validar Vista Crear Producto Desplegada", true, Status.FAILED, true);
        }
    }

    public void completarFormulario(String nombreProducto, String precioProducto) {
        txtNombreProducto.setValue(nombreProducto);
        this.driver.hideKeyboard();
        txtPrecioProducto.click();
        txtPrecioProducto.setValue(precioProducto);
        this.driver.hideKeyboard();

    }

    public void tapConfirmar() {
        btnConfirmar.click();
    }
}
