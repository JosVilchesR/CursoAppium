package testClases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

public class CrearProductoCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearProductoPage crearProductoPage = new CrearProductoPage();

    String nombreProducto = "Macetero";
    String precioProducto = "7500";

    public void flujo() {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearProducto();

        crearProductoPage.validarVistaDesplegada();
        crearProductoPage.completarFormulario(nombreProducto, precioProducto);
        crearProductoPage.tapConfirmar();

        registroPage.validarVistaDesplegada();
        registroPage.ingresarTabProductos();
        registroPage.validarVistaDesplegada();
        registroPage.validarProducto("Macetero", "7500");
    }
}
