package starter.training.question;

import net.serenitybdd.screenplay.questions.Text;
import starter.training.page.MyAccountPage;

public class GetText {
    public static net.serenitybdd.screenplay.Question<String> errorMessage() {
        return actor -> Text.of(MyAccountPage.ERROR_MESSAGE).answeredBy(actor);
    }
}