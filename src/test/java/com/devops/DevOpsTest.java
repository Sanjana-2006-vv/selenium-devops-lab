
package com.devops;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class DevOpsTest {

    @Test
    public void welcomeTest() throws Exception {

        WebDriver driver = null;

        try {
            ChromeOptions options = new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            String remoteUrl =
                System.getenv("SELENIUM_REMOTE_URL");

            if (remoteUrl != null && !remoteUrl.isEmpty()) {

                driver = new RemoteWebDriver(
                    new URL(remoteUrl), options
                );

            } else {

                driver = new ChromeDriver(options);

            }

            driver.get("https://example.com");

            System.out.println("Welcome to DevOps Lab");

            Assertions.assertTrue(
                driver.getTitle().contains("Example"),
                "Website title verification failed"
            );

            System.out.println("Selenium Test Passed!");

        } finally {

            if (driver != null) {
                driver.quit();
            }

        }
    }
}
