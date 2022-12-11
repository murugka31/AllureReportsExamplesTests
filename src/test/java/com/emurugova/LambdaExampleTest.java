package com.emurugova;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static com.emurugova.TestData.*;

public class LambdaExampleTest {

    @Test
    public void testRepositoryIssue() {
        step("Открываем главную страницу Github", () -> {
            open(SITE);
        });
        step("Находим репозиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
            sleep(3000);
        });
        step("Проверяем наличие названия " + NAME + " в репозитории " + REPOSITORY, () -> {
            $(withText(NAME)).should(Condition.exist);
        });
    }
}
