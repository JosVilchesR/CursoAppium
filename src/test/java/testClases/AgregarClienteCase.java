package testClases;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegistroPage;

public class AgregarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Joss";
    String id = "123334";
    String fono = "12345678";
    String dir = "calle 1";
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
        registroPage.validarCliente("Joss");
    }
}
