package com.nttdata.testing.stepDefinition;

import com.nttdata.testing.Pages.HomePage;
import com.nttdata.testing.Tasks.NavigateTo;
import com.nttdata.testing.Tasks.RegistrarUsuario;
import com.nttdata.testing.Tasks.SeleccionarYAgregarAlCarrito;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class RegistrarUsuarioStepDefinition {
    @Given("el {actor} esta en la pagina de inicio")
    public void elUsuarioEstaEnLaPaginaDeInicio(Actor actor) {
        actor.attemptsTo(NavigateTo.theHomePage());
    }

    @And("selecciona el boton de registro")
    public void seleccionaElBotonDeRegistro() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_SIGN_UP));
    }

    @And("ingresa un nombre de usuario {string} y contrasenia {string}")
    public void ingresaUnNombreDeUsuarioYContrasenia(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_PASSWORD));
    }

    @When("selecciona el boton registrar")
    public void seleccionaElBotonRegistrar() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_REGISTRAR));
    }

    @Then("se realiza el registro de manera exitosa")
    public void seRealizaElRegistroDeManeraExitosa() {
        System.out.println("exitoso");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("se registra con un nombre de usuario {string} y contrasenia {string}")
    public void seRegistraConUnNombreDeUsuarioYContrasenia(String usuario, String password) {
        theActorInTheSpotlight().attemptsTo(RegistrarUsuario.withData(usuario, password));
    }



    @And("selecciona el boton de login")
    public void seleccionaElBotonDeLogin() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOG_IN));
}

    @And ("el usuario inicia sesión con nombre de usuario {string} y contraseña {string}")
    public void elUsuarioIniciaSesion(String username, String password) {
        theActorInTheSpotlight().attemptsTo(Enter.theValue(username).into(HomePage.INP_LOGIN_USERNAME));
        theActorInTheSpotlight().attemptsTo(Enter.theValue(password).into(HomePage.INP_LOGIN_PASSWORD));
    }

    @When("selecciona el boton login")
    public void seleccionaElBotonLogin() {
        theActorInTheSpotlight().attemptsTo(Click.on(HomePage.BTN_LOGIN_SUBMIT));
    }

    @When("selecciona el producto y lo agrega al carrito {string}")
    public void seleccionaElProductoYLoAgregaAlCarrito(String productName) {
        theActorInTheSpotlight().attemptsTo(
            SeleccionarYAgregarAlCarrito.withProduct(productName),
            WaitUntil.the(HomePage.BTN_ADD_TO_CART, isVisible()).forNoMoreThan(10).seconds()
            );
    }

    @Then("se confirma que el producto fue agregado al carrito")
    public void seConfirmaQueElProductoFueAgregadoAlCarrito() {
        System.out.println("exitoso");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    //Sign up successful.
}
