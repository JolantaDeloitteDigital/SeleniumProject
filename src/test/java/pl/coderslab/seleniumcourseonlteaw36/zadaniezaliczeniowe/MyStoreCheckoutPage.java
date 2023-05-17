package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreCheckoutPage {

    @FindBy (css = "button[name='confirm-addresses']")
    WebElement addressContinueButton;
    @FindBy (css = "#js-delivery .continue")
    WebElement shippingContinueButton;
    @FindBy (css = "#delivery_option_8 + span")
    WebElement selfPickUpOption;
    @FindBy (css = "label[for='payment-option-1']")
    WebElement payByCheckOption;
    @FindBy (css = "#conditions-to-approve input")
    WebElement termsAndConditionsCheckbox;
    @FindBy (css = "#payment-confirmation button")
    WebElement placeOrderButton;

    public MyStoreCheckoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContinueAddress() {
        addressContinueButton.click();
    }
    public void clickContinueShipping() {
        shippingContinueButton.click();
    }
    public void clickSelfPickUpOption() {
        selfPickUpOption.click();
    }
    public void clickPayByCheckOption() {
        payByCheckOption.click();
    }
    public void clickTermsAndConditionsOption() {
        termsAndConditionsCheckbox.click();
    }

    public void clickPlaceOrder() {
        placeOrderButton.click();
    }
}
