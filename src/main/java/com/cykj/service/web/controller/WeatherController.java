package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cykj.service.entity.WeatherPrediction;
import com.cykj.service.web.service.WeatherPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author yangsq
 * @date 2018/7/19 16:03.
 */
@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherPredictionService predictionService;

    @RequestMapping(value = "/getWeather",produces = "text/html;charset=UTF-8")
    private @ResponseBody String getWeather(String city){
        WeatherPrediction prediction = predictionService.findWeatherPredictionByCity(city);
        JSONArray array = JSON.parseArray(prediction.getPrediction7D());
        return array.toJSONString();
    }

}
