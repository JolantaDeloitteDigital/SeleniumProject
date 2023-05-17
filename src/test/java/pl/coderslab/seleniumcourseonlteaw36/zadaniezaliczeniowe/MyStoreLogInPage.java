package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreLogInPage {
    @FindBy(css = "#field-email")
    private WebElement userEmailInput;

    @FindBy(css = "#field-password")
    private WebElement userPasswordInput;

    @FindBy(css = "#submit-login")
    private WebElement submitLogIn;


    public MyStoreLogInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void provideExistingUserDetails(String login, String pswd) {
        userEmailInput.sendKeys(login);
        userPasswordInput.sendKeys(pswd);
    }

    public void clickLogInButton() {
        submitLogIn.click();
    }
}
