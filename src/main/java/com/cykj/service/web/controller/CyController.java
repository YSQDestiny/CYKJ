package com.cykj.service.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.cykj.service.base.Constants;
import com.cykj.service.entity.Disaster;
import com.cykj.service.model.Test;
import com.cykj.service.web.service.DisasterEntityService;
import com.cykj.service.web.service.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangsq
 * @date 2018/7/16 15:42.
 */
@Controller
@RequestMapping("/")
public class CyController {

    @Autowired
    WeatherInfoService weatherInfoService;
    @Autowired
    DisasterEntityService disasterEntityService;

    @RequestMapping("/index.html")
    private String toIndex(){
//        weatherInfoService.saveWeatherInfos(Constants.WEATHER_LIST);
        return "index";
    }

    @RequestMapping(value = "/test",produces = "text/html;charset=UTF-8")
    private @ResponseBody String test(){
        Test test = new Test();
        test.setMsg("测试，测试");
        return JSONObject.toJSONString(test);
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

    @RequestMapping("/property/area.html")
    private String toPropertyArea(){
        return "property/area";
    }

    @RequestMapping("/property/option.html")
    private String toPropertyOption(){
        return "property/option";
    }

    @RequestMapping("/searchDisaster")
    private String searchDisaster(){
        return "search_yhd";
    }

    @RequestMapping("/doDisasterSearch")
    private String doDisasterSearch(String city, String county, String town, Model model){
        Map<String,String> sqlMap = new HashMap<>();
        sqlMap.put("city",city);
        sqlMap.put("county",county);
        sqlMap.put("town",town);
        List<Disaster> disasterList = disasterEntityService.findDisaster(sqlMap);
        model.addAttribute("list",disasterList);
        return "search_yhd";
    }

    @RequestMapping("/downloadApp")
    private ResponseEntity<byte[]> downloadApp(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File directory = new File("");
        String courseFile = directory.getCanonicalPath();

        File file = new File(courseFile+"/src/main/webapp/WEB-INF/app/app-mock-debug.apk");
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attchement;filename=" + file.getName());
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(body, headers, statusCode);
        return entity;
    }
}
