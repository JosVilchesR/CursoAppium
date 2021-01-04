package testClases;

import pages.CarruselPage;
import pages.CrearClientePage;
import pages.RegistroPage;

public class AgregarClienteCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearClientePage crearClientePage = new CrearClientePage();

    String nombre = "Jo";
    String id = "1234";
    String fono = "12345678";
    String dir = "calle 1";
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
        registroPage.validarCliente("Jo");
    }
}
