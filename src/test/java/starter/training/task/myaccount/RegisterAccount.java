package starter.training.task.myaccount;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import starter.training.help.WaitABit;
import starter.training.page.HomePage;
import starter.training.page.MyAccountPage;

public class RegisterAccount implements Task {
    private final String email;
    private final String password;

    public RegisterAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public static RegisterAccount inputData(String email, String password) {
        return Tasks.instrumented(RegisterAccount.class, email, password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePage.MY_ACCOUNT),
                Enter.theValue(email).into(MyAccountPage.TXT_EMAIL),
                WaitABit.sleep(5000),
                Enter.theValue(password).into(MyAccountPage.TXT_PASSWORD),
                Click.on(MyAccountPage.BTN_REGISTER)
        );
    }
}
