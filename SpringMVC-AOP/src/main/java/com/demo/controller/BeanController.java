package com.demo.controller;

import com.demo.service.IThisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by forip on 2017/5/31.
 */

@Controller
@Slf4j
@RequestMapping("/bean")
public class BeanController {

    @ResponseBody
    @RequestMapping("/Mr")
    public String bean() {
        log.error("Mr. Bean: ummm...(shakes head)");
        return "received";
    }

    @ResponseBody
    @RequestMapping("/jack")
    public String jack() {
        log.error("Gold Coins, Chicken, Harp and Giant");
        return "received";
    }

}
