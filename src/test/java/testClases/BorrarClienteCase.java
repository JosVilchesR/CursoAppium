package testClases;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.DetalleClientePage;
import pages.RegistroPage;

public class BorrarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();
    DetalleClientePage detalleClientePage = new DetalleClientePage();

    String nombre = "Joji";
    String id = "17";
    String fono = "121212";
    String dir = "calle 2";
    String notas = "Sin notas";

    public void flujo() {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearCliente();

        crearClientePage.validarVistaDesplegada();
        crearClientePage.completarFormulario(nombre, id, fono, dir, notas);
        crearClientePage.tapGuardar();

        registroPage.validarVistaDesplegada();
        registroPage.validarCliente("Joji");
        registroPage.seleccionarCliente("Joji");

        detalleClientePage.validarVistaDetalleCliente("Joji");
        detalleClientePage.eliminarCliente();
        registroPage.validarVistaDesplegada();
        //registroPage.ingresarTabClientes();
        registroPage.validarClienteEliminado("Joji");
    }
}
