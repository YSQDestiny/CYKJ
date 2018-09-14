package com.cykj.service.web.controller;

import com.cykj.service.base.Constants;
import com.cykj.service.web.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangsq
 * @date 2018/7/16 15:42.
 */
@Controller
@RequestMapping("/")
public class CyController {

    @Autowired
    WeatherInfoService weatherInfoService;

    @RequestMapping("/index.html")
    private String toIndex(){
//        weatherInfoService.saveWeatherInfos(Constants.WEATHER_LIST);
        return "index";
    }

    @RequestMapping("/industry.html")
    private String toIndustry(){
        return "company/industry";
    }

    @RequestMapping("/area.html")
    private String toAre(){
        return "company/area";
    }

    @RequestMapping("/options.html")
    private String toOptions(){
        return "company/options";
    }
}
