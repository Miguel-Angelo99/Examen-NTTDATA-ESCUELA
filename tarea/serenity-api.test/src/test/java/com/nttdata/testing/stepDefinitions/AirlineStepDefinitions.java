package com.nttdata.testing.stepDefinitions;

import com.nttdata.testing.questions.ResponseCode;
import com.nttdata.testing.questions.ResponseMessage;
import com.nttdata.testing.tasks.DeletePassenger;
import com.nttdata.testing.tasks.GetAirlines;
import com.nttdata.testing.tasks.PostAirline;
import com.nttdata.testing.tasks.UpdatePassenger;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;

public class AirlineStepDefinitions {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("el {actor} establece el endpoint para obtener las aerolineas")
    public void elActorEstableceElEndpointParaObtenerLasAerolineas(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("el {actor} envia una solicitud GET")
    public void elActorEnviaUnaSolicitudGET(Actor actor) {
        actor.attemptsTo(GetAirlines.fromEndpoint("/airlines"));
    }

    @Then("el codigo de respuesta deberia ser {int}")
    public void elCodigoDeRespuestaDeberiaSer(int responseCode) {
        theActorInTheSpotlight().should(seeThat("El código de respuesta", ResponseCode.getStatus(), equalTo(responseCode)));
    }

    @Then("el código de respuesta debería ser {int}")
    public void elCódigoDeRespuestaDeberiaSer(int expectedStatusCode) {
        theActorInTheSpotlight().should(seeThat("el código de respuesta", ResponseCode.getStatus(), equalTo(expectedStatusCode))
    );
}

    @Given("el {actor} establece el endpoint POST para crear una aerolínea")
    public void elActorEstableceElEndpointPOSTParaCrearUnaAerolínea(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @When("envía una solicitud HTTP POST con los datos {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void envíaUnaSolicitudHTTPPOSTConLosDatos(String _id, String name, String country, String logo, String slogan, String head_quaters, String website, String established) {
        theActorInTheSpotlight().attemptsTo(PostAirline.fromPage(_id, name, country, logo, slogan, head_quaters, website, established));
    }

    @When("el {actor} elimina el pasajero con ID {string}")
    public void elActorEliminaElPasajero(Actor actor, String passengerId) {
        actor.attemptsTo(DeletePassenger.byId(passengerId));
    }

    @When("el {actor} actualiza el nombre del pasajero con ID {string} a {string}")
    public void elActorActualizaElNombreDelPasajero(Actor actor, String passengerId, String newName) {
        actor.attemptsTo(UpdatePassenger.withName(passengerId, newName));
    }

    @Given("el {actor} establece el endpoint para eliminar un pasajero")
    public void elActorEstableceElEndpointParaEliminarUnPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }

    @Given("el {actor} establece el endpoint para actualizar un pasajero")
    public void elActorEstableceElEndpointParaActualizarUnPasajero(Actor actor) {
        actor.whoCan(CallAnApi.at("https://api.instantwebtools.net/v1"));
    }
}
