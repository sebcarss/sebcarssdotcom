package com.sebcarss.home;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sebcarss on 12/08/2017.
 */
@RestController
public class Homepage {
    @RequestMapping("/")
    public String home() {
        return "sebcarss.com";
    }
}
