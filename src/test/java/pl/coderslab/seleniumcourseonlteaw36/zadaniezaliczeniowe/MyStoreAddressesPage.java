package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyStoreAddressesPage {
    @FindBy(css = "a[data-link-action='add-address']")
    private WebElement addNewAddress;
    @FindBy(css = "#field-alias")
    private WebElement addressAlias;
    @FindBy(css = "#field-address1")
    private WebElement addressAddress;
    @FindBy(css = "#field-city")
    private WebElement addressCity;
    @FindBy(css = "#field-postcode")
    private WebElement addressZipCode;
    @FindBy(css = "#field-phone")
    private WebElement addressPhone;
    @FindBy(css = "input[name='submitAddress'] + button")
    private WebElement addressSubmit;
    @FindBy(css = "a[data-link-action='delete-address']")
    private List<WebElement> deleteAddress;
    @FindBy(css = "div.address-body h4")
    private List<WebElement> addressHeader;
    @FindBy(css = "div.address-body address")
    private List<WebElement> addressBody;


    public MyStoreAddressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickAddNewAddressButton() {
        addNewAddress.click();
    }

    public void provideDetailsOfNewAddress(String alias, String address, String city, String zipCode, String phone) {
        addressAlias.sendKeys(alias);
        addressAddress.sendKeys(address);
        addressCity.sendKeys(city);
        addressZipCode.sendKeys(zipCode);
        addressPhone.sendKeys(phone);
    }

    public void submitAddingNewAddress() {
        addressSubmit.click();
    }

    public void getdetailsOfLatestAddedAddress() {

    }

    public void deleteLatestAddedAddress() {
        if (deleteAddress.size() > 1) {
            (deleteAddress.get(deleteAddress.size() -1)).click();
        } else {
            System.out.println("There is no second address to delete");
        }
    }
    public int getAddedAddressesNumber() {
        return deleteAddress.size();
    }

    public String getAddedAddressesDetails() {
        String alias = addressHeader.get(addressHeader.size()-1).getText();
        String details = addressBody.get(addressBody.size()-1).getText();
        return alias + "\n" + details;
    }
}
