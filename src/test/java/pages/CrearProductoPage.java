package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.espera;
import static utils.Utils.esperarObjeto;

public class CrearProductoPage {
    private AppiumDriver driver;
    public CrearProductoPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Elementos
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Crear Producto')]")
    private MobileElement tituloVistaCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private MobileElement txtNombreProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/precio")
    private  MobileElement txtPrecioProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/confirmar")
    private MobileElement btnConfirmar;

    //Métodos
    public void validarVistaDesplegada() {
        espera(3);
        if (esperarObjeto(tituloVistaCrearProducto, 15)) {
            addStep("Validar Vista Crear Producto Desplegada", true, Status.PASSED, false);
        } else {
            addStep("Error, validar Vista Crear Producto Desplegada", true, Status.FAILED, true);
        }
    }

    public void completarFormulario(String nombreProducto, String precioProducto) {
        System.out.println("[Crear Producto] completar formulario");
        txtNombreProducto.setValue(nombreProducto);
        this.driver.hideKeyboard();
        txtPrecioProducto.click();
        txtPrecioProducto.setValue(precioProducto);
        this.driver.hideKeyboard();
        addStep("Completar formulario para Crear Producto", true, Status.PASSED, false);
    }

    public void tapConfirmar() {
        if (esperarObjeto(btnConfirmar, 3)) {
            btnConfirmar.click();
            addStep("Se hace tap en 'Boton Confirmar'", false, Status.PASSED, false);
        } else {
            addStep("Error, no se encuentra 'Botón Guardar'", true, Status.FAILED, true);
        }
    }
}
