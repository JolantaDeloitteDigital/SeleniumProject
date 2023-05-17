package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MyStoreSPPPage {
    @FindBy(css = "select[aria-label='Size']")
    private WebElement sizeDropdown;
    @FindBy(css = "#quantity_wanted")
    private WebElement quantitySelector;
    @FindBy(css = "button[data-button-action='add-to-cart']")
    private WebElement addToCartSPP;
    @FindBy(css = ".cart-content-btn a")
    private WebElement proceedToCheckout;
    @FindBy(css = "select[aria-label='Size'] option[title='M'")
    private WebElement sizeM;
    private WebDriver driver;
    public MyStoreSPPPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public void selectSize(String size) {
        sizeDropdown.click();
        WebElement selectedSize = driver.findElement(By.cssSelector("select[aria-label='Size'] option[title='"+size+"']"));
        selectedSize.click();
    }
    public void selectQuantity(String number) {
//        quantitySelector.sendKeys(Keys.CONTROL + "a");
//        quantitySelector.sendKeys(Keys.DELETE);
        quantitySelector.sendKeys(number);
    }
    public void clickAdToCart() {
        addToCartSPP.click();
    }
    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }
}
