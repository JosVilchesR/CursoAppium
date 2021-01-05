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

public class CrearClientePage {
    private AppiumDriver driver;
    public CrearClientePage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Elementos

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'Crear Cliente')]")
    private MobileElement tituloVistaCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ac_nombre")
    private MobileElement txtNombre;

    @AndroidFindBy(id = "com.rodrigo.registro:id/ruc")
    private MobileElement txtId;

    @AndroidFindBy(id = "com.rodrigo.registro:id/tel")
    private MobileElement txtFono;

    @AndroidFindBy(id = "com.rodrigo.registro:id/dir")
    private MobileElement txtDir;

    @AndroidFindBy(id = "com.rodrigo.registro:id/notas")
    private MobileElement txtNotas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/guardar")
    private MobileElement btnGuardar;

    public void validarVistaDesplegada() {
        espera(3);
        if (esperarObjeto(tituloVistaCrearCliente, 10)) {
            addStep("Validar Vista Crear Cliente", true, Status.PASSED, false);
        } else {
            addStep("Error, validar Vista Crear Cliente", true, Status.FAILED, true);
        }
    }

    public void completarFormulario(String name, String id, String fono, String dir, String notas) {
        System.out.println("[Crear Cliente] completar formulario");
        espera(3);
        txtNombre.setValue(name);
        this.driver.hideKeyboard(); //sirve para bajar teclado
        txtId.click();
        txtId.setValue(id);
        this.driver.hideKeyboard();
        txtFono.click();
        txtFono.setValue(fono);
        this.driver.hideKeyboard();
        txtDir.click();
        txtDir.setValue(dir);
        this.driver.hideKeyboard();
        txtNotas.click();
        txtNotas.setValue(notas);
        this.driver.hideKeyboard();
        addStep("Completar formulario de crear cliente", true, Status.PASSED, false);
    }

    public void tapGuardar() {
        if (esperarObjeto(btnGuardar, 3)) {
            btnGuardar.click();
            addStep("Se hace tap en 'Botón Guardar'", false, Status.PASSED, false);
        } else {
            addStep("Error, no se encuentra 'Botón Guardar'", true, Status.FAILED, true);
        }
    }
}

