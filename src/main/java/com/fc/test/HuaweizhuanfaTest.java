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

public class HuaweizhuanfaTest {

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

String[] cs = {
  "http://suo.im/6pdruE","https://j.mp/2NkyEnz","https://bit.ly/2NkyEnz","http://cn.hk.uy/hQW","http://suo.im/6pdsZo"
};

int j = 0;
int l = cs.length;


            for(int i=0;i<999;i++){


//                String title =  driver.findElementById("com.ss.android.ugc.aweme:id/title").getText();
//                System.out.println("title："+title);
//
//                String sCount =  driver.findElementById("com.ss.android.ugc.aweme:id/aq2").getText();
//                System.out.println("点赞数："+sCount);

                //暂停视频播放暂停视频播放
                System.out.println("暂停视频播放");
                (new TouchAction(driver)).tap(PointOption.point(554, 778)).perform();

                String cCount =  driver.findElementById("com.ss.android.ugc.aweme:id/aaf").getText();
                System.out.println("评论数："+cCount);

                System.out.println("点击留言按钮");
                    MobileElement el1 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aao");
                    el1.click();
                    //Thread.sleep(500);



                //System.out.println("点击留言框");
            //        MobileElement el2 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/ef");
            //        el2.click();






                if(i>99999){



                    if(!cCount.equals("0")){
                        //如果评论不为0则需要点击一下评论框
                        (new TouchAction(driver)).tap(PointOption.point(395, 1719)).perform();
                    }

                    //留言
                    System.out.println("输入留言内容");
                    MobileElement el3 = (MobileElement) driver.findElementById("com.ss.android.ugc.aweme:id/aaj");
                    if(j>=l){
                        j=0;
                    }

                    el3.sendKeys(cs[j]);
                    j++;

                }else{
                    //转发

                    if(cCount.equals("0")){
                        i--;
                        continue;
                    }

                    //点击@
                    (new TouchAction(driver)).tap(PointOption.point(871, 1707)).perform();
                    //选择第一个人
                    Thread.sleep(1000);
                    (new TouchAction(driver)).tap(PointOption.point(294, 178)).perform();


                    //选中转发按钮
                    ///driver.findElementById("com.ss.android.ugc.aweme:id/a42").click();
                }





                    //Thread.sleep(500);

                    Thread.sleep(1000);
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
