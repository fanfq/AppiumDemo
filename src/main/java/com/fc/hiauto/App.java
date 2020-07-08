package com.fc.hiauto;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-30 10:16
 **/

@Slf4j
public class App {

    private static String resources;

    public static void main(String[] args){

        log.info(System.getProperty("os.name"));
        log.info("test");

        //mvn clean package
        //conf 目录要与 .jar 放在一起
        //for prod java -jar xxx.jar prod
        try{
            if(args[0].equals("prod")){
                resources = System.getProperty("user.dir") + File.separator + "conf" + File.separator+"msg/msg.txt";
            }
        }catch (Exception e){
            log.error("prod v");
            resources = ClassLoader.getSystemResource("msg/msg.txt").getPath();
        }

        List<String> devices = getDevices();
        if(devices == null){
            System.exit(1);
        }

        List<String> msgs = getMsgs();
        for (String ls : msgs) {
            log.debug(ls);
        }


        for(String ls:devices){
            log.debug(ls);

            try {
                ///OneplusAutoPost.init(msgs,new Device("5c66f724","10"));
                //HuaweiAutoPost.init(msgs,new Device("S9B7N17929004588","8.0.0"));

                if (ls.equals("S9B7N17929004588")) {
                    Runnable runnable = new HuaweiAutoPost(msgs, new Device("S9B7N17929004588", "8.0.0"));
                    Thread thread = new Thread(runnable);
                    thread.start();
                }

                if (ls.equals("5c66f724")) {
                    Runnable runnable2 = new OneplusAutoPost(msgs, new Device("5c66f724", "10"));
                    Thread thread2 = new Thread(runnable2);
                    thread2.start();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 读取留言信息
     * @return
     */
    public static List<String> getMsgs(){

        List<String> list = new ArrayList<String>();
        try
        {
            String encoding = "GBK";

            //mvn clean package
            //conf 目录要与 .jar 放在一起
            //for prod java -jar xxx.jar prod


            log.debug(resources);
            //String filePath = ClassLoader.getSystemResource(resources+"msg/msg.txt").getPath();
            //log.debug(filePath);

            File file = new File(resources);
            if (file.isFile() && file.exists())
            { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            }
            else
            {
                System.out.println("找不到指定的文件");
            }
        }
        catch (Exception e)
        {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 读取设备
     * @return
     */
    public static List<String> getDevices(){

        List<String> devices = new ArrayList<>();

        try{
            Process process = Runtime.getRuntime().exec("adb devices");

            //取得命令结果的输出流
            InputStream fis=process.getInputStream();
            //用一个读输出流类去读
            InputStreamReader isr=new InputStreamReader(fis);
            //用缓冲器读行
            BufferedReader br=new BufferedReader(isr);
            String line=null;
            //直到读完为止

            int count = 0;
            while((line=br.readLine())!=null)
            {
                if(count!=0 && StringUtils.isNotBlank(line)){
                    devices.add(line.split("\t")[0]);
                }

                count ++;
            }

            return devices;

        }catch (IOException e) {
            e.printStackTrace();
            log.error("adb devices error");
        }

        return null;
    }

}
