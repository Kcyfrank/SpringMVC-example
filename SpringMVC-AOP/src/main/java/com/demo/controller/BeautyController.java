package com.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by forip on 2017/6/1.
 */
@Controller
@Slf4j
@RequestMapping("/beauty")
public class BeautyController {

    @ResponseBody
    @RequestMapping("beast")
    public String beast() {
        log.error("path: beauty & beast");
        return "received";
    }
}
