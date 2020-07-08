package com.fc.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import lombok.extern.slf4j.Slf4j;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-08 14:37
 **/

public class HuaweiSearchFllowTest {

    // 定义一个私有的AppiumDriver对象driver名
//    private static AppiumDriver<WebElement> driver;

    public static AppiumDriver driver;

    public static void main( String[] args ) throws MalformedURLException, InterruptedException {




        try{

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("deviceName", "S9B7N17929004588");
            //capabilities.setCapability("automationName", "Appium");
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("platformVersion", "8.0.0");
            capabilities.setCapability("appPackage", "com.ss.android.ugc.aweme");
            capabilities.setCapability("appActivity", ".main.MainActivity");
            capabilities.setCapability("noReset", "true");
//com.ss.android.ugc.aweme/.main.MainActivity
            //.splash.SplashActivity
            driver = new  AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);



            Thread.sleep(10000);

            System.out.println("********** 脚本开始 ");

            //点击搜索按钮
            (new TouchAction(driver)).tap(PointOption.point(972, 139)).perform();

            //输入搜索内容
            MobileElement el3 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ai4");
            el3.sendKeys("fredtv");

            //点击搜索按钮
            (new TouchAction(driver)).tap(PointOption.point(972, 1690)).perform();

            //获取频道名
            String title =  driver.findElementById("com.ss.android.ugc.aweme:id/grh").getText();
            System.out.println("title："+title);

            //点击关注

            String x = driver.findElementById("com.ss.android.ugc.aweme:id/zk").getText();//.click();
            System.out.println("是否关注："+x);

        }catch (Exception e){
            System.out.println("异常 ");
            e.printStackTrace();
        }



    }


}
