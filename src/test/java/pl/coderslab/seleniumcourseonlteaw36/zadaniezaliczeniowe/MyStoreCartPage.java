package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreCartPage {
    @FindBy(css = ".checkout a")
    private WebElement proceedToCheckout;
    public MyStoreCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }
}
