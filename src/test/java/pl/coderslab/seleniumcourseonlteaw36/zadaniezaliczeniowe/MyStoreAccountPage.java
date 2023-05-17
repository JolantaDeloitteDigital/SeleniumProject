package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreAccountPage {

    @FindBy(css = "#addresses-link")
    private WebElement addresses;

    public MyStoreAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddressesTab() {
        addresses.click();
    }
}
