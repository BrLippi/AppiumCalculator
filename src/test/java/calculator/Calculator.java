package calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Calculator {

    private AndroidDriver <MobileElement> driver; // precisa colocar o mobile element aqui

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        //desiredCapabilities.setCapability("platformName", "Android");
        //desiredCapabilities.setCapability("platformVersion", "10.0");
       // desiredCapabilities.setCapability("automationName", "UIAutomator2");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        //desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
       //desiredCapabilities.setCapability("", "c37d5067-32cf-470e-8471-e8b7d897c25e"); //nuvem

        //desiredCapabilities.setCapability("deviceName", "emulator5554"); dispositivo fisico padrao
        desiredCapabilities.setCapability("deviceName", "Samsung_Galaxy_S9_free");//dispositivo nuvem

        //URL remoteUrl = new URL("http://localhost:4723/wd/hub"); //local
        URL remoteUrl = new URL("https://app.saucelabs.com/live/mobile/dataCenters/US/devices/Samsung_Galaxy_S9_free/shared/c37d5067-32cf-470e-8471-e8b7d897c25e");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void somaDoisNumeros() {
        MobileElement btn9 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_9");
        btn9.click();
        MobileElement somar = (MobileElement) driver.findElementByAccessibilityId("plus");
        somar.click();
        MobileElement btn1 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_1");
        btn1.click();
        MobileElement btnigual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnigual.click();
        MobileElement display = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        Assert.assertEquals("10",display.getText());
    }

    @After
    public void Fechar() {
        driver.quit();
    }
}