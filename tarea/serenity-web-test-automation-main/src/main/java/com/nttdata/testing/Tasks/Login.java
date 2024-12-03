package com.nttdata.testing.Tasks;

import com.nttdata.testing.Pages.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class Login implements Task {

    private final String username;
    private final String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.BTN_LOG_IN),
                Enter.theValue(username).into(HomePage.INP_LOGIN_USERNAME),
                Enter.theValue(password).into(HomePage.INP_LOGIN_PASSWORD),
                Click.on(HomePage.BTN_LOGIN_SUBMIT)
        );
    }

    public static Performable withData(String username, String password) {
        return new Login(username, password);
    }
}
