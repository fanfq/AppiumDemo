package com.fc.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-08 14:37
 **/

public class HuaweiTest {

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




            for(int i=0;i<10;i++){


                String title =  driver.findElementById("com.ss.android.ugc.aweme:id/title").getText();
                System.out.println("title："+title);

                String sCount =  driver.findElementById("com.ss.android.ugc.aweme:id/aq2").getText();
                System.out.println("点赞数："+sCount);

                String cCount =  driver.findElementById("com.ss.android.ugc.aweme:id/aaf").getText();
                System.out.println("评论数："+cCount);

                System.out.println("点击留言按钮");
                    MobileElement el1 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aao");
                    el1.click();
                    //Thread.sleep(500);



                System.out.println("点击留言框");
            //        MobileElement el2 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ef");
            //        el2.click();


                if(!cCount.equals("0")){
                    //如果评论不为0则需要点击一下评论框
                    (new TouchAction(driver)).tap(PointOption.point(395, 1719)).perform();
                }



                    //Thread.sleep(500);
                System.out.println("输入留言内容");
                    MobileElement el3 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aaj");
                    el3.sendKeys("哈哈2333");
                    //Thread.sleep(500);
                System.out.println("提交留言");
                    MobileElement el4 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ab2");
                    el4.click();
                    //Thread.sleep(500);

            //    //返回按钮
                System.out.println("返回按钮");
                driver.navigate().back();

                System.out.println("滑屏下一条");
                //(new TouchAction(driver)).press(PointOption.point(883,664)).moveTo(PointOption.point(839,1058)).release().perform();
                    Thread.sleep(500);
                    (new TouchAction(driver)).longPress(PointOption.point(400,1400)).moveTo(PointOption.point(400,400)).release().perform();
                System.out.println("已完成 "+i +" =================");

            }

        }catch (Exception e){
            System.out.println("异常 ");
            e.printStackTrace();
        }



    }


}
