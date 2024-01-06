import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CallbackTest {
    @Test
    void shouldTest() throws InterruptedException {
        // Загрузить страницу
        open("http://localhost:9999");

        SelenideElement form = $("[method=post]");
        form.$("[data-test-id=name] input").setValue("Роман Николаевич");
        form.$("[data-test-id=phone] input").setValue("+79618610000");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".paragraph_theme_alfa-on-white").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
        //Thread.sleep(5000);
    }
}
