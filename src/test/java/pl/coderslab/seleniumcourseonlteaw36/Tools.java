package pl.coderslab.seleniumcourseonlteaw36;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.UUID;

public class Tools {
    public static void assertVisibleAndEnabled(WebElement element) {
        if (!element.isDisplayed() || !element.isEnabled()) {
            Assertions.fail("element not visible or not enabled");
        }
    }

    public static String generateRandomEmail() {
        return UUID.randomUUID().toString() + "@mail.pl";
    }
}