package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import static reports.Reports.addStep;
import static utils.Utils.*;

public class DetalleClientePage {
    private AppiumDriver driver;
    public DetalleClientePage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    //Elementos
    @AndroidFindBy(id = "com.rodrigo.registro:id/title")
    private MobileElement tituloCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/eliminar_cliente")
    private  MobileElement btnEliminarCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/editTextDialogUserInput")
    private MobileElement txtBorrar;

    @AndroidFindBy (id = "android:id/button1")
    private MobileElement btnBorrarOK;

    //Métodos
    public void validarVistaDetalleCliente(String nombreCliente) {
        if (esperarObjeto(tituloCliente, 10)) {
            if (tituloCliente.equals(nombreCliente)) {
                addStep("Validar Vista Registro Desplegada", true, Status.PASSED, false);
            }
        } else {
            addStep("Error, validar Vista Registro Desplegado", true, Status.FAILED, true);
        }
    }

    public void eliminarCliente() {
        //swipeAbajoHastaEncontrarObj("com.rodrigo.registro:id/eliminar_cliente");
        swipeAbajo();
        swipeAbajo();
        espera(3);
        btnEliminarCliente.click();
        txtBorrar.setValue("BORRAR");
        btnBorrarOK.click();
    }
}
