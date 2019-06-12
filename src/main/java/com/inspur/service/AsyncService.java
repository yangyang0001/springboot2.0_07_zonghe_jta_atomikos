package com.inspur.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * User: YANG
 * Date: 2019/6/13-1:03
 * Description: No Description
 */

@Service
@Slf4j
public class AsyncService {

    @Async
    public String getIndex() throws InterruptedException {
        log.info("3");
        Thread.sleep(5000);
        log.info("4");
        return "async result";
    }
}
