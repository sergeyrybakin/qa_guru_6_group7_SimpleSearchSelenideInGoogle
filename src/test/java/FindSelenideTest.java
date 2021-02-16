import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FindSelenideTest
{
    @Test
    void findSelenideInGoogle() {
        open("https://google.com");
        $("[name=q]").click();
        $("[name=q]").val("selenide").submit();
        $$("#res .g").shouldHave(sizeGreaterThan(1));
        $("#res .g").shouldHave(text("selenide.org"));
    }

    @Test
    void findSelenideInYandex() {
        open("https://yandex.ru/");
        $("#text").setValue("Selenide").pressEnter();
        $$("#search-result").findBy(text("ru.selenide.org")).shouldBe(visible);
    }
}
