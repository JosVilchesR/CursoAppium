package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import static utils.Utils.swipeAbajo;

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

    }

    public void eliminarCliente() {
        swipeAbajo();
        btnEliminarCliente.click();
        txtBorrar.setValue("BORRAR");
        btnBorrarOK.click();
    }
}
