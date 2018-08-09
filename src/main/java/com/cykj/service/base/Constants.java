package com.cykj.service.base;

import com.cykj.service.entity.Weather;
import com.cykj.service.entity.WeatherInfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/6/6 16:35.
 */
public class Constants {

    public static List<String> accountCode = new ArrayList<String>();
    public static List<String> goodInfoCode = new ArrayList<String>();
    public static List<WeatherInfo> WEATHER_LIST = new ArrayList<>();

    public static final String CURRENT_USER = "user";
    public static final String TOTALS = "total";
    public static final String ROWS = "rows";

    public static Map<String,String> LOCAL_MAP = new HashMap<>();
    static {
        LOCAL_MAP.put("大邑县","dayi");
        LOCAL_MAP.put("浦江县","pujiang");
        LOCAL_MAP.put("都江堰市","dujiangyan");
        LOCAL_MAP.put("郫县","郫县");
    }

    public static void addWether(WeatherInfo weather){
        WEATHER_LIST.add(weather);
    }

}
