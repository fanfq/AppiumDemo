package com.fc.hiauto;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-30 16:53
 **/

@Slf4j
public class OneplusAutoPost implements Runnable{

    public static AppiumDriver driver;
    public static boolean status = true;
    public static List<String> msgs;
    public static Device device;

    public OneplusAutoPost(List<String> msgs_,Device device_){
        if(device_!=null){
            device = device_;
        }

        if(msgs_!=null){
            msgs = msgs_;
        }
    }


    /**
     * 启动APP
     * @throws MalformedURLException
     */
    public static void init( List<String> msgs_,Device device_ ) throws MalformedURLException,InterruptedException{

        if(device_!=null){
            device = device_;
        }


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", device.getDeviceName());
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", device.getPlatformVersion());
        capabilities.setCapability("appPackage", "com.ss.android.ugc.aweme");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("noReset", "true");
        driver = new  AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        log.info("启动APP,等待10s跳过广告");
        Thread.sleep(10000);

        status = true;
        if(msgs_!=null){
            msgs = msgs_;
        }



        autoPost();
    }



    public static void autoPost(){

        int size = msgs.size();
        int index = 0;
        int count = 0;

        try{

            while (status) {
                Thread.sleep(1000);
                log.debug("暂停视频播放");
                (new TouchAction(driver)).tap(PointOption.point(554, 778)).perform();

                String cCount =  driver.findElementById("com.ss.android.ugc.aweme:id/ab4").getText();
                log.debug("评论数："+cCount);

                log.debug("点击留言按钮");
                MobileElement el1 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/abd");
                el1.click();

                if(!cCount.equals("0")){
                    //如果评论不为0则需要点击一下评论框
                    //(new TouchAction(driver)).tap(PointOption.point(395, 1719)).perform();
                    driver.findElementById("com.ss.android.ugc.aweme:id/pc").click();
                }

                log.debug("输入留言内容:"+msgs.get(index));
                MobileElement el3 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ab8");


                el3.sendKeys(msgs.get(index));
                index++;

                if(index >= size){
                    index = 0;
                }

                Thread.sleep(1000);
                log.debug("提交留言");
                MobileElement el4 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/abr");
                el4.click();

                log.debug("返回按钮");
                driver.navigate().back();

                log.debug("滑屏下一条");
                //(new TouchAction(driver)).press(PointOption.point(883,664)).moveTo(PointOption.point(839,1058)).release().perform();
                Thread.sleep(500);
                (new TouchAction(driver)).longPress(PointOption.point(400,1800)).moveTo(PointOption.point(400,400)).release().perform();
                log.info("已完成 "+count++ +" =================");
            }

        }catch (Exception e){
            log.error("脚本异常");

            e.printStackTrace();

            status = false;

            try{
                init(null,null);
            }catch (Exception e1){

            }
        }

    }


    @Override
    public void run( ) {
        try {
            init(  null,null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
