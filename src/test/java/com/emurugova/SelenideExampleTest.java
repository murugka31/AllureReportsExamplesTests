package com.emurugova;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.emurugova.TestData.*;
import static org.openqa.selenium.By.linkText;

public class SelenideExampleTest {

    @Test
    public void testRepositoryIssue() {
        open(SITE);
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        $(linkText(REPOSITORY)).click();
        sleep(3000);
        $(withText(NAME)).should(Condition.exist);
    }
}
