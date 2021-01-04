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

    String nombre = "Josefa";
    String id = "123456";
    String fono = "121212";
    String dir = "calle 2";
    String notas = "Sin notas";

    public void flujo() {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        //falta...
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearCliente();

        crearClientePage.validarVistaDesplegada();
        crearClientePage.completarFormulario(nombre, id, fono, dir, notas);
        crearClientePage.tapGuardar();

        registroPage.validarVistaDesplegada();
        registroPage.validarCliente("Josefa");
        registroPage.seleccionarCliente("Josefa");

        detalleClientePage.validarVistaDetalleCliente("Josefa");
        detalleClientePage.eliminarCliente();
        registroPage.validarVistaDesplegada();
        //registroPage.ingresarTabClientes();
        registroPage.validarClienteEliminado("Josefa");
    }
}
