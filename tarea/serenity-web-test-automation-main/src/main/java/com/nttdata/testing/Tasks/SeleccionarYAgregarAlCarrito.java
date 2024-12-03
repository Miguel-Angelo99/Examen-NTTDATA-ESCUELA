package com.nttdata.testing.Tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarYAgregarAlCarrito implements Task {

    private final String productName;

    public SeleccionarYAgregarAlCarrito(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        // Seleccionar el producto por su nombre
        actor.attemptsTo(
                Click.on("//a[contains(text(),'" + productName + "')]"), // Seleccionar el producto
                WaitUntil.the("//a[text()='Add to cart']", isVisible()).forNoMoreThan(10).seconds(), // Esperar a que el botón de agregar al carrito sea visible
                Click.on("//a[text()='Add to cart']") // Agregar al carrito
        );
    }

    public static Performable withProduct(String productName) {
        return new SeleccionarYAgregarAlCarrito(productName);
    }
}
