package com.emurugova;

import org.junit.jupiter.api.Test;
import static com.emurugova.TestData.*;

public class AnnotatedStepExampleTest {

    private final WebSteps step = new WebSteps();

    @Test
    public void shouldBeNameInRepository () {
        step.openMainPage();
        step.searchRepository(REPOSITORY );
        step.goIntoRepository(REPOSITORY );
        step.checkIssuesNameInRepository(NAME);
    }
}
