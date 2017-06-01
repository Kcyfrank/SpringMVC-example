package com.demo.controller;

import com.demo.service.IThisService;
import com.demo.service.impl.ThisServiceImpl;
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
@RequestMapping("/this")
public class ThisController {

    @Autowired
    private IThisService thisService;

    /**
     * ThisController 下的 ThisService 方法
     */
    @ResponseBody
    @RequestMapping("/cheese")
    public String cheese() {
        thisService.cheese();
        return "received";
    }

}
