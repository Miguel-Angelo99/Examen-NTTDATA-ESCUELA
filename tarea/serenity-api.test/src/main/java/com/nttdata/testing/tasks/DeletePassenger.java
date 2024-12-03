package com.nttdata.testing.tasks;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeletePassenger {
    public static Performable byId(String passengerId) {
        return Task.where("{0} elimina un pasajero",
                Delete.from("/passenger/" + passengerId)
                        .with(request -> request
                            .header("Content-Type", "application/json")
                            .header("Accept", "application/json"))
        );
    }
}
