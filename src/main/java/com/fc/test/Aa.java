package com.fc.test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-10 16:51
 **/

public class Aa {

    private static AndroidDriver driver;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "10");
        desiredCapabilities.setCapability("deviceName", "5c66f724");
        desiredCapabilities.setCapability("appPackage", "com.haitui.game.plane");
        desiredCapabilities.setCapability("appActivity", "org.cocos2dx.javascript.AppActivity");
        desiredCapabilities.setCapability("noReset", "true");
//        desiredCapabilities.setCapability("automationName", "UiAutomator");
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

//["id","com.haitui.game.plane:id/btn_join_game","5077f25a-3bb5-4794-a418-13aad6a99d68"]
//        List<MobileElement> el1 =  driver.findElements(By.id("com.haitui.game.plane:id/btn_join_game"));
//        System.out.println(el1.size());

        Thread.sleep(5000);
        MobileElement el1 =  (MobileElement) driver.findElement(By.id("com.haitui.game.plane:id/btn_join_game"));
        el1.click();
    }
}
