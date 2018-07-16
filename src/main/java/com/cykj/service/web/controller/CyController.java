package com.cykj.service.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangsq
 * @date 2018/7/16 15:42.
 */
@Controller
@RequestMapping("/")
public class CyController {


    @RequestMapping("/index.html")
    private String toIndex(){
        return "index";
    }

    @RequestMapping("/industry.html")
    private String toIndustry(){
        return "company/industry";
    }
}
