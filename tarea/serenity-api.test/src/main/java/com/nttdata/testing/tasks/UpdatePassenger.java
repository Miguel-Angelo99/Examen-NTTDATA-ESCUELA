package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Patch;

public class UpdatePassenger {
    public static Performable withName(String passengerId, String newName) {
        return Task.where("{0} actualiza el nombre del pasajero",
                Patch.to("/passenger/" + passengerId)
                        .with(request -> request
                            .header("Content-Type", "application/json")
                            .header("Accept", "application/json")
                            .body("{\"name\": \"" + newName + "\"}"))
        );
    }
}
