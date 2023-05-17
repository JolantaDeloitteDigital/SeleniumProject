package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyStoreHomePage {
    @FindBy(css = ".user-info a")
    private WebElement signInButton;
    @FindBy(css = ".account")
    private WebElement accountInfo;
    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInput;
    @FindBy(xpath = "//span[text()='Hummingbird printed sweater']")
    private WebElement hummingBirdSweaterResult;
    public MyStoreHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickLogInButton() {
        signInButton.click();
    }
    public void clickAccountButton() {
        accountInfo.click();
    }

    public void searchForItem(String searchPhrase) {
        searchInput.sendKeys(searchPhrase);}
    public void goToSPPPageForSearchedItem() {
        hummingBirdSweaterResult.click();
    }
}
