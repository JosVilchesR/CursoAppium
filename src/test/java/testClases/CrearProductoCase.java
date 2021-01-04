package testClases;

import pages.CarruselPage;
import pages.CrearProductoPage;
import pages.RegistroPage;

public class CrearProductoCase {
    CarruselPage carruselPage = new CarruselPage();
    RegistroPage registroPage = new RegistroPage();
    CrearProductoPage crearProductoPage = new CrearProductoPage();

    String nombreProducto = "Fertilizante";
    String precioProducto = "7500";

    public void flujo() {
        carruselPage.validarVistaDesplegada();
        carruselPage.recorrerCarrusel();
        //falta...
        carruselPage.tapBtnHecho();

        registroPage.validarVistaDesplegada();
        registroPage.tapBtnMas();
        registroPage.tapBtnCrearProducto();

        crearProductoPage.validarVistaDesplegada();
        crearProductoPage.completarFormulario(nombreProducto, precioProducto);
        crearProductoPage.tapConfirmar();

        registroPage.validarVistaDesplegada();
        registroPage.ingresarTabProductos();
        registroPage.validarProducto("Fertilizante", "7500");
    }
}
