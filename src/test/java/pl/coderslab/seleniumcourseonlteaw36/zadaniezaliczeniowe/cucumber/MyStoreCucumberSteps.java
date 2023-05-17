package pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coderslab.seleniumcourseonlteaw36.zadaniezaliczeniowe.*;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;

public class MyStoreCucumberSteps {
    String email = "ixf12630@nezid.com";
    String password = "Test123@";
    String name = "Jola Test";
    String country = "United Kingdom";
    String addressesLink = "https://mystore-testlab.coderslab.pl/index.php?controller=addresses";
    int numberOfAddressesAfterAdd;
    int numberOfAddressesBeforeAdd;
    int numberOfAddressesAfterDelete;

    private WebDriver driver;

    @Given("Page {string} opened in browser")
    public void page_opened_in_browser(String pageUrl) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
        this.driver.get(pageUrl);
    }

    @When("When Sign In button clicked")
    public void when_sign_in_button_clicked() {
        MyStoreHomePage homePage = new MyStoreHomePage(driver);
        homePage.clickLogInButton();
    }
    @When("Logged in user details entered")
    public void logged_in_user_details_entered() {
        MyStoreLogInPage logInPage = new MyStoreLogInPage(driver);
        logInPage.provideExistingUserDetails(email,password);
        logInPage.clickLogInButton();
    }
    @When("Account details button is clicked")
    public void account_details_button_is_clicked() {
        MyStoreHomePage homePage = new MyStoreHomePage(driver);
        homePage.clickAccountButton();
    }
    @When("Addresses tab is clicked")
    public void addresses_tab_is_clicked() {
        MyStoreAccountPage accountPage = new MyStoreAccountPage(driver);
        accountPage.clickAddressesTab();
    }
    @When("Add new address button is clicked")
    public void add_new_address_button_is_clicked() {
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        numberOfAddressesBeforeAdd = addressesPage.getAddedAddressesNumber();
        addressesPage.clickAddNewAddressButton();

    }
    @When("New address details are filled in with given details {string}, {string}, {string}, {string}, {string}")
    public void new_address_details_are_filled_in_with_given_details(String addressAlias, String addressAddress, String addressCity, String addressZipCode, String addressPhone) {
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        addressesPage.provideDetailsOfNewAddress(addressAlias,addressAddress,addressCity,addressZipCode,addressPhone);
    }
    @When("New address is submitted")
    public void new_address_is_submitted() {
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        addressesPage.submitAddingNewAddress();
    }
    @When("Search for {string}")
    public void search_for(String searchedItem) {
        MyStoreHomePage homePage = new MyStoreHomePage(driver);
        homePage.searchForItem(searchedItem);
    }
    @When("Click in search results")
    public void click_in_search_results() {
        MyStoreHomePage homePage = new MyStoreHomePage(driver);
        homePage.goToSPPPageForSearchedItem();
    }
    @When("Select size {string}")
    public void select_size(String size) {
        MyStoreSPPPage sppPage = new MyStoreSPPPage(driver);
        sppPage.selectSize(size);
    }
    @When("Select quantity {string}")
    public void select_quantity(String quantity) {
        MyStoreSPPPage sppPage = new MyStoreSPPPage(driver);
        sppPage.selectQuantity(quantity);
    }
    @When("Add to cart")
    public void add_to_cart() {
        MyStoreSPPPage sppPage = new MyStoreSPPPage(driver);
        sppPage.clickAdToCart();
    }
    @When("Proceed to cart")
    public void proceed_to_cart() {
        MyStoreSPPPage sppPage = new MyStoreSPPPage(driver);
        sppPage.clickProceedToCheckout();
    }
    @When("Proceed to checkout")
    public void proceed_to_checkout() {
        MyStoreCartPage cartPage = new MyStoreCartPage(driver);
        cartPage.clickProceedToCheckout();
    }
    @When("Confirm address")
    public void confirm_address() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickContinueAddress();
    }
    @When("Confirm shipping")
    public void confirm_shipping() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickContinueShipping();
    }
    @When("Select pick up in store shipping option")
    public void select_pick_up_in_store_shipping_option() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickSelfPickUpOption();
    }
    @When("Select pay by check payment option")
    public void select_pay_by_check_payment_option() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickPayByCheckOption();
    }
    @When("Agree to terms and conditions")
    public void agree_to_terms_and_conditions() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickTermsAndConditionsOption();
    }
    @When("Confirm order")
    public void confirm_order() {
        MyStoreCheckoutPage checkoutPage = new MyStoreCheckoutPage(driver);
        checkoutPage.clickPlaceOrder();
    }
    @Then("New address details match added address details {string}, {string}, {string}, {string}, {string}")
    public void new_address_details_match_added_address_details(String addressAlias, String addressAddress, String addressCity, String addressZipCode, String addressPhone) {
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        numberOfAddressesAfterAdd = addressesPage.getAddedAddressesNumber();
        if (numberOfAddressesAfterAdd > numberOfAddressesBeforeAdd) {
            String gottenAddress = addressesPage.getAddedAddressesDetails();
            String toCompare = addressAlias +"\n"+ name +"\n"+addressAddress +"\n"+addressCity+"\n"+addressZipCode+"\n"+country+"\n"+addressPhone;
            if (!toCompare.equals(gottenAddress)){
                Assertions.fail("Added does not match! "+ gottenAddress);
            }
        }
    }

    @Then("Delete just added address")
    public void delete_just_added_address() {
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        addressesPage.deleteLatestAddedAddress();
        numberOfAddressesAfterDelete = addressesPage.getAddedAddressesNumber();
    }

    @Then("Check if address was deleted")
    public void check_if_address_was_deleted(){
        MyStoreAddressesPage addressesPage = new MyStoreAddressesPage(driver);
        addressesPage.getAddedAddressesNumber();
        if (numberOfAddressesBeforeAdd != numberOfAddressesAfterDelete){
            Assertions.fail("Added address was not deleted!");
        }
    }
    @Then("Save Screenshot")
    public void takeScreenshot() throws IOException {
//Take screenshot (will be saved in default location) and automatically removed after test
        File tmpScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//Copy the screenshot to desired location
//Path to the location to save screenshot
//(directory for screenshots MUST exist: C:\test-evidence) e.g.:
        String currentDateTime = LocalDateTime.now().toString().replaceAll(":", "_");
        // new three classes that we use below: Files, Path, Paths
        Files.copy(tmpScreenshot.toPath(), Paths.get("C:", "Users", "jszajnowska", "CodersLab", "qwant-search-"+currentDateTime+".png"));
    }
    @Then("Close browser")
    public void closeBrowser() {
        driver.quit();
    }

}
