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
        System.out.println("Método eliminarCliente");
        int cont = 0;
        do {
            cont++;
            swipeAbajo();
        } while(cont < 2);

        if (esperarObjeto(btnEliminarCliente, 3)) {
            btnEliminarCliente.click();
            espera(3);
            addStep("PopUp confirmación eliminación desplegado", true, Status.PASSED, false);
            txtBorrar.setValue("BORRAR");
            btnBorrarOK.click();
        } else {
            addStep("Error, no se encuentra PopUp confirmación eliminación", false, Status.FAILED, true);
        }
    }
}
