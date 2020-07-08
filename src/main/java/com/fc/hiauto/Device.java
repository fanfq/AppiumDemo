package com.fc.hiauto;

import lombok.Getter;
import lombok.Setter;

/**
 * @program: AppiumDemo
 * @description:
 * @author: fangqing.fan#hotmail.com
 * @create: 2020-06-30 17:43
 **/

@Getter
@Setter
public class Device {

    private String deviceName;
    private String platformVersion;

    public Device(){}

    public Device(String deviceName,String platformVersion){
        this.deviceName = deviceName;
        this.platformVersion = platformVersion;
    }

}
