package com.fc.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-23 15:15
 **/

@Slf4j
public class AutoPostDouyinHaiwei {

    public static AppiumDriver driver;

    /**
     * 启动APP
     * @throws MalformedURLException
     */
    public static void init() throws MalformedURLException,InterruptedException{
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

        log.info("启动APP,等待10s跳过广告");
        Thread.sleep(10000);
    }

    public static void end(){
        driver.quit();
    }


    /**
     * 发布新的抖音
     */
    public static void newPost(){

    }

    public static void todo() throws Exception{
        log.info("执行脚本逻辑");

        (new TouchAction(driver)).tap(PointOption.point(530, 1699)).perform(); Thread.sleep(1000);
        (new TouchAction(driver)).tap(PointOption.point(875, 1529)).perform(); Thread.sleep(2000);
        (new TouchAction(driver)).tap(PointOption.point(213, 422)).perform();Thread.sleep(2000);
        (new TouchAction(driver)).tap(PointOption.point(910, 1699)).perform();Thread.sleep(2000);
        (new TouchAction(driver)).tap(PointOption.point(910, 225)).perform();Thread.sleep(2000);
        (new TouchAction(driver)).tap(PointOption.point(929, 1699)).perform();

        //获取光标焦点，输入正文

    }



    public static void main( String[] args ) throws MalformedURLException, InterruptedException {

        String device = HuaweizhuanfaTest.class.getClassLoader().getResource("devices").getPath();
        String app = HuaweizhuanfaTest.class.getClassLoader().getResource("apps").getPath();

        log.debug(app,device);


        //启动APP
        init();
        boolean status = true;

        while (true){

            status = true;

            try{

                //执行脚本逻辑
                todo();

            }catch (Exception e){

                status = false;

                log.error("脚本异常,重启脚本");

                e.printStackTrace();

                init();

            }finally {
                log.info("执行结果:"+status);

                System.exit(1);
            }
        }



    }
}
