package org.example.webstore;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class RestaurantStoreTest {

    private WebDriver driver;
    private WebStoreMainPage webStoreMainPage;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webStoreMainPage = new WebStoreMainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(1000);
    }

    @Test
    public void testSearchAndModifyCart() throws InterruptedException {
        boolean testPassed = false;
        try {
            driver.get("https://www.webstaurantstore.com/");
            Thread.sleep(1000);

            webStoreMainPage.searchBar.sendKeys("stainless work table");
            Thread.sleep(1000);
            webStoreMainPage.searchBar.submit();

            wait.until(ExpectedConditions.visibilityOfAllElements(webStoreMainPage.searchResult));
            Thread.sleep(1000);

            for (WebElement item : webStoreMainPage.searchResult) {
                Assertions.assertTrue(item.getText().contains("Table"), "Item does not contain 'Table'");
            }
            Thread.sleep(1000);

            if (webStoreMainPage.addToCart.isEmpty()) {
                throw new IllegalStateException("No Add to Cart buttons found");
            }

            WebElement lastAddToCartButton = webStoreMainPage.addToCart.get(webStoreMainPage.addToCart.size() - 1);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", lastAddToCartButton);
            Thread.sleep(1000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", lastAddToCartButton);
            Thread.sleep(1000);

            WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/cart')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartButton);
            Thread.sleep(1000);

            WebElement emptyCartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(), 'Empty Cart')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", emptyCartButton);
            Thread.sleep(1000);

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emptyCartButton);
            Thread.sleep(1000);

            testPassed = true;
        } finally {
            if (testPassed) {
                System.out.println("Test completed successfully.");
            } else {
                System.out.println("Test failed.");
            }
            Thread.sleep(1000);
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        if (driver != null) {
            driver.quit();
        }
    }
}