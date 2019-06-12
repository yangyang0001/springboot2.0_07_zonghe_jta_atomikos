package com.inspur.controller;

import com.inspur.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: YANG
 * Date: 2019/6/13-1:02
 * Description: No Description
 */

@RestController
@Slf4j
public class AsyncController {

    @Autowired
    private AsyncService asyncService;
    //在初始化的时候 进行赋值
    @Value("${myname}")
    private String name;

    @Value("${http_url}")
    private String httpURL;


    @RequestMapping("/getIndex")
    public String getIndex(){
        String result = null;
        try {
            log.info("1");
            result = asyncService.getIndex();
            log.info("2");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/getName")
    public String getName(){
        return name;
    }

    @RequestMapping("/getHttpURL")
    public String getHttpURL() {
        return httpURL;
    }
}
