package com.emurugova;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;
import static com.emurugova.TestData.*;

public class WebSteps {

        @Step("Открываем главную страницу Github")
        public void openMainPage() {
            open(SITE);
        };
        @Step("Находим репозиторий {repository}")
        public void searchRepository (String repository) {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(repository);
            $(".header-search-input").submit();
        };
        @Step("Переходим в репозиторий {repository}")
        public void goIntoRepository(String repository) {
            $(linkText(repository)).click();
            sleep(3000);
        };
        @Step("Проверяем наличие названия {name} в репозитории")
        public void checkIssuesNameInRepository (String name) {
            $(withText(name)).should(Condition.exist);
        };
}

