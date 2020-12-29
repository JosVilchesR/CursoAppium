package testClases;

import pages.CarruselPage;

public class TestCarrusel {

    CarruselPage carruselPage = new CarruselPage();

    public void validaciones() {
        carruselPage.validarVistaDesplegada();
        carruselPage.validarTextoVistaCarrusel();

    }
}
