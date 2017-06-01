package com.demo.service.impl;

import com.demo.service.IThisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Created by forip on 2017/6/1.
 */
@Slf4j
@Service
public class ThisServiceImpl implements IThisService {

    @Override
    public void cheese() {
        log.error("path: Who Moved My Cheese?");
    }
}
