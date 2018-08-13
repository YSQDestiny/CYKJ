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
        LOCAL_MAP.put("市辖区","chengdu");
        LOCAL_MAP.put("锦江区","chengdu");
        LOCAL_MAP.put("青羊区","chengdu");
        LOCAL_MAP.put("金牛区","chengdu");
        LOCAL_MAP.put("武侯区","chengdu");
        LOCAL_MAP.put("成华区","chengdu");
        LOCAL_MAP.put("龙泉驿区","longquanyi");
        LOCAL_MAP.put("青白江区","chengdu");
        LOCAL_MAP.put("新都区","xindu");
        LOCAL_MAP.put("温江区","wenjiang");
        LOCAL_MAP.put("双流区","shuangliu");
        LOCAL_MAP.put("大邑县","dayi");
        LOCAL_MAP.put("浦江县","pujiang");
        LOCAL_MAP.put("都江堰市","dujiangyan");
        LOCAL_MAP.put("郫县","pixian");
        LOCAL_MAP.put("金堂县","jintang");
        LOCAL_MAP.put("新津","xinjin");
        LOCAL_MAP.put("彭州市","pengzhou");
        LOCAL_MAP.put("邛崃市","qionglai");
        LOCAL_MAP.put("崇州市","chongzhou");
        LOCAL_MAP.put("简阳市","jianyang");
    }

    public static void addWether(WeatherInfo weather){
        WEATHER_LIST.add(weather);
    }

}
