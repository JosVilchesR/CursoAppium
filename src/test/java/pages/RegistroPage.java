package pages;

import conexion.DriverContext;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.qameta.allure.model.Status;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static utils.Utils.*;
import static reports.Reports.*;

public class RegistroPage {
    private AppiumDriver driver;
    public RegistroPage() {
        this.driver = DriverContext.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    // Elementos
    @AndroidFindBy(xpath = "//*[contains(@text,\"Registro\")]")
    private MobileElement tituloVistaRegistro;

    @AndroidFindBy(id = "com.rodrigo.registro:id/fab_expand_menu_button")
    private MobileElement btnMas;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_cliente")
    private MobileElement btnCrearCliente;

    @AndroidFindBy(id = "com.rodrigo.registro:id/action_producto")
    private MobileElement btnCrearProducto;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_cliente")
    private List<MobileElement> labelsClientes;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'CLIENTES')]")
    private MobileElement tabClientes;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text, 'PRODUCTOS')]")
    private MobileElement tabProductos;

    @AndroidFindBy(id = "com.rodrigo.registro:id/nombre_producto")
    private List<MobileElement> nombresProductos;

    //Métodos
    public void validarVistaDesplegada() {
        if (esperarObjeto(tituloVistaRegistro, 10)) {
            addStep("Validar Vista Registro Desplegada", true, Status.PASSED, false);
        } else {
            addStep("Error, validar Vista Registro Desplegado", true, Status.FAILED, true);
        }
    }

    public void tapBtnMas() {
        if (esperarObjeto(btnMas, 5)) {
            addStep("Tap al botón '+'", false, Status.PASSED, false);
            btnMas.click();

            if (esperarObjeto(btnCrearCliente, 5) && (esperarObjeto(btnCrearProducto, 5))) {
                addStep("Se encuentran botones 'Crear Cliente' y 'Crear Producto'", true, Status.PASSED, false);
            } else {
                addStep("Error, los botones 'Crear Cliente' y 'Crear Producto' no se encuentran", true, Status.FAILED, true);
            }
        } else {
            addStep("Error, el botón '+' no se encuentra", true, Status.FAILED, true);
        }
    }

    public void tapBtnCrearCliente() {
        if (esperarObjeto(btnCrearCliente, 5)) {
            addStep("Tap al botón 'Crear cliente'", false, Status.PASSED, false);
            btnCrearCliente.click();
        } else {
            addStep("Error, el botón 'Crear cliente' no se encuentra", true, Status.FAILED, true);
        }
    }

    public void tapBtnCrearProducto() {
        if (esperarObjeto(btnCrearProducto, 5)) {
            addStep("Tap al botón 'Crear producto'", false, Status.PASSED, false);
            btnCrearProducto.click();
        } else {
            addStep("Error, el botón 'Crear cliente' no se encuentra", true, Status.FAILED, true);
        }
    }

    public void ingresarTabClientes() {
        if (esperarObjeto(tabClientes, 5)) {
            addStep("Tap a la Tab 'CLIENTES'", false, Status.PASSED, false);
            tabClientes.click();
        } else {
            addStep("Error el Tab'CLIENTES' no se encuentra", true, Status.FAILED, true);
        }
    }

    public void ingresarTabProductos() {
        if (esperarObjeto(tabProductos, 5)) {
            addStep("Tap a la Tab 'PRODUCTOS'", false, Status.PASSED, false);
            tabProductos.click();
        } else {
            addStep("Error el Tab'PRODUCTOS' no se encuentra", true, Status.FAILED, true);
        }
    }


    public void validarProducto(String nombreProducto, String precioProducto) {
        System.out.println("[RegistroProducto] validar Producto");
        boolean productoEncontrado = false;
        if (nombresProductos.size() != 0) {
            for (int i = 0; i <= nombresProductos.size(); i++) {
                String nombreProductoActual = nombresProductos.get(i).getText();
                System.out.println("dentro de fila: " + nombreProductoActual);
                if (nombreProductoActual.equals(nombreProducto)) {
                    productoEncontrado = true;
                    System.out.println("Encontre el producto");
                    i = nombresProductos.size();
                    addStep("Se encuentra producto " + nombreProducto, true, Status.PASSED, false);
                }
            }
        } else {
            addStep("Error, el producto" + nombreProducto + " no se encuentra", true, Status.FAILED, true);
        }
    }

    public void validarCliente(String nombreCliente) {
        System.out.println("[RegistroCliente] validar Cliente");
        boolean clienteEncontrado = false;
        if (labelsClientes.size() != 0) {
            for (int i = 0; i <= labelsClientes.size(); i++) {
                String nombreClienteActual = labelsClientes.get(i).getText();
                if (nombreClienteActual.equals(nombreCliente)) {
                    clienteEncontrado = true;
                    i = labelsClientes.size();
                    addStep("Se encuentra cliente " + nombreCliente, true, Status.PASSED, false);
                }
            }
        } else {
            addStep("Error, el cliente" + nombreCliente + " no se encuentra", true, Status.FAILED, true);
        }
    }

    public void validarClienteEliminado(String nombreCliente) {
        System.out.println("[RegistroCliente] validar Cliente");
        boolean clienteEncontrado = true;
        if (labelsClientes.size() != 0) {
            for (int i = 0; i <= labelsClientes.size(); i++) {
                String nombreClienteActual = labelsClientes.get(i).getText();
                if (nombreClienteActual.equals(nombreCliente)) {
                    clienteEncontrado = false;
                    i = labelsClientes.size();
                    addStep("No se encuentra cliente " + nombreCliente, true, Status.PASSED, false);
                }
            }
        } else {
            addStep("Error, el cliente" + nombreCliente + " se encuentra en el listado", true, Status.FAILED, true);
        }
    }

    public void seleccionarCliente(String nombreCliente) {
        System.out.println("[RegistroCliente] Seleccionar Cliente");
        for (int i = 0; i <= labelsClientes.size(); i++) {
            String nombreClienteActual = labelsClientes.get(i).getText();
            if (nombreClienteActual.equals(nombreCliente)) {
                labelsClientes.get(i).click();
                i = labelsClientes.size();
                espera(3);
                addStep("Se encuentra y selecciona cliente " + nombreCliente, true, Status.PASSED, false);
            }
        }
    }















}
