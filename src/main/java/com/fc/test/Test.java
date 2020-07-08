package com.fc.test;

import java.net.MalformedURLException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;

import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-08 14:37
 **/

public class Test {

    // 定义一个私有的AppiumDriver对象driver名
//    private static AppiumDriver<WebElement> driver;

    public static AppiumDriver driver;

    public static void main( String[] args ) throws MalformedURLException, InterruptedException {


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "5c66f724");
        //capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("appPackage", "com.ss.android.ugc.aweme");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("noReset", "true");
//com.ss.android.ugc.aweme/.main.MainActivity
        //.splash.SplashActivity
        driver = new  AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        System.out.println("12332");

        Thread.sleep(10000);
for(int i=0;i<10;i++){

        MobileElement el1 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aan");
        el1.click();
        //Thread.sleep(500);
        MobileElement el2 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/pe");
        el2.click();
        //Thread.sleep(500);
        MobileElement el3 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aai");
        el3.sendKeys("2333");
        //Thread.sleep(500);
        MobileElement el4 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ab1");
        el4.click();
        //Thread.sleep(500);
////
//
////
//    //返回按钮
    driver.navigate().back();

    //(new TouchAction(driver)).press(PointOption.point(883,664)).moveTo(PointOption.point(839,1058)).release().perform();
        Thread.sleep(500);
        (new TouchAction(driver)).longPress(PointOption.point(400,1800)).moveTo(PointOption.point(400,400)).release().perform();
    System.out.println("ahha"+i);

}

        Thread.sleep(3500);


//
//        //Swipe swipe=new Swipe();
        for(int i=0;i<99;i++){
            //swipe.SwipeUp(driver);//上滑

            System.out.println(driver);

            //driver.findElementByAccessibilityId("com.ss.android.ugc.aweme:id/aqb").click();
            ///String x = UiSelector().resourceId("com.ss.android.ugc.aweme:id/ai2");
            try{
//                driver.findEdf3aa52a-6d79-473b-b8be-730697b3dcb5lementsByAndroidUIAutomator()  findElementById("com.ss.android.ugc.aweme:id/aqb").click();//  findElement(By.id("aqb")).click();//点赞

//                MobileElement el2 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme/.main.MainActivity:id/aqb");

               // driver.find_element_by_android_uiautomator('new UiSelector().resourceId("com.hpbr.bosszhipin:id/tv_tab_label")')

                //driver.findElementByAndroidUIAutomator(new UiSelector().resourceId("com.hpbr.bosszhipin:id/tv_tab_label"));
                //new UiSelector().resourceId("com.ss.android.ugc.aweme:id/aqb");
                //driver.findElementsByAndroidUIAutomator("com.ss.android.ugc.aweme:id/aqb")
                //WebElement el2 = (WebElement)  driver.findElementById("dea0593b-d4c2-441e-9f97-8263d04432c2");// driver.findElementsByAndroidUIAutomator("com.ss.android.ugc.aweme:id/aqb");//driver.findElementById("com.ss.android.ugc.aweme:id/aqb");//driver.findElementById("5149fe1d-2676-4711-afb1-e08c72862578");
                //driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"com.haitui.game.plane:id/btn_join_game\")").click(); //findElementByXPath("//android.widget.ImageView[@resource-id=\"com.ss.android.ugc.aweme:id/aqb\"]");//driver.findElementById("com.ss.android.ugc.aweme:id/aqo");


                driver.findElementById(
                        "com.ss.android.ugc.aweme:id/aqb").click();
                Thread.sleep(3000);

                System.out.println("评论按钮");

                //评论按钮
                driver.findElementById(
                        "com.ss.android.ugc.aweme:id/aan").click();
                Thread.sleep(3000);
                //留言按钮com.ss.android.ugc.aweme:id/pe

                System.out.println("留言按钮");

                driver.findElementById(
                        "com.ss.android.ugc.aweme:id/pe").click();
                Thread.sleep(3000);
                //输入留言
                System.out.println("输入留言");

                driver.findElementById(
                        "com.ss.android.ugc.aweme:id/aai").sendKeys("2333");
                Thread.sleep(3000);

                System.out.println("提交留言");
                //提交
                driver.findElementById(
                        "com.ss.android.ugc.aweme:id/ab1").click();
                Thread.sleep(3000);

                ///MobileElement el2 = (MobileElement)driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView");
                //System.out.println(el2.getText()+",");
                //el2.click();
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("id 不存在");
            }


            //(new TouchAction(driver)).press({x: 635, y: 2396}).moveTo({x: 706: y: 900}).release().perform();



            Thread.sleep(2000);
        }



//
//        driver.findElement(By.name("1")).click();
//        driver.findElement(By.name("5")).click();
//        driver.findElement(By.name("9")).click();
//        driver.findElement(By.name("delete")).click();
//        driver.findElement(By.name("+")).click();
//        driver.findElement(By.name("6")).click();
//        driver.findElement(By.name("=")).click();
//        Thread.sleep(2000);
//
//        String result = driver.findElement(By.id("com.android.calculator2:id/formula")).getText();
//        System.out.println(result);

        //driver.quit();



//        File classpathRoot = new File(System.getProperty("user.dir"));
//        File appDir = new File(classpathRoot, "resources/app/");
//        File app = new File(appDir, "test.apk");
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//
//        //添加capabilities参数，包括设备名，平台版本号，apk或者ipa文件的地址，app包名，启动的activity名
//        capabilities.setCapability("deviceName", "5c66f724");//一加7
//        capabilities.setCapability("platformVersion", "10");
//        capabilities.setCapability("app", app.getAbsolutePath());
//        capabilities.setCapability("appPackage", "com.ss.android.ugc.aweme");
//        capabilities.setCapability("appActivity", ".splash.SplashActivity}");
//
//        // 生成一个本地的AppiumDriver对象并且赋值给driver
//        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//
//        // 等待时间
//        Thread.sleep(3000);
//        // 滑动方法 swipe(int starX, int starY, int endX, int endY, time);
//        driver.swipe(608, 865, 34, 920, 1000);
//
//        // 获取classname 是android.view.View 的控件合集
//        List<WebElement> loginButton = driver.findElementsByClassName("android.view.View");
//
//        // 点击登录按钮
//        loginButton.get(0).click();
//        Thread.sleep(19000);
//
//        //关闭测试session
//        driver.quit();
    }


}
