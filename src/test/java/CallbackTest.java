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
        //Thread.sleep(5000);
        SelenideElement form = $("[id=root]");
        form.$("[data-test-id=name] input").setValue("Роман Николаевич");
        form.$("[data-test-id=phone] input").setValue("+79618610000");
        form.$("[data-test-id=agreement]").click();
        form.$("[role=button]").click();
        $(".Success_successBlock__2L3Cw").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));

    }
}